/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author samueldemoura
 */
public class UserForm {
    private BufferedReader in;
    private PrintStream out;

    public UserForm(BufferedReader in, PrintStream out) {
        this.in = in;
        this.out = out;
    }
    
    public int getChoice() throws IOException {
        out.print("> Input your choice: ");
        String user_input = in.readLine();
        
        try {
            return Integer.parseInt(user_input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public String[] askForCredentials() throws IOException {
        String[] tuple = new String[2];
        
        out.print("Username: ");
        tuple[0] = in.readLine();
        
        out.print("Password: ");
        tuple[1] = in.readLine();

        return tuple;
    }
}
