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
 * This factory allows selection of what will be used for persistence.
 * Abstract Factory design pattern.
 * @author samueldemoura
 */
public abstract class DAOFactory {
    // Possible persistence types supported by this factory
    public static final int TEXTFILE = 1;
    public static final int INMEMORY = 2;
    
    public abstract UserDAO getUserDAO() throws InfraException;
    
    public static DAOFactory getDAOFactory(int factory_type) {
        switch (factory_type) {
            case TEXTFILE:
                return new TextFileDAOFactory();
            case INMEMORY:
                return new InMemoryDAOFactory();
            default:
                return null;
            }
    }
}
