/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;
import business.model.reports.PoliceReport;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author aluno
 */
public class JSONReport extends ReportFile{
    private final String file_path = "reportJSON.json";
    private final JSONArray policeReportRemovedList = new JSONArray();
    private final JSONArray policeReportAddedList = new JSONArray();
    
    /*
    ** Método para retornar endereço do arquivo JSON e retornando para o usuário
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
        JSONObject policeReportDetails = new JSONObject();
        policeReportDetails.put("id", bo.getId());
        policeReportDetails.put("is_open", bo.isIs_open());
        policeReportDetails.put("plaintiff_cpf", bo.getPlaintiff().getCPF());
        policeReportDetails.put("plaintiff_name", bo.getPlaintiff().getFullName());
        policeReportDetails.put("plaintiff_sex", bo.getPlaintiff().getSex());
        policeReportDetails.put("report_type", bo.getClass().toString());
        policeReportDetails.put("address", bo.getAddress());
        policeReportDetails.put("reported_date_time", bo.getReported_date_time().toString());
        policeReportDetails.put("registred_date_time", bo.getRegistered_date_time().toString());
        
        policeReportAddedList.add(policeReportDetails);
    }
    
    /*
    ** Método para colocar informações do BO que foi removido
    ** @param BO que foi removido recentemente
    */
    @Override
    public final void getRemovedPR(PoliceReport bo){
        JSONObject policeReportDetails = new JSONObject();
        policeReportDetails.put("id", bo.getId());
        policeReportDetails.put("is_open", bo.isIs_open());
        policeReportDetails.put("plaintiff_cpf", bo.getPlaintiff().getCPF());
        policeReportDetails.put("plaintiff_name", bo.getPlaintiff().getFullName());
        policeReportDetails.put("plaintiff_sex", bo.getPlaintiff().getSex());
        policeReportDetails.put("report_type", bo.getClass().toString());
        policeReportDetails.put("address", bo.getAddress());
        policeReportDetails.put("reported_date_time", bo.getReported_date_time().toString());
        policeReportDetails.put("registred_date_time", bo.getRegistered_date_time().toString());
        
        policeReportRemovedList.add(policeReportDetails);
    }
    
    public final String commitPR(){
        JSONObject policeReportObject = new JSONObject();
        policeReportObject.put("addedQuantity", policeReportAddedList.size());
        
        for(int m = 0; m < policeReportAddedList.size(); m++)
        {
            JSONObject objectAdded = (JSONObject)policeReportAddedList.get(m);
            policeReportObject.put("policeReportAdded", objectAdded);
        }
        policeReportObject.put("removedQuantity", policeReportRemovedList.size());
        
        for(int n = 0; n < policeReportRemovedList.size(); n++)
        {
            JSONObject objectRemoved = (JSONObject)policeReportRemovedList.get(n);
            policeReportObject.put("policeReportRemoved", objectRemoved);
        }
        
        body = policeReportObject.toJSONString();
        return body;
    }
}
