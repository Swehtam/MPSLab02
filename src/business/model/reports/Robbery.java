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
public class Robbery extends PoliceReport {
    
    private Map<String, String> robbery_description;

	public Robbery(int id, boolean is_open, Plaintiff plaintiff,
			String address, LocalDateTime reported_date_time,
			LocalDateTime registered_date_time,
                        String suspect_description, String stolen_objects) {
		super(id, is_open,plaintiff,address, reported_date_time,
			registered_date_time);
                robbery_description = new HashMap();
                robbery_description.put(stolen_objects,suspect_description);
        }
        
        public Map<String, String> getSpecificDetails(){
            return robbery_description;
        }
}
