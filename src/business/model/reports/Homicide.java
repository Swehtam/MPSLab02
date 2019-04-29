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
 * @author aluno
 */
public class Homicide extends PoliceReport {
    
    private Map<String, String> homicide_description;

	public Homicide(int id, boolean is_open, Plaintiff plaintiff,
			String address, LocalDateTime reported_date_time,
			LocalDateTime registered_date_time,
                        String suspect_description, String weapon) {
		super(id, is_open,plaintiff,address, reported_date_time,
			registered_date_time);
                homicide_description = new HashMap();
                homicide_description.put(weapon,suspect_description);
        }
        
        public Map<String, String> getSpecificDetails(){
            return homicide_description;
        }
}
