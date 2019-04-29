/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import business.model.reports.PoliceReport;
import java.util.*;

/**
 *
 * @author aluno
 */
public class HTMLReport extends ReportFile{
    private final String file_path = "reportHTML.html";
    private final List<String> policeReportRemovedList = new ArrayList<>();
    private final List<String> policeReportAddedList = new ArrayList<>();
    /*
    ** Método para retornar endereço do arquivo HTML e retornando para o usuário
    ** @return String para acessar o arquivo
    */
    @Override
    protected String getFile(){
        return file_path;
    }
    
    /*
    ** Método para colocar informações do BO que foi adicionado
    ** @param BO que foi adicionado recentemente
    */
    @Override
    public final void getAddedPR(PoliceReport bo){
        String content = "";
        String beginPattern = "<p style='padding-left: 20px; font-weight: bold;'>";
        String endPattern = "</p>";
        
        content = content + beginPattern + "id: " + bo.getId() + endPattern + "\n";
        content = content + beginPattern + "is_opne: " + bo.isIs_open()+ endPattern + "\n";
        content = content + beginPattern + "plaintiff_cpf: " + bo.getPlaintiff().getCPF() + endPattern + "\n";
        content = content + beginPattern + "plaintiff_name: " + bo.getPlaintiff().getFullName() + endPattern + "\n";
        content = content + beginPattern + "plaintiff_sex: " + bo.getPlaintiff().getSex() + endPattern + "\n";
        content = content + beginPattern + "report_type: " + bo.getClass().toString() + endPattern + "\n";
        content = content + beginPattern + "address: " + bo.getAddress() + endPattern + "\n";
        content = content + beginPattern + "reported_date_time: " + bo.getReported_date_time().toString() + endPattern + "\n";
        content = content + beginPattern + "registred_date_time: " + bo.getRegistered_date_time().toString() + endPattern + "\n";
        
        content = "<p>Police Report Added {</p>" + content + "<p>}</p>\n";
        policeReportAddedList.add(content);
    }
    
    /*
    ** Método para colocar informações do BO que foi removido
    ** @param BO que foi removido recentemente
    */
    @Override
    public final void getRemovedPR(PoliceReport bo){
        String content = "";
        String beginPattern = "<p style='padding-left: 20px; font-weight: bold;'>";
        String endPattern = "</p>";
        
        content = content + beginPattern + "id: " + bo.getId() + endPattern + "\n";
        content = content + beginPattern + "is_opne: " + bo.isIs_open()+ endPattern + "\n";
        content = content + beginPattern + "plaintiff_cpf: " + bo.getPlaintiff().getCPF() + endPattern + "\n";
        content = content + beginPattern + "plaintiff_name: " + bo.getPlaintiff().getFullName() + endPattern + "\n";
        content = content + beginPattern + "plaintiff_sex: " + bo.getPlaintiff().getSex() + endPattern + "\n";
        content = content + beginPattern + "report_type: " + bo.getClass().toString() + endPattern + "\n";
        content = content + beginPattern + "address: " + bo.getAddress() + endPattern + "\n";
        content = content + beginPattern + "reported_date_time: " + bo.getReported_date_time().toString() + endPattern + "\n";
        content = content + beginPattern + "registred_date_time: " + bo.getRegistered_date_time().toString() + endPattern + "\n";
        
        content = "<p>Police Report Removed {</p>" + content + "<p>}</p>\n";
        policeReportRemovedList.add(content);
    }
    
    public final String commitPR(){
        String bodyBegin = "<!DOCTYPE html>\n" + "<html>\n" + "<body>\n" + "<div>\n";
        String bodyEnd = "</div>\n" + "</body>\n" + "</html>";
        
        String addedHead = "<h1>These are the police report added to the system</h1>\n";
        String removedHead = "<h1>These are the police report added to the system</h1\n>";
        String bodyContent = "";
        
        bodyContent = addedHead + "<h2>Quantity:" + policeReportAddedList.size() + "</h2>\n";
        
        for(int m = 0; m < policeReportAddedList.size(); m++)
        {
            bodyContent = bodyContent + (String)policeReportAddedList.get(m);
        }
        
        bodyContent = removedHead + "<h2>Quantity:" + policeReportRemovedList.size() + "</h2>\n";
        
        for(int n = 0; n < policeReportRemovedList.size(); n++)
        {
            bodyContent = bodyContent + (String)policeReportRemovedList.get(n);
        }
        
        body = bodyBegin + bodyContent + bodyEnd;
        return body;
    }
    
}
