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
public interface UserValidationInterface {
    public void validateLogin(String login) throws UserLoginException;
    public void validatePassword(String password) throws UserPasswordException;
}
