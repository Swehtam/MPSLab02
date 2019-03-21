/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.control.UserControl;
import infra.UserPersistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import util.InfraException;
import util.UserLoginException;
import util.UserPasswordException;

/**
 *
 * @author samueldemoura, swehtam
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserForm userForm = new UserForm(new BufferedReader(new InputStreamReader(System.in)), System.out);
        UserPersistence userPersistence = new UserPersistence();
        
        String[] credentials;
        int choice;
        UserControl userControl = new UserControl();
        
        try{
           userControl = new UserControl(userPersistence.loadUsers()); 
        }catch (InfraException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
        
        do {
            System.out.println("1. Register new user\n2. Remove existing user\n3. Exit");
            try {
                choice = userForm.getChoice();
                
                switch (choice) {
                    case 1:
                        credentials = userForm.askForCredentials();
                        
                        try {
                            userControl.add(credentials[0], credentials[1]);
                        } catch (UserLoginException | UserPasswordException ex) {
                            System.out.println("ERROR: " + ex.getMessage());
                        }
                        
                        break;
                    case 2:
                        String loginToDelete = userForm.deleteCredentials();
                        
                        try {
                            userControl.del(loginToDelete);
                        } catch (UserLoginException ex) {
                            System.out.println("ERROR: " + ex.getMessage());
                        }
                        
                        break;
                    case 3:
                        System.out.println("Bye");
                        userPersistence.saveUsers(userControl.getUsers());
                        break;
                    default:
                        System.out.print("Invalid option, please try again.");
                        break;
                }
            } catch (IOException ex) {
                System.out.println("Failed to get user input.");
                break;
            } catch (InfraException ex){
                System.out.println("ERROR: " + ex.getMessage());
                break;
            }
        } while (choice != 3);
    }
    
}
