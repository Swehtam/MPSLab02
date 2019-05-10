package business.control;

import business.model.reports.PoliceReport;
import java.util.Iterator;
import java.util.Map;
import util.InfraException;

/**
 * Calculates risk for a radius around a given address.
 * Strategy project pattern.
 * @author samueldemoura
 */
public class RiskCalculator {
    
    private final PoliceReportControl pr_control;
    private Geocoder geocoder;
    private RiskCalculationStrategy risk_calc_strategy;
    private DistanceCalculationStrategy dist_calc_strategy;

    public RiskCalculator(PoliceReportControl pr_control, Geocoder geocoder, RiskCalculationStrategy risk_calc_strategy, DistanceCalculationStrategy dist_calc_strategy) {
        this.pr_control = pr_control;
        this.geocoder = geocoder;
        this.risk_calc_strategy = risk_calc_strategy;
        this.dist_calc_strategy = dist_calc_strategy;
    }

    public void setCalculationStrategy(RiskCalculationStrategy calc_strategy) {
        this.risk_calc_strategy = calc_strategy;
    }
    
    public int calculate(String address, int radius) throws InfraException {
        double[] coordinates = geocoder.reverseGeocode(address);
        Map<Integer, PoliceReport> prs_in_radius = pr_control.getPoliceReports();
        
        for (Iterator i = prs_in_radius.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry pair = (Map.Entry)i.next();
            PoliceReport pr = (PoliceReport)pair.getValue();
            
            double[] pr_coordinates = geocoder.reverseGeocode(pr.getAddress());
            if (dist_calc_strategy.getDistance(coordinates, pr_coordinates) > radius) {
                i.remove();
            }
            
            i.remove();
        }
        
        return risk_calc_strategy.calculate(prs_in_radius);
    }
}
