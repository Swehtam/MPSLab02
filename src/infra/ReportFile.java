/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;
import java.util.Map;

/**
 *
 * @author swehtam  
 */
public abstract class ReportFile {
    
    /*
    ** Método para retornar o link para o relatório.
    ** Esse método será diferente para HTML Ou JSON ou XML
    */
    protected abstract String getLink(String text, String ulr);
    
    /*
    ** Método para inserir todos os dados dentro de um arquivo .HTML 
    ** ou um arquivo JSON
    */
    public final String reportMethod(){
        String msg = "Link to Report: " + getLink("PoliceReport",
                     "https://www.google.com");
        return msg;
    }
    
    //Esses métodos provavelmente serão implementados caso use DAO para os BO's
    
    /*
    ** Método para retornar o número de BO's adicionados
    ** @return int - numeros de BO's adicionado pelo usuario
    public final int getAddedBO(PoliceReportDAO bo){
        return BO.getUserAdded();
    }*/
    
    /*
    ** Método para retornar o número de BO's removidos pelo usuario
    ** @return int - numeros de BO's removidos pelo usuario
    public final int getRemovedBO(PoliceReportDAO bo){
        return BO.getUserRemoved();
    }
    */
    
    /*
    ** Método para retornar o usuário que manipulou as listas de BO's
    ** @return String - nome do usuário que manipulou os BO's
    public final String getUser(User DAO user){
        return user.getLocalUser.getLogin();
    }
    */
    
    /*
    */
}
