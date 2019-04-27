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

/**
 *
 * This DAO doesn't persist anywhere - it stays in memory only.
 * @author samueldemoura
 */
public class InMemoryPoliceReportDAO implements PoliceReportDAO {
    
    private Map<Integer, PoliceReport> police_reports;
    
    public InMemoryPoliceReportDAO() {
        police_reports = new HashMap();
    }
    
    @Override
    public void addPoliceReport(int id, String local_type, Plaintiff plaintiff, 
			String address, LocalDateTime report_DateTime) {
		// TODO: can't instantiate PoliceReport. Must pass along report type, but where?
		throw new UnsupportedOperationException();
        //police_reports.put(id, new PoliceReport(id, local_type, plaintiff, address, report_DateTime));
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
