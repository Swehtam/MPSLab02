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
public class MissingPerson extends PoliceReport {
    
    private Map<String, String> report_description;

	public MissingPerson(int id, boolean is_open, Plaintiff plaintiff,
			String address, LocalDateTime reported_date_time,
			LocalDateTime registered_date_time,
                        String person_description, String narrative) {
		super(id, is_open,plaintiff,address, reported_date_time,
			registered_date_time);
                report_description = new HashMap();
                report_description.put(person_description,narrative);
        }
        
        public Map<String, String> getSpecificDetails(){
            return report_description;
        }
}
