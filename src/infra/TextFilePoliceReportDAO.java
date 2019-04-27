/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import business.model.Plaintiff;
import business.model.User;
import business.model.reports.PoliceReport;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import util.InfraException;

/**
 *
 * This DAO persists to a simple comma-separated text file.
 * @author samueldemoura
 */
public class TextFilePoliceReportDAO implements PoliceReportDAO {

    private String persistence_path;
    private Map<Integer, PoliceReport> police_reports;

    /**
     *
     * Constructor for TextFilePoliceReportDAO. Populates a PoliceReport HashMap by reading from
     * a persistence file.
     * 
     */
    public TextFilePoliceReportDAO() throws InfraException {
		// TODO: Adapt code below for PoliceReport class.
		throw new UnsupportedOperationException();
		
		/*
        police_reports = new HashMap();
        persistence_path = "hashmap.txt";

        File to_write = new File(persistence_path);
        Map<String, User> users = new HashMap();

        if (to_write.exists()) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(to_write)));
                String l;
                while ((l = br.readLine()) != null) {
                    String[] args = l.split("[,]", 2);
                    if (args.length != 2) {
                        continue;
                    }
                    String login = args[0].replaceAll(" ", "");
                    String password = args[1].replaceAll(" ", "");

                    users.put(login, new User(login, password));
                }
                br.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                throw new InfraException("Persistence file not found.", ex);
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new InfraException("Unable to read persistence file.", ex);
            }
        }
		*/
    }

    @Override
    public void addPoliceReport(int id, String local_type, Plaintiff plaintiff, 
			String address, LocalDateTime report_DateTime) {
		// TODO: can't instantiate PoliceReport. Must pass along report type, but where?
		throw new UnsupportedOperationException();
        //police_reports.put(id, new PoliceReport(id, local_type, plaintiff, address, report_DateTime));
    }

    @Override
    public void deletePoliceReport(int id) {
        police_reports.remove(id);
    }

    @Override
    public Map<Integer, PoliceReport> getPoliceReports() {
        return police_reports;
    }

    /**
     *
     * Saves User HashMap to the persistence file.
     * 
     */
    @Override
    public void commit() throws InfraException {
		// TODO: Adapt code below for PoliceReport class.
		throw new UnsupportedOperationException();
		
		/*
        try {
            File to_write = new File(persistence_path);

            BufferedWriter bw = new BufferedWriter(new FileWriter(to_write));
            for (String p : users.keySet()) {
                bw.write(p + "," + users.get(p).getPassword());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new InfraException("Arquivo Nao Encontrado", ex);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new InfraException("Sem Leitura de Arquivo", ex);
        }
		*/
    }
}
