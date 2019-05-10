package business.control;

import business.model.reports.PoliceReport;
import java.util.Map;

/**
 *
 * @author samuel
 */
public interface RiskCalculationStrategy {
    
    public int calculate(Map<Integer, PoliceReport> pr_arr);
    
}
