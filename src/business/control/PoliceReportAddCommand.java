/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import business.model.Plaintiff;
import business.model.reports.PoliceReport;
import infra.PoliceReportDAO;
import infra.ReportFile;
import java.time.LocalDateTime;
import java.util.Map;
import util.InfraException;

/**
 *
 * @author aluno
 */
public class PoliceReportAddCommand implements Command {
    
    private PoliceReportDAO DAO;
    private ReportFile report_file;
    
    public PoliceReportAddCommand(PoliceReportDAO DAO, ReportFile report_file) {
        this.DAO = DAO;
        this.report_file = report_file;
    }
    
    @Override
    public Object execute(Map<String, Object> args) throws InfraException {
        // Instantiate plaintiff
        Plaintiff plaintiff = new Plaintiff(
                (String) args.get("plaintiff_cpf"),
                (String) args.get("plaintiff_name"),
                (String) args.get("plaintiff_sex")
            );

        // Instantiate the specificied police report type
        PoliceReport police_report;
        try {
            police_report = (PoliceReport) ((Class)args.get("report_type")).newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }

        // Set fields
        police_report.setId((Integer) args.get("id"));
        police_report.setIs_open(true);
        police_report.setPlaintiff(plaintiff);
        police_report.setAddress((String) args.get("address"));
        police_report.setReported_date_time((LocalDateTime) args.get("reported_date_time"));
        police_report.setRegistered_date_time(LocalDateTime.now());

        // Send to DAO and return id of the newly added police report
        DAO.addPoliceReport(police_report);
        report_file.getAddedPR(police_report);
        
        return police_report;
    }
    
}
