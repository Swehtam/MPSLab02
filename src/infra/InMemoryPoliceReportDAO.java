/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import business.model.Plaintiff;
import business.model.reports.PoliceReport;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * This DAO doesn't persist anywhere - it stays in memory only.
 * @author samueldemoura
 */
public class InMemoryPoliceReportDAO implements PoliceReportDAO {
    
    private Map<Integer, PoliceReport> police_reports;
	private int current_id = 0;
    
    public InMemoryPoliceReportDAO() {
        police_reports = new HashMap();
    }
    
    @Override
    public int addPoliceReport(Class type, String local_type, Plaintiff plaintiff, 
			String address, LocalDateTime report_DateTime) {
		PoliceReport police_report;
		
		try {
			police_report = (PoliceReport)type.newInstance();
		} catch (InstantiationException | IllegalAccessException ex) {
			Logger.getLogger(InMemoryPoliceReportDAO.class.getName()).log(Level.SEVERE, null, ex);
			throw new RuntimeException(ex);
		}
		
		int id = current_id;
		current_id++;
		
		police_report.setLocal_type(local_type);
		police_report.setPlaintiff(plaintiff);
		police_report.setAddress(address);
		police_report.setReport_DateTime(report_DateTime);
		police_report.setRegistered_DateTime(LocalDateTime.now());
        police_reports.put(id, police_report);
		
		return id;
    }

    @Override
    public void deletePoliceReport(int id) {
        police_reports.remove(id);
    }

    @Override
    public Map<Integer, PoliceReport> getPoliceReports() {
        return police_reports;
    }

    @Override
    public void commit() {
        System.out.println("INMEMORY does not commit anywhere.");
    }
}
