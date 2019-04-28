/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.reports;
import business.model.Plaintiff;
import java.time.*;

/**
 *
 * @author aluno
 */
abstract public class PoliceReport {
	private Plaintiff plaintiff;
	private String id, local_type, address;
	LocalDateTime report_DateTime, registered_DateTime;
	boolean status;
	//status: when 1 police report is open

	public PoliceReport(String id, String local_type, Plaintiff plaintiff, 
			String address, LocalDateTime report_DateTime, LocalDateTime registered_DateTime) {
		this.id = id;
		this.plaintiff = plaintiff;
		this.local_type = local_type;
		this.address = address;
		this.report_DateTime = report_DateTime;
		this.status = true;
		this.registered_DateTime = registered_DateTime;
	}

	public String getLocal_type() {
		return local_type;
	}

	public void setLocal_type(String local_type) {
		this.local_type = local_type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getReport_DateTime() {
		return report_DateTime;
	}

	public void setReport_DateTime(LocalDateTime report_DateTime) {
		this.report_DateTime = report_DateTime;
	}
	
	public void setRegistered_DateTime(LocalDateTime registered_DateTime) {
		this.registered_DateTime = registered_DateTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Plaintiff getPlaintiff() {
		return plaintiff;
	}

	public void setPlaintiff(Plaintiff plaintiff) {
		this.plaintiff = plaintiff;
	}
	
	
	
}
