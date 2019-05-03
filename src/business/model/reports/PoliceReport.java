/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.reports;

import business.control.PoliceReportMemento;
import business.model.Plaintiff;
import java.time.*;
import java.util.Map;

/**
 *
 * @author samueldemoura
 */
abstract public class PoliceReport {

    // General fields
    private int id;
    private boolean is_open;
    private Plaintiff plaintiff;
    private String address;
    private LocalDateTime reported_date_time, registered_date_time;

    /**
     * Constructor.
     *
     * @param id
     * @param is_open
     * @param plaintiff
     * @param address
     * @param reported_date_time
     * @param registered_date_time
     */
    public PoliceReport(int id, boolean is_open, Plaintiff plaintiff,
            String address, LocalDateTime reported_date_time,
            LocalDateTime registered_date_time) {
        this.id = id;
        this.is_open = is_open;
        this.plaintiff = plaintiff;
        this.address = address;
        this.reported_date_time = reported_date_time;
        this.registered_date_time = registered_date_time;
    }

    /**
     * Details specific to a certain type of police report. Examples: stolen
     * items in a robbery, personal information of a missing person in a missing
     * person report.
     *
     * @return Mapping of field name -> field contents
     */
    public abstract Map<String, String> getSpecificDetails();

    public PoliceReportMemento createMemento(String status) {
        // TODO: Create new memento using the fields from this instance
        return new PoliceReportMemento(this, status);
        
        //return new PoliceReportMemento();
    }
    
    /*
    ** We don't need to create this method right now
    ** because we can't edit a police report yet
    */
    //public void revert(PoliceReportMemento m) {
        // TODO: Read fields from memento and copy over into this instance
      //  throw new UnsupportedOperationException();
    //}

    // Getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIs_open() {
        return is_open;
    }

    public void setIs_open(boolean is_open) {
        this.is_open = is_open;
    }

    public Plaintiff getPlaintiff() {
        return plaintiff;
    }

    public void setPlaintiff(Plaintiff plaintiff) {
        this.plaintiff = plaintiff;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getReported_date_time() {
        return reported_date_time;
    }

    public void setReported_date_time(LocalDateTime reported_date_time) {
        this.reported_date_time = reported_date_time;
    }

    public LocalDateTime getRegistered_date_time() {
        return registered_date_time;
    }

    public void setRegistered_date_time(LocalDateTime registered_date_time) {
        this.registered_date_time = registered_date_time;
    }

}
