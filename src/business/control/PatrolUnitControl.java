/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import business.model.*;
import business.model.reports.*;
import java.util.*;

/**
 * Chain of responsability project pattern.
 * @author swehtam
 */
public class PatrolUnitControl {
    
    private Map<Integer, PatrolUnit> patrol_units;
    private Geocoder geocoder;
    private DistanceCalculationStrategy dist_calc_strategy;
    private int current_id;

    public PatrolUnitControl(Geocoder geocoder, DistanceCalculationStrategy dist_calc_strategy) {
        this.patrol_units = new HashMap();
        this.geocoder = geocoder;
        this.dist_calc_strategy = dist_calc_strategy;
        this.current_id = 0;
    }
    
    public void add(double[] localization){
        int id = current_id;
        current_id++;
        
        /*
        **Simple code example on how to get the last
        **patrol unit added to the system, 
        **if it isn't the first one to be added.
        */
        PatrolUnit sucessor = null;
        if(patrol_units.containsKey(id - 1)){
            sucessor = patrol_units.get(id - 1);
        }
        
        
        PatrolUnit unit = new PatrolUnit(localization, true, sucessor);
        patrol_units.put(id, unit);
    }
    
    public void del(int id){
        PatrolUnit deletedUnit = patrol_units.get(id);
        PatrolUnit sucessor = deletedUnit.getSucessor();
        
        /*
        **Simple code example of a loop looking for the patrol unit
        **that references to the deletedUnit as its sucessor.
        **So its sucessor can be the same as the deleted one.
        */
        for (Map.Entry<Integer, PatrolUnit> unit : patrol_units.entrySet()) {
            if(unit.getValue().getSucessor().getId() == deletedUnit.getId()){
                unit.getValue().setSucessor(sucessor);
            }
        }
        
        patrol_units.remove(id);
    }
    
    
    public void sendAPatrolUnitTo(PoliceReport police_report){
        PatrolUnit unit = null;
        
        /*
        **Simple code just to know if there is any patrol unit added.
        **And if there is, get the last one added.
        */
        for(int i = current_id-1; i >= 0; i--){
            if(patrol_units.containsKey(i)){
                unit = patrol_units.get(i);
                break;
            }
        }
        
        if(unit == null){
            System.out.println("Sorry, there isn't any patrol unit added in the system");
            return;
        }
        
        unit.processRequest(police_report.getAddress(), geocoder, dist_calc_strategy);
    }
    
}
