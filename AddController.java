/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */


public class AddController implements Initializable {

    int credit = Student.stu.getTotalCredit();
   
    @FXML
    private Button submit, buttonBack;
    @FXML
    private Label year, totalCredit;
    @FXML
    private CheckBox sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8, sub9, sub10;
    @FXML
    private ListView codeList, subjectList, creditList;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        codeList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        subjectList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        creditList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        ObservableList<String> Code = FXCollections.observableArrayList(Semester.Sem.s.getCodeSubject());
        ObservableList<String> Sub = FXCollections.observableArrayList(Semester.Sem.s.getNameSubject());
        ObservableList<String> Cred = FXCollections.observableArrayList(Semester.Sem.s.getCreditSubject());
        for(int i = 0; i<Code.size();i++)
        {
            for(int j = 0; j<Student.stu.getCodeSubject().size();j++)
            {
                if(Student.stu.getCodeSubject().get(j).equals(Code.get(i)))
                {
                    Code.remove(i);
                    Sub.remove(i);
                    Cred.remove(i);
                }
            }
        }
        codeList.setItems(Code);
        subjectList.setItems(Sub);
        creditList.setItems(Cred);
        
        year.setText("Year: " + Semester.Sem.s.getYearSemester() + " Semester "+ Semester.Sem.s.getSemSemester());
        totalCredit.setText("Total Credit: " + Student.stu.getTotalCredit());
    }
       
    @FXML
    private void handleFormSubmission(ActionEvent event) throws IOException {
         
        switch (Semester.Sem.s.getYearSemester()) {
            case 1:
                if(credit>=19){
                    totalCredit.setText("Total Credit: Error credit exceeds maximum");
                    JOptionPane.showMessageDialog(null, "Credit exceeds maximum.");}
                else {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("ConfirmAdd.fxml"));
                    Parent menuBtn = loader.load();
                    System.out.println("Confirmation to add subject(s)!");
        
                    Scene scene = new Scene(menuBtn);
                    Stage nextWindow = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
                    ConfirmAddController confirm = loader.getController();
        
                    nextWindow.setTitle("Confirm Add Subject");  //set title utk pop up
                    nextWindow.setScene(scene);
                    nextWindow.show();
                    confirm.getList(codeList, subjectList, creditList); 
                }   break;
            case 2:
                if(credit>=18){
                    totalCredit.setText("Total Credit: Error credit exceeds maximum");
                    JOptionPane.showMessageDialog(null, "Credit exceeds maximum.");}
                else {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("ConfirmAdd.fxml"));
                    Parent menuBtn = loader.load();
                    System.out.println("Confirmation to add subject(s)!");
        
                    Scene scene = new Scene(menuBtn);
                    Stage nextWindow = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
                    ConfirmAddController confirm = loader.getController();
        
                    nextWindow.setTitle("Confirm Add Subject");  //set title utk pop up
                    nextWindow.setScene(scene);
                    nextWindow.show();
                    confirm.getList(codeList, subjectList, creditList);
                }   break;
            case 3:
                if (credit >=6){
                    totalCredit.setText("Total Credit: Error credit exceeds maximum");
                    JOptionPane.showMessageDialog(null, "Credit exceeds maximum.");}
                else {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("ConfirmAdd.fxml"));
                    Parent menuBtn = loader.load();
                    System.out.println("Confirmation to add subject(s)!");
        
                    Scene scene = new Scene(menuBtn);
                    Stage nextWindow = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
                    ConfirmAddController confirm = loader.getController();
        
                    nextWindow.setTitle("Confirm Add Subject");  //set title utk pop up
                    nextWindow.setScene(scene);
                    nextWindow.show();
                    confirm.getList(codeList, subjectList, creditList);
                }   break;
            default:
                break;
        }
        Student.stu.setTotalCredit(credit);
    }

    @FXML
    private void handleFormBack(ActionEvent event) throws IOException {
        Parent backBtn = FXMLLoader.load(getClass().getResource("AddDropSub.fxml"));
        System.out.println("Go back");
        Scene scene = new Scene(backBtn);
        
        Stage back = (Stage) ((Node)event.getSource()).getScene().getWindow(); //getWindow adik-beradik stage
        
        back.setTitle("Add or Drop Subject");  //set title utk pop up
        back.setScene(scene);
        back.show();
    }
    
    @FXML
    private void handleCheckSub1(ActionEvent event) {
        if(sub1.isSelected()) {
            codeList.getSelectionModel().select(0);
            subjectList.getSelectionModel().select(0);
            creditList.getSelectionModel().select(0);
            switch (String.valueOf(creditList.getItems().get(0))) {
                case "3":
                    credit +=3;
                    break;
                case "2":
                    credit +=2;
                    break;
                case "1":
                    credit +=1;
                    break;
                default:
                    break;
            }
        }
        else{
            codeList.getSelectionModel().clearSelection(0);
            subjectList.getSelectionModel().clearSelection(0);
            creditList.getSelectionModel().clearSelection(0);
            switch (String.valueOf(creditList.getItems().get(0))) {
                case "3":
                    credit -=3;
                    break;
                case "2":
                    credit -=2;
                    break;
                case "1":
                    credit -=1;
                    break;
                default:
                    break;
            }
        }
        totalCredit.setText("Total Credit: " + String.valueOf(credit));
    }

    @FXML
    private void handleCheckSub2(ActionEvent event) {
        if(sub2.isSelected()){
            codeList.getSelectionModel().select(1);
            subjectList.getSelectionModel().select(1);
            creditList.getSelectionModel().select(1);
            switch (String.valueOf(creditList.getItems().get(1))) {
                case "3":
                    credit +=3;
                    break;
                case "2":
                    credit +=2;
                    break;
                case "1":
                    credit +=1;
                    break;
                default:
                    break;
            }
        }
        else{
            codeList.getSelectionModel().clearSelection(1);
            subjectList.getSelectionModel().clearSelection(1);
            creditList.getSelectionModel().clearSelection(1);
            switch (String.valueOf(creditList.getItems().get(1))) {
                case "3":
                    credit -=3;
                    break;
                case "2":
                    credit -=2;
                    break;
                case "1":
                    credit -=1;
                    break;
                default:
                    break;
            }
        }
        totalCredit.setText("Total Credit: " + String.valueOf(credit));
    }

    @FXML
    private void handleCheckSub3(ActionEvent event) {
        if(sub3.isSelected()){
            codeList.getSelectionModel().select(2);
            subjectList.getSelectionModel().select(2);
            creditList.getSelectionModel().select(2);
            switch (String.valueOf(creditList.getItems().get(2))) {
                case "3":
                    credit +=3;
                    break;
                case "2":
                    credit +=2;
                    break;
                case "1":
                    credit +=1;
                    break;
                default:
                    break;
            }
        }
        else{
            codeList.getSelectionModel().clearSelection(2);
            subjectList.getSelectionModel().clearSelection(2);
            creditList.getSelectionModel().clearSelection(2);
            switch (String.valueOf(creditList.getItems().get(2))) {
                case "3":
                    credit -=3;
                    break;
                case "2":
                    credit -=2;
                    break;
                case "1":
                    credit -=1;
                    break;
                default:
                    break;
            }
        }
        totalCredit.setText("Total Credit: " + String.valueOf(credit));
    }

    @FXML
    private void handleCheckSub4(ActionEvent event) {
        if(sub4.isSelected()){
            codeList.getSelectionModel().select(3);
            subjectList.getSelectionModel().select(3);
            creditList.getSelectionModel().select(3);
            switch (String.valueOf(creditList.getItems().get(3))) {
                case "3":
                    credit +=3;
                    break;
                case "2":
                    credit +=2;
                    break;
                case "1":
                    credit +=1;
                    break;
                default:
                    break;
            }
        }
        else{
            codeList.getSelectionModel().clearSelection(3);
            subjectList.getSelectionModel().clearSelection(3);
            creditList.getSelectionModel().clearSelection(3);
            switch (String.valueOf(creditList.getItems().get(3))) {
                case "3":
                    credit -=3;
                    break;
                case "2":
                    credit -=2;
                    break;
                case "1":
                    credit -=1;
                    break;
                default:
                    break;
            }
        }
        totalCredit.setText("Total Credit: " + String.valueOf(credit));
    }

    @FXML
    private void handleCheckSub5(ActionEvent event) {
        if(sub5.isSelected()){
            codeList.getSelectionModel().select(4);
            subjectList.getSelectionModel().select(4);
            creditList.getSelectionModel().select(4);
            switch (String.valueOf(creditList.getItems().get(4))) {
                case "3":
                    credit +=3;
                    break;
                case "2":
                    credit +=2;
                    break;
                case "1":
                    credit +=1;
                    break;
                default:
                    break;
            }
        }
        else{
            codeList.getSelectionModel().clearSelection(4);
            subjectList.getSelectionModel().clearSelection(4);
            creditList.getSelectionModel().clearSelection(4);
            switch (String.valueOf(creditList.getItems().get(4))) {
                case "3":
                    credit -=3;
                    break;
                case "2":
                    credit -=2;
                    break;
                case "1":
                    credit -=1;
                    break;
                default:
                    break;
            }
        }
        totalCredit.setText("Total Credit: " + String.valueOf(credit));
    }

    @FXML
    private void handleCheckSub6(ActionEvent event) {
        if(sub6.isSelected()){
            codeList.getSelectionModel().select(5);
            subjectList.getSelectionModel().select(5);
            creditList.getSelectionModel().select(5);
            switch (String.valueOf(creditList.getItems().get(5))) {
                case "3":
                    credit +=3;
                    break;
                case "2":
                    credit +=2;
                    break;
                case "1":
                    credit +=1;
                    break;
                default:
                    break;
            }
        }
        else{
            codeList.getSelectionModel().clearSelection(5);
            subjectList.getSelectionModel().clearSelection(5);
            creditList.getSelectionModel().clearSelection(5);
            switch (String.valueOf(creditList.getItems().get(5))) {
                case "3":
                    credit -=3;
                    break;
                case "2":
                    credit -=2;
                    break;
                case "1":
                    credit -=1;
                    break;
                default:
                    break;
            }
        }
        totalCredit.setText("Total Credit: " + String.valueOf(credit));
    }

    @FXML
    private void handleCheckSub7(ActionEvent event) {
        if(sub7.isSelected()){
            codeList.getSelectionModel().select(6);
            subjectList.getSelectionModel().select(6);
            creditList.getSelectionModel().select(6);
            switch (String.valueOf(creditList.getItems().get(6))) {
                case "3":
                    credit +=3;
                    break;
                case "2":
                    credit +=2;
                    break;
                case "1":
                    credit +=1;
                    break;
                default:
                    break;
            }
        }
        else{
            codeList.getSelectionModel().clearSelection(6);
            subjectList.getSelectionModel().clearSelection(6);
            creditList.getSelectionModel().clearSelection(6);
            switch (String.valueOf(creditList.getItems().get(6))) {
                case "3":
                    credit -=3;
                    break;
                case "2":
                    credit -=2;
                    break;
                case "1":
                    credit -=1;
                    break;
                default:
                    break;
            }
        }
        totalCredit.setText("Total Credit: " + String.valueOf(credit));
    }

    @FXML
    private void handleCheckSub8(ActionEvent event) {
        if(sub8.isSelected()){
            codeList.getSelectionModel().select(7);
            subjectList.getSelectionModel().select(7);
            creditList.getSelectionModel().select(7);
            switch (String.valueOf(creditList.getItems().get(7))) {
                case "3":
                    credit +=3;
                    break;
                case "2":
                    credit +=2;
                    break;
                case "1":
                    credit +=1;
                    break;
                default:
                    break;
            }
        }
        else{
            codeList.getSelectionModel().clearSelection(7);
            subjectList.getSelectionModel().clearSelection(7);
            creditList.getSelectionModel().clearSelection(7);
            switch (String.valueOf(creditList.getItems().get(7))) {
                case "3":
                    credit -=3;
                    break;
                case "2":
                    credit -=2;
                    break;
                case "1":
                    credit -=1;
                    break;
                default:
                    break;
            }
        }
        totalCredit.setText("Total Credit: " + String.valueOf(credit));
    }

    @FXML
    private void handleCheckSub9(ActionEvent event) {
        if(sub9.isSelected()){
            codeList.getSelectionModel().select(8);
            subjectList.getSelectionModel().select(8);
            creditList.getSelectionModel().select(8);
            switch (String.valueOf(creditList.getItems().get(8))) {
                case "3":
                    credit +=3;
                    break;
                case "2":
                    credit +=2;
                    break;
                case "1":
                    credit +=1;
                    break;
                default:
                    break;
            }
        }else{
            codeList.getSelectionModel().clearSelection(8);
            subjectList.getSelectionModel().clearSelection(8);
            creditList.getSelectionModel().clearSelection(8);
            switch (String.valueOf(creditList.getItems().get(8))) {
                case "3":
                    credit -=3;
                    break;
                case "2":
                    credit -=2;
                    break;
                case "1":
                    credit -=1;
                    break;
                default:
                    break;
            }
        }
        totalCredit.setText("Total Credit: " + String.valueOf(credit));
    }

    @FXML
    private void handleCheckSub10(ActionEvent event) {
        if(sub10.isSelected()){
            codeList.getSelectionModel().select(9);
            subjectList.getSelectionModel().select(9);
            creditList.getSelectionModel().select(9);
            switch (String.valueOf(creditList.getItems().get(9))) {
                case "3":
                    credit +=3;
                    break;
                case "2":
                    credit +=2;
                    break;
                case "1":
                    credit +=1;
                    break;
                default:
                    break;
            }
        }
        else{
            codeList.getSelectionModel().clearSelection(9);
            subjectList.getSelectionModel().clearSelection(9);
            creditList.getSelectionModel().clearSelection(9);
            switch (String.valueOf(creditList.getItems().get(9))) {
                case "3":
                    credit -=3;
                    break;
                case "2":
                    credit -=2;
                    break;
                case "1":
                    credit -=1;
                    break;
                default:
                    break;
            }
        }
        totalCredit.setText("Total Credit: " + String.valueOf(credit));
    }
}