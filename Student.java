/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class Student implements SubjectRegistration{
    private String MatricStudent;
    private String NameStudent;
    private int totalCredit;
    private ObservableList<String> CodeList = null;
    private ObservableList<String> SubjectList = null;
    private ObservableList<String> CreditList = null;
    public static Student stu = new Student();
    
    public void setNameStudent(String NameStudent)
    {
        this.NameStudent = NameStudent;
    }
    public void setMatricStudent(String MatricStudent)
    {
        this.MatricStudent = MatricStudent;
    }
    public String getMatricStudent()
    {
        return MatricStudent;
    }
    public String getNameStudent()
    {
        return NameStudent;
    }
    public void setSubject(ObservableList<String> Code, ObservableList<String> Sub, ObservableList<String> Cred) {
        CodeList = Code;
        CreditList = Cred;
        SubjectList = Sub;
    }
    public void setDropSubject(ObservableList<String> Code, ObservableList<String> Sub, ObservableList<String> Cred) {
        for(int i = 0; i<SubjectList.size();i++)
        {
            for(int j = 0; j<Sub.size();j++)
            {
                if(Code.get(j).equals(CodeList.get(i)))
                {
                    CodeList.remove(i);
                    SubjectList.remove(i);
                    CreditList.remove(i);
                }
            }
        }
    }
    public void setAddSubject(ObservableList<String> Code, ObservableList<String> Sub, ObservableList<String> Cred)
    {
        for(int i = 0; i<Code.size(); i++)
        {
            CodeList.add(Code.get(i));
            SubjectList.add(Sub.get(i));
            CreditList.add(Cred.get(i));
        }
    }
    public int getTotalCredit()
    {
        return totalCredit;
    }
    public void setTotalCredit(int totalCredit)
    {
        this.totalCredit = totalCredit;
    }

    @Override
    public ObservableList<String> getCodeSubject() {
        return CodeList;
    }

    @Override
    public ObservableList<String> getNameSubject() {
        return SubjectList;
    }

    @Override
    public ObservableList<String> getCreditSubject() {
        return CreditList;
    }
}
