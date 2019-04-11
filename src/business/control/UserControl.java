package business.control;

import java.util.Map;
import java.util.HashMap;
import business.model.*;
import infra.UserDAO;
import util.*;

public class UserControl {
    private UserDAO userDAO;
    private UserValidationInterface validation = new UserValidation();
    
    public UserControl(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    
    public void add(String login, String password) throws UserLoginException, UserPasswordException, InfraException {
        try {
            validation.validateLogin(login);
            validation.validatePassword(password);
            
        } catch (UserLoginException | UserPasswordException e){
            System.out.print(e);
            throw e;
        }
        
        if (userDAO.getUsers().containsKey(login)){
            throw new UserLoginException("Usuário já cadastrado");
        }
        
        userDAO.addUser(login, password);
        System.out.println("Usuário " + login + " adicionado com sucesso!");
    }
    
    public void del(String login) throws UserLoginException, InfraException {
        if(!userDAO.getUsers().containsKey(login)){
            throw new UserLoginException("Usuário não existe.");
        }

        userDAO.deleteUser(login);
        System.out.println("Usuário " + login + " removido com sucesso!");
    }
    
    public Map<String,User> getUsers() throws InfraException {
        return userDAO.getUsers();
    }
}
