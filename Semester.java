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
public class Semester extends Subject{
    private int YearSemester;
    private int SemSemester;
    
    public static class Sem
    {
        static Semester s = new Semester();
    }
    
    public void setSubjectList()
    {
        String[] CodeSubject = null;
        String[] NameSubject = null;
        String[] CreditSubject = null;
        if(YearSemester==1){
            if(SemSemester==1){
                CodeSubject = new String[]{"DLHW1012","DLHW1722","DLHW1742","DLHW1712"};
                NameSubject = new String[]{"FOUNDATION ENGLISH","PHILOSOPHY OF SCIENCE AND TECHNOLOGY","LEADERSHIP","ETHNIC RELATIONS"};
                CreditSubject = new String[]{"2","2","2","2"};
            }else if(SemSemester==2){
                CodeSubject = new String[]{"DITI1213","DITM2113","DITP1113","DITP1333","DITS1133","DLHW2712","DKKC1611","DKKC2061","DKKI1781","DKKR2241"};
                NameSubject = new String[]{"CALCULUS","MULTIMEDIA SYSTEM","PROGRAMMING I","DATABASE","COMPUTER ORGANIZATION AND ARCHITECTURE","ETHNIC RELATIONS",
                                           "CAK LEMPONG","CHOIR","PHOTOGRAPHY","FENCING"};
                CreditSubject = new String[]{"3","3","3","3","3","2","1","1","1","1"};
            }else if(SemSemester==3){
                CodeSubject = new String[]{"DITI1223","DITM2123","DITP1123","DITS2213","DLHW2422"};
                NameSubject = new String[]{"DISCRETE MATHEMATICS","WEB PROGRAMMING","PROGRAMMING II","OPERATING SYSTEM","ENGLISH FOR EFFECTIVE COMMUNICATION"};
                CreditSubject = new String[]{"3","3","3","2"};
            }
        }
        else if(YearSemester==2){
            if(SemSemester==1){
                CodeSubject = new String[]{"DITP2113","DITP3113","DITS2313","DLHW3432","DLHW1032"};
                NameSubject = new String[]{"DATA STRUCTURE AND ALGORITHM","OBJECT ORIENTED PROGRAMMING","DATA COMMUNICATIONS AND NETWORKING",
                                           "ENGLISH FOR MARKETABILITY","MALAYSIAN STUDIES"};
                CreditSubject = new String[]{"3","3","3","2","2"};
            }else if(SemSemester==2){
                CodeSubject = new String[]{"DITP2313","DITP2213","DITI2213","DITS3623","DITI3513"};
                NameSubject = new String[]{"DATABASE PROGRAMMING","SYSTEM ANALYSIS AND DESIGN","LINEAR ALGEBRA AND NUMERICAL METHODS","NETWORK ROUTING",
                                           "ARTIFICIAL INTELLIGENCE IN ROBOTICS AND AUTOMATION"};
                CreditSubject = new String[]{"3","3","3","3","3"};
            }else if(SemSemester==3){
                CodeSubject = new String[]{"DITI2233","DITM3143","DITP3213","DITP3323","DITS3613","DTMW1012"};
                NameSubject = new String[]{"STATISTICS AND PROBABILITY","DIGITAL MEDIA DESIGN","SOFTWARE ENGINEERING","DATABASE ADMINISTRATION","BASIC NETWORKING",
                                           "FUNDAMENTALS OF ENTREPRENEURSHIP ENCULTURATION"};
                CreditSubject = new String[]{"3","3","3","3","3","2"};
            }
        }
        else if(YearSemester==3){
            if(SemSemester==1){
                CodeSubject = new String[]{"DITU2343","DITU2362"};
                NameSubject = new String[]{"INDUSTRIAL TRAINNING","INDUSTRIAL TRAINING REPORT"};
                CreditSubject = new String[]{"3","2"};
            }else if(SemSemester==2){
                CodeSubject = new String[]{"DITP3313","DITS2413"};
                NameSubject = new String[]{"DATABASE DESIGN","COMPUTER SECURITY"};
                CreditSubject = new String[]{"3","3"};
            }else if(SemSemester==3){
                CodeSubject = new String[]{"DITU3964"};
                NameSubject = new String[]{"DIPLOMA PROJECT"};
                CreditSubject = new String[]{"4"};
            }
        }
        super.setCodeSubject(CodeSubject);
        super.setNameSubject(NameSubject);
        super.setCreditSubject(CreditSubject);
    }
    public int getYearSemester()
    {
        return YearSemester;
    }
    public int getSemSemester()
    {
        return SemSemester;
    }
    public void setYearSemester(int YearSemester)
    {
        this.YearSemester = YearSemester;
    }
    public void setSemSemester(int SemSemester)
    {
        this.SemSemester = SemSemester;
    }
}