/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import util.InfraException;

/**
 * This factory allows selection of what will be used for persistence. Abstract
 * Factory + Singleton design pattern.
 *
 * @author samueldemoura
 */
public abstract class DAOFactory {

    // Possible persistence types supported by this factory
    public static final int TEXTFILE = 1;
    public static final int INMEMORY = 2;
    private static DAOFactory textfile_dao = null;
    private static DAOFactory inmemory_dao = null;

    public abstract UserDAO getUserDAO() throws InfraException;

    public abstract PoliceReportDAO getPoliceReportDAO() throws InfraException;

    public static DAOFactory getDAOFactory(int factory_type) {
        switch (factory_type) {
            case TEXTFILE:
                if (textfile_dao == null) {
                    textfile_dao = new TextFileDAOFactory();
                }
                return textfile_dao;
            case INMEMORY:
                if (inmemory_dao == null) {
                    inmemory_dao = new InMemoryDAOFactory();
                }
                return inmemory_dao;
            default:
                return null;
        }
    }
}
