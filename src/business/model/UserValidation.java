/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model;

import util.UserLoginException;
import util.UserPasswordException;

/**
 *
 * @author samueldemoura
 */
public class UserValidation implements UserValidationInterface {
    public void validateLogin(String login) throws UserLoginException {
        if (login.length() > 16) {
            throw new UserLoginException("Login deve ter no máximo 16 caracteres.");
        }
        
        if (login.matches("?.*\\d.*?")) {
            throw new UserLoginException("Login não pode conter números.");
        }
    }
    
    public void validatePassword(String password) throws UserPasswordException {
        if (password.length() > 16) {
            throw new UserPasswordException("Password deve ter no máximo 16 caracteres.");
        }
        
        if (password.length() < 6) {
            throw new UserPasswordException("Password deve ter no mínimo 6 caracteres.");
        }
        
        if (!password.matches(".*\\d.*")) {
            throw new UserPasswordException("Password precisa conter no mínimo 1 número.");
        }
        
        if (!password.matches(".*[a-zA-Z].*")) {
            throw new UserPasswordException("Password precisa conter no mínimo 1 letra.");
        }
    }
}
