package business.control;

import java.util.Map;
import business.model.*;
import business.model.reports.PoliceReport;
import infra.PoliceReportDAO;
import infra.ReportFile;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.NoSuchElementException;
import util.*;

/**
 * Responsible for police report business rules. Facade.
 */
public class PoliceReportControl {

    private final PoliceReportDAO police_reportDAO;
    private int current_id;
    private final ReportFile report;
    private Map<String, Command> commands;

    public PoliceReportControl(PoliceReportDAO police_reportDAO, ReportFile report) {
        this.police_reportDAO = police_reportDAO;
        this.report = report;
        this.current_id = 0;
        
        this.commands = new HashMap<>();
        commands.put("add", new PoliceReportAddCommand(police_reportDAO, report));
        commands.put("del", new PoliceReportDeleteCommand(police_reportDAO, report));
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

        // Validation rules go here
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        args.put("plaintiff_cpf", plaintiff_cpf);
        args.put("plaintiff_name", plaintiff_name);
        args.put("plaintiff_sex", plaintiff_sex);
        args.put("report_type", report_type);
        args.put("address", address);
        args.put("reported_date_time", reported_date_time);
        
        // Call command
        commands.get("add").execute(args);
        return id;
    }

    public void del(int id) throws NoSuchElementException, InfraException {
        // Validation rules go here
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        
        // Call command
        commands.get("del").execute(args);
    }

    public Map<Integer, PoliceReport> getPoliceReports() throws InfraException {
        return police_reportDAO.getPoliceReports();
    }
}
