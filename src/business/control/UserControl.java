package business.control;

import java.util.Map;
import java.util.HashMap;
import business.model.*;
import util.*;

public class UserControl {
    public Map<String, User> usuarios;
    public UserValidationInterface validation = new UserValidation();
    
    public UserControl(){
        usuarios = new HashMap();
    }
    
    public UserControl(Map<String, User> users){
        usuarios = users;
    }
    
    public void add(String login, String password) throws UserLoginException, UserPasswordException {
        try {
            validation.validateLogin(login);
            validation.validatePassword(password);
            
        } catch (UserLoginException | UserPasswordException e){
            System.out.print(e);
            throw e;
        }
        
        if(usuarios.containsKey(login)){
            throw new UserLoginException("Usuário já cadastrado");
        }
        
        usuarios.put(login, new User(login,password));
        System.out.println("Usuário " + login + " adicionado com sucesso!");
    }
    
    public void del(String login) throws UserLoginException{
        if(!usuarios.containsKey(login)){
            throw new UserLoginException("Usuário não existe.");
        }

        usuarios.remove(login);
        System.out.println("Usuário " + login + " removido com sucesso!");
    }
    
    public Map<String,User> getUsers(){
        return usuarios;
    }
}
