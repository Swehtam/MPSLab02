/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import business.model.reports.PoliceReport;
import java.util.Map;
import util.InfraException;

/**
 *
 * @author samueldemoura
 */
public interface PoliceReportDAO {
    public void addPoliceReport(PoliceReport police_report) throws InfraException;
    public void deletePoliceReport(int id) throws InfraException;
    public Map<Integer, PoliceReport> getPoliceReports() throws InfraException;
    public void commit() throws InfraException;
}
