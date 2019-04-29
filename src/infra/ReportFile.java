/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;
import business.model.reports.PoliceReport;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author swehtam  
 */
public abstract class ReportFile {
    protected String body = "";
    
    /*
    ** Método para retornar o link para o relatório.
    ** Esse método será diferente para HTML Ou JSON ou XML
    */
    protected abstract String getFile();
    
    /*
    ** Método para inserir todos os dados dentro de um arquivo .HTML 
    ** ou um arquivo JSON
    */
    public final String reportMethod(){
        try{
            File f = new File(getFile());
            f.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            bw.write(commitPR());
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        String msg = "File to Report updated: " + getFile();
        return msg;
    }
    
    //Esses métodos provavelmente serão implementados caso use DAO para os BO's
    
    /*
    ** Método para retornar o número de BO's adicionados
    ** @return int - numeros de BO's adicionado pelo usuario
    */
    public abstract void getAddedPR(PoliceReport bo);
    
    /*
    ** Método para retornar o número de BO's removidos pelo usuario
    ** @return int - numeros de BO's removidos pelo usuario
    */
    public abstract void getRemovedPR(PoliceReport bo);
    
    /*
    ** Método para criar e retornar uma String para colocar no corpo do arquivo
    ** @return String - corpo do documento que será escrito no arquivo
    */
    public abstract String commitPR();
    
    /*
    ** Método para retornar o usuário que manipulou as listas de BO's
    ** @return String - nome do usuário que manipulou os BO's
    public final String getUser(User DAO user){
        return user.getLocalUser.getLogin();
    }
    */
}
