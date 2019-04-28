package business.control;

import java.util.Map;
import business.model.*;
import business.model.reports.PoliceReport;
import infra.PoliceReportDAO;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import util.*;

/**
 * Responsible for police report business rules.
 * Facade.
 */
public class PoliceReportControl {
	
    private final PoliceReportDAO police_reportDAO;
	private int current_id;
    
    public PoliceReportControl(PoliceReportDAO police_reportDAO){
        this.police_reportDAO = police_reportDAO;
		this.current_id = 0;
    }
    
	public int add(
			String plaintiff_cpf,
			String plaintiff_name,
			String plaintiff_sex,
			Class report_type,
			String address,
			LocalDateTime reported_date_time,
			Map<String, String> details) throws InfraException {
		// Keep track of ID numbers
		int id = current_id;
		current_id++;
		
		// Instantiate plaintiff
		Plaintiff plaintiff = new Plaintiff(plaintiff_cpf, plaintiff_name, plaintiff_sex);
		
		// Instantiate the specificied police report type
		PoliceReport police_report;
		try {
			police_report = (PoliceReport)report_type.newInstance();
		} catch (InstantiationException | IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}
		
		// Set fields
		police_report.setPlaintiff(plaintiff);
		police_report.setAddress(address);
		police_report.setReported_date_time(reported_date_time);
		police_report.setRegistered_date_time(LocalDateTime.now());
		
		// Send to DAO and return id of the newly added police report
		police_reportDAO.addPoliceReport(police_report);
		return id;
	}
	
    public void del(int id) throws NoSuchElementException, InfraException {
        if(!police_reportDAO.getPoliceReports().containsKey(id)){
            throw new NoSuchElementException("Usuário não existe.");
        }

        police_reportDAO.deletePoliceReport(id);
    }
    
    public Map<Integer, PoliceReport> getPoliceReports() throws InfraException {
        return police_reportDAO.getPoliceReports();
    }
}
