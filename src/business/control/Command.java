/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import java.util.Map;
import util.InfraException;

/**
 *
 * @author aluno
 */
public interface Command {
    
    public Object execute(Map<String, Object> args) throws InfraException;
    
}
