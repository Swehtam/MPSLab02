/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import business.model.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import util.InfraException;

/**
 *
 * This DAO persists to a simple comma-separated text file.
 * @author samueldemoura
 */
public class TextFileUserDAO implements UserDAO {

    private String persistence_path;
    private Map<String, User> users;

    /**
     *
     * Constructor for TextFileUserDAO. Populates a User HashMap by reading from
     * a persistence file.
     * 
     */
    public TextFileUserDAO() throws InfraException {
        users = new HashMap();
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
    }

    @Override
    public void addUser(String login, String password) {
        users.put(login, new User(login, password));
    }

    @Override
    public void deleteUser(String login) {
        users.remove(login);
    }

    @Override
    public Map<String, User> getUsers() {
        return users;
    }

    /**
     *
     * Saves User HashMap to the persistence file.
     * 
     */
    @Override
    public void commit() throws InfraException {
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
    }
}
