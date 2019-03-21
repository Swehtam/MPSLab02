/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import java.util.*;
import java.io.*;

import business.model.User;
import util.InfraException;
/**
 *
 * @author aluno
 */
public class UserPersistence {
    File arquivo;
    String pers_path = "HashMap.txt";
    
    public Map<String, User> loadUsers() throws InfraException{
        File toWrite = new File(pers_path);
        Map<String, User> users = new HashMap();
        
        if(toWrite.exists()){
            try
            {
               BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(toWrite)));
               String l;
               while((l = br.readLine()) != null)
               {
                  String[] args = l.split("[,]", 2);
                  if(args.length != 2)continue;
                  String login = args[0].replaceAll(" ", "");
                  String password = args[1].replaceAll(" ", "");

                  users.put(login, new User(login,password));
               }
               br.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                throw new InfraException("Arquivo Nao Encontrado", ex);
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new InfraException("Sem Leitura de Arquivo", ex);
            }
        }
        
        return users;
    }
    
    public void saveUsers(Map<String, User> users) throws InfraException{
        try
        {
           File toWrite = new File(pers_path);
           
           BufferedWriter bw = new BufferedWriter(new FileWriter(toWrite));
           for(String p: users.keySet())
           {
              bw.write(p + "," + users.get(p).getPassword());
              bw.newLine();
           }
           bw.flush();
           bw.close();
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new InfraException("Arquivo Nao Encontrado", ex);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new InfraException("Sem Leitura de Arquivo", ex);
        }

    }

}
