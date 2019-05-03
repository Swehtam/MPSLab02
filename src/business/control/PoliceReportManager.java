/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import business.model.reports.PoliceReport;
import java.util.Stack;

/**
 * This class holds the imutable state of the mementos. Implements the Memento
 * project pattern.
 * @author aluno
 */
public class PoliceReportManager {
    
    private Stack<PoliceReportMemento> history = new Stack<>();
    
    public void saveMemento(PoliceReportMemento police_report) {
        history.push(police_report);
    }
    
    public PoliceReportMemento revert() {
        if (history.empty()) return null;
        return history.pop();
    }
    
}
