/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author user
 */
public abstract class Subject{
    protected String [] CodeSubject = {};
    protected String [] NameSubject = {};
    protected String [] CreditSubject = {};
    
    
    public String[] getCodeSubject()
    {
        return CodeSubject;
    }
    public String[] getNameSubject()
    {
        return NameSubject;
    }
    public String[] getCreditSubject()
    {
        return CreditSubject;
    }
    public void setCodeSubject(String[]CodeSubject)
    {
        this.CodeSubject = CodeSubject;
    }
    public void setNameSubject(String[]NameSubject)
    {
        this.NameSubject = NameSubject;
    }
    public void setCreditSubject(String[]CreditSubject)
    {
        this.CreditSubject = CreditSubject;
    }
}
