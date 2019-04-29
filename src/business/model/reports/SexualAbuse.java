/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.reports;

import business.model.Plaintiff;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MikuFelicio
 */
public class SexualAbuse extends PoliceReport {
    
    private Map<String, String> abuse_description;

	public SexualAbuse(int id, boolean is_open, Plaintiff plaintiff,
			String address, LocalDateTime reported_date_time,
			LocalDateTime registered_date_time,
                        String suspect_description, String narrative) {
		super(id, is_open,plaintiff,address, reported_date_time,
			registered_date_time);
                abuse_description = new HashMap();
                abuse_description.put(narrative,suspect_description);
        }
        
        public Map<String, String> getSpecificDetails(){
            return abuse_description;
        }
}