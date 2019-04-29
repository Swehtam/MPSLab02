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
public class Shooting extends PoliceReport {
    
    private Map<String, String> shooting_description;

	public Shooting(int id, boolean is_open, Plaintiff plaintiff,
			String address, LocalDateTime reported_date_time,
			LocalDateTime registered_date_time,
                        String noise_description, String suspect_description) {
		super(id, is_open,plaintiff,address, reported_date_time,
			registered_date_time);
                shooting_description = new HashMap();
                shooting_description.put(noise_description,suspect_description);
        }
        
        public Map<String, String> getSpecificDetails(){
            return shooting_description;
        }
}
