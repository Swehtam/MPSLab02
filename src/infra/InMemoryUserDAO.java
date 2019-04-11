/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import business.model.User;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aluno
 */
public class InMemoryUserDAO implements UserDAO {
    
    private Map<String, User> users;
    
    public InMemoryUserDAO() {
        users = new HashMap();
    }
    
    @Override
    public void addUser(String login, String password) {
        users.put(login, new User(login,password));
    }

    @Override
    public void deleteUser(String login) {
        users.remove(login);
    }

    @Override
    public Map<String, User> getUsers() {
        return users;
    }

    @Override
    public void commit() {
        System.out.println("INMEMORY does not commit anywhere.");
    }
}
