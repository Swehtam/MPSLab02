/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model;

/**
 *
 * @author aluno
 */
public class Plaintiff {
    
    // Attributes
    private String cpf, full_name, fathers_name, mothers_name, sex;

    /**
     * Constructor.
     * @param cpf
     * @param full_name
     * @param fathers_name
     * @param mothers_name
     * @param sex 
     */
    public Plaintiff(String cpf, String full_name, String fathers_name, String mothers_name, String sex) {
        this.cpf = cpf;
        this.full_name = full_name;
        this.fathers_name = fathers_name;
        this.mothers_name = mothers_name;
        this.sex = sex;
    }

    /**
     * Constructor. Passes fathers_name as null.
     * @param cpf
     * @param full_name
     * @param mothers_name
     * @param sex 
     */
    public Plaintiff(String cpf, String full_name, String mothers_name, String sex) {
        this(cpf, full_name, null, mothers_name, sex);
    }
	
    /**
     * Minimal constructor.
     * @param cpf
     * @param full_name
     * @param sex 
     */
    public Plaintiff(String cpf, String full_name, String sex) {
        this(cpf, full_name, null, null, sex);
    }
    
    public void setCPF(String cpf){
        this.cpf = cpf;
    }
    
    public String getCPF(){
        return this.cpf;
    }
    
    public void setFullName(String full_name){
        this.full_name = full_name;
    }
    
    public String getFullName(){
        return this.full_name;
    }
    
    public void setFathersName(String fathers_name){
        this.fathers_name = fathers_name;
    }
    
    public String getFathersName(){
        return this.fathers_name;
    }
    
    public void setMothersName(String mothers_name){
        this.mothers_name = mothers_name;
    }
    
    public String getMothersName(){
        return this.mothers_name;
    }
    
    public void setSex(String sex){
        this.sex = sex;
    }
    
    public String getSex(){
        return this.sex;
    }
}
