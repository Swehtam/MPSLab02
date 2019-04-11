/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import business.model.User;
import java.util.Map;
import util.InfraException;

/**
 *
 * @author aluno
 */
public interface UserDAO {
    public void addUser(String login, String password) throws InfraException;
    public void deleteUser(String login) throws InfraException;
    public Map<String,User> getUsers() throws InfraException;
    public void commit() throws InfraException;
}
