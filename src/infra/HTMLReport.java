/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

/**
 *
 * @author aluno
 */
public class HTMLReport extends ReportFile{
    /*
    ** Método para gerar link html e retornando para o usuário
    ** @param String texto que refere ao link
    ** @param String link
    ** @return String para acessar o link
    */
    protected String getLink(String text, String url){
        return "<a href='" + url + "'>" + text + "</a>";
    }
    
}
