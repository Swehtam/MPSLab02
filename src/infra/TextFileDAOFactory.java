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
 * Factory Method project pattern.
 * @author aluno
 */
public class TextFileDAOFactory extends DAOFactory {
    public UserDAO getUserDAO() throws InfraException {
        return new TextFileUserDAO();
    }
}
