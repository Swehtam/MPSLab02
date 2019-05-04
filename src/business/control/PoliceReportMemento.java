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
    private Map<String, Object> args;
    
    public PoliceReportMemento(Map<String, Object> args, String status) {
        this.status = status;
        this.args = args;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public Map<String, Object> getArgs(){        
        return args;
    }
    
}
