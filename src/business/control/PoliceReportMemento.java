/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import business.model.reports.PoliceReport;

/**
 * This object represents the saved state of the class that was saved. In this
 * case, that is the PoliceReport class. This is a Memento project pattern.
 * @author aluno
 */
public class PoliceReportMemento {

    private PoliceReport status;
    
    public PoliceReportMemento(PoliceReport police_report) {
        // TODO: Implement this properly (copy over fields to new object)
        throw new UnsupportedOperationException();
        
        //this.status = police_report;
    }
    
}
