package business.control;

/**
 *
 * @author samueldemoura
 */
public interface Geocoder {
    
    public double[] reverseGeocode(String address);
    public String geocode(double latitude, double longitude);
    
}
