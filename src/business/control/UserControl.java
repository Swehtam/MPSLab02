package business.control;

import java.util.Map;
import java.util.HashMap;
import business.model.User;
import util.*;

public class UserControl {
    public Map<String, User> usuarios = new HashMap();
    
    public void add(String login, String password) throws UserLoginException{
        
        if(usuarios.containsKey(login)){
            throw new UserLoginException("Usuário já criado");
        }
        
        usuarios.put(login, new User(login,password));
        System.out.println("Usuário " + login + " adicionado com sucesso!");
    }
    
    public void del(String login) throws UserLoginException{
        
        if(!usuarios.containsKey(login)){
            throw new UserLoginException("Usuário já criado");
        }
        
        usuarios.remove(login);
        System.out.println("Usuário " + login + " removido com sucesso!");
    }
}
