/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class viewSubController implements Initializable {

    @FXML
    private Label name, matric, year, totalCredit;
    @FXML
    private ListView<String> codeSub, subSub, credSub, hey;
    @FXML
    private Button buttonBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> Code = Student.stu.getCodeSubject();
        codeSub.setItems(Code);
        ObservableList<String> Sub = Student.stu.getNameSubject();
        subSub.setItems(Sub);
        ObservableList<String> Cred = Student.stu.getCreditSubject();
        credSub.setItems(Cred);
        
        year.setText("Year: " + Semester.Sem.s.getYearSemester() + " Semester: "+ Semester.Sem.s.getSemSemester());
        name.setText(Student.stu.getNameStudent());
        matric.setText(Student.stu.getMatricStudent());
        totalCredit.setText("Total Credit: " + Student.stu.getTotalCredit());
    }

    @FXML
    private void handleButtonBack(ActionEvent event) throws IOException {
        Parent backBtn = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        System.out.println("Go back to menu page");
        Scene scene = new Scene(backBtn);
        
        Stage back = (Stage) ((Node)event.getSource()).getScene().getWindow(); //getWindow adik-beradik stage
        
        back.setTitle("Menu Page");  //set title utk pop up
        back.setScene(scene);
        back.show();
    }
    
    public void nilaiLabel() {
        year.setText("Year: " + Semester.Sem.s.getYearSemester() + " Semester "+ Semester.Sem.s.getSemSemester());
        name.setText(Student.stu.getNameStudent());
        matric.setText(Student.stu.getMatricStudent());
    }
   
 
}
