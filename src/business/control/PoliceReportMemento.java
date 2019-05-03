/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import business.model.reports.PoliceReport;
import java.util.HashMap;
import java.util.Map;

/**
 * This object represents the saved state of the class that was saved. In this
 * case, that is the PoliceReport class. This is a Memento project pattern.
 * @author aluno
 */
public class PoliceReportMemento {

    private String status;
    private PoliceReport police_report;
    
    public PoliceReportMemento(PoliceReport police_report, String status) {
        this.status = status;
        this.police_report = police_report;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public Map<String, Object> getMap(){
        Map<String, Object> args = new HashMap<>();
        args.put("id", police_report.getId());
        args.put("plaintiff_cpf", police_report.getPlaintiff().getCPF());
        args.put("plaintiff_name", police_report.getPlaintiff().getFullName());
        args.put("plaintiff_sex", police_report.getPlaintiff().getSex());
        args.put("report_type", police_report.getClass().toString());
        args.put("address", police_report.getAddress());
        args.put("reported_date_time", police_report.getReported_date_time());
        
        return args;
    }
    
}
