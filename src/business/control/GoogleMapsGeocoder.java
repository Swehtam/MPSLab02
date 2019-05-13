/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import util.InfraException;

/**
 * Implements the Geocoder interface using the Google Maps API.
 * Adapter project pattern.
 * @author samuel
 */
public class GoogleMapsGeocoder implements Geocoder {

    private boolean initialized = false;
    private String api_key;
    private String country_id;
    
    public GoogleMapsGeocoder(String api_key) {
        this(api_key, null);
    }
    
    public GoogleMapsGeocoder(String api_key, String country_id) {
        initialized = true;
        this.api_key = api_key;
        this.country_id = country_id;
    }
    
    @Override
    public double[] reverseGeocode(String address) throws InfraException {
        if (!initialized) {
            throw new InfraException("Missing API key for Google Maps API.");
        }
        
        String request_url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + this.api_key;
        
        if (country_id != null) {
            request_url += "&components=country:" + this.country_id;
        }
        
        String response = "";
        
        try (java.util.Scanner s = new java.util.Scanner(new java.net.URL(request_url).openStream())) {
            response += s.useDelimiter("\\A").next();
        } catch (Exception ex) {
            throw new InfraException(ex.getMessage());
        }
        
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(response);
            
            double[] values = new double[2];
            values[0] = (double) jsonObject.get("lat");
            values[1] = (double) jsonObject.get("lng");  
        
            return values;
        } catch (ParseException ex) {
            throw new InfraException(ex.getMessage());
        }     
    }

    @Override
    public String geocode(double latitude, double longitude) throws InfraException {
        if (!initialized) {
            throw new InfraException("Missing API key for Google Maps API.");
        }

        String request_url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + latitude + "," + longitude + "&key=" + this.api_key;
        
        if (country_id != null) {
            request_url += "&components=country:" + this.country_id;
        }
        
        String response = "";
        
        try (java.util.Scanner s = new java.util.Scanner(new java.net.URL(request_url).openStream())) {
            response += s.useDelimiter("\\A").next();
        } catch (Exception ex) {
            throw new InfraException(ex.getMessage());
        }
        
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(response);
            return (String) jsonObject.get("adr"); 
        } catch (ParseException ex) {
            throw new InfraException(ex.getMessage());
        }  
    }
    
}
