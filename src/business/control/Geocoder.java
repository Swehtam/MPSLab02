package business.control;

import util.InfraException;

/**
 *
 * @author samueldemoura
 */
public interface Geocoder {
    
    public double[] reverseGeocode(String address) throws InfraException;
    public String geocode(double latitude, double longitude) throws InfraException;
    
}
