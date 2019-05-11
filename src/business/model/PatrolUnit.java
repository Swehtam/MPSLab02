/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model;
import business.control.*;
import business.model.reports.*;
import java.lang.*;

/**
 * Chain of responsability project pattern.
 * @author swehtam
 */
public class PatrolUnit{
    private int id;
    private double[] location;
    private boolean avaliable;
    private PatrolUnit sucessor;

    public PatrolUnit(double[] location, boolean avaliable, PatrolUnit sucessor) {
        this.location = location;
        this.avaliable = avaliable;
    }
    
    public void setSucessor(PatrolUnit sucessor) {
        this.sucessor = sucessor;
    }
    
    public PatrolUnit getSucessor() {
        return sucessor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }    

    public double[] getLocation() {
        return location;
    }

    public void setLocation(double[] location) {
        this.location = location;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }
    
    public void processRequest(String address,
            Geocoder geocoder,
            DistanceCalculationStrategy dist_calc_strategy){        
        /*
        **The base value to send a patrol unit to a determinated location.
        **First of all, if the patrol unit is avaliable.
        **Second of all, if it's close to the police report address.
        **The base distance is set as 10 kilometers, but it's just a value, it can change later.
        */
        if(this.isAvaliable())
        {
            double[] coordinates = geocoder.reverseGeocode(address);
            double distance = dist_calc_strategy.getDistance(this.getLocation(), coordinates);
            
            //PROBLEM: Needs to send the closest patrol unit to the police report address,
            //regardlees if it's in range or not.
            if(distance <= 10000)
            {
                System.out.println("Patrol unit id: " + this.getId() + ", is now going to 3''" + address);
                this.setAvaliable(false);
                this.setLocation(coordinates);
                return;
            }
            else if(this.getSucessor() != null)
            {
                this.getSucessor().processRequest(address, geocoder, dist_calc_strategy);
            }
            else
            {
                System.out.println("There isn't any patrol unit avaliable or close right now");
            }
        }
        else if(this.getSucessor() != null)
        {
            this.getSucessor().processRequest(address, geocoder, dist_calc_strategy);
        }
        else
        {
            System.out.println("There isn't any patrol unit avaliable or close right now");
        }
    }

}
