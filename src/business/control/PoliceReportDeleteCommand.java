/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import business.model.reports.PoliceReport;
import infra.PoliceReportDAO;
import infra.ReportFile;
import java.util.Map;
import java.util.NoSuchElementException;
import util.InfraException;

/**
 *
 * @author aluno
 */
public class PoliceReportDeleteCommand implements Command {
    
    private PoliceReportDAO DAO;
    private ReportFile report_file;
    
    public PoliceReportDeleteCommand(PoliceReportDAO DAO, ReportFile report_file) {
        this.DAO = DAO;
        this.report_file = report_file;
    }
    
    @Override
    public Object execute(Map<String, Object> args) throws InfraException {
        if (!DAO.getPoliceReports().containsKey((Integer) args.get("id"))) {
            throw new NoSuchElementException("No police report associated with this ID.");
        }

        PoliceReport police_report;
        police_report = DAO.getPoliceReports().get((Integer) args.get("id"));
        report_file.getRemovedPR(police_report);
        DAO.deletePoliceReport((Integer) args.get("id"));
        
        return null;
    }

}
