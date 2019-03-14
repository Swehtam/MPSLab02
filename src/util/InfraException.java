/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author samueldemoura
 */
public class InfraException extends Exception {
    public InfraException(String msg, Exception e) {
        super(msg, e);
    }
    
    public InfraException(String msg) {
        super(msg);
    }
}
