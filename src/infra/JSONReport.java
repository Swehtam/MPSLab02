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
public class JSONReport extends ReportFile{
    /*
    ** Método para gerar link JSON e retornando para o usuário
    ** @param String texto que refere ao link
    ** @param String link
    ** @return String para acessar o link
    */
    protected String getLink(String text, String url){
        return "{'text': '" + text + "',\n"
                + "'links': {\n"
                + "\t'self:' {\n"
                + "\t'href': " + url + "}\n}\n}";
    }
    
}
