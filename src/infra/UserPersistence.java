/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import java.util.*;
import java.io.*;

import infra.UserPersistence;
import business.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.InfraException;
/**
 *
 * @author aluno
 */
public class UserPersistence {
    File arquivo;
    String pers_path;
    
    HashMap<String, User> loadUsers() throws InfraException{
        
        
        try {
            
            HashMap<String,User> mapInFile = new HashMap<Integer, User>();
            
            FileOutputStream fos =
                     new FileOutputStream("hashmap.ser");
                  ObjectOutputStream oos = new ObjectOutputStream(fos);
                  oos.writeObject(mapInFile);


            oos.close();
            fos.close();
            
            return mapInFile;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new InfraException("Arquivo Nao Encontrado", ex);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new InfraException("Sem Leitura de Arquivo", ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new InfraException("Erro na leitura do arquivo", ex);
        }
    }
    
/*    void saveUsers (HashMap<String, User> users){
        try{
            File toWrite=new File(pers_path);
            FileOutputStream fos=new FileOutputStream(toWrite);
            PrintWriter pw=new PrintWriter(fos);

            for(Map.Entry<String,User> m : users.entrySet()){
                pw.println(m.getKey()+"="+m.getValue());
            }

            pw.flush();
            pw.close();
            fos.close();
        }catch(Exception e){}

    }
*/
}
