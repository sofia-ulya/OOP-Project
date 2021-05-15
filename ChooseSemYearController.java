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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class ChooseSemYearController implements Initializable {
    
    @FXML
    private Button submit, buttonBack;
    @FXML
    private ComboBox comboYear, comboSem;
    @FXML
    private Label yearLabel, semLabel;
    private String pilihYear, pilihSem;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> pilihYear = FXCollections.observableArrayList("Semester 1", "Semester 2", "Semester 3");
        comboSem.setItems(pilihYear);
        ObservableList<String> pilihSem = FXCollections.observableArrayList("Year 1", "Year 2", "Year 3", "Year 4");
        comboYear.setItems(pilihSem);
//        choiceBoxYear.getItems().addAll("Year 1", "Year 2", "Year 3", "Year 4");
//        choiceBoxSem.getItems().addAll("Semester 1", "Semester 2", "Semester 3");
    }    
    
    

    @FXML
    private void handleFormSubmission(ActionEvent event) throws IOException {
        //to tell not to go next screen if year/sem not chosen
        //exception handling utk if year and semester not chosen
        if(yearLabel.getText().isEmpty() && semLabel.getText().isEmpty())
            System.out.println("Choose a year/semester");
        else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ChooseSubjectFXMLDoc.fxml"));
            Parent nextBtn = loader.load();
            System.out.println("You chose a year and semester");

            Scene scene = new Scene(nextBtn);
            Stage nextWindow = (Stage) ((Node)event.getSource()).getScene().getWindow(); //getWindow adik-beradik stage

            ChooseSubjectFXMLDocController chooseYearSem = loader.getController();

//          chooseYearSem.dapatkanNilaiLabel(sem.getYearSemester(), sem.getSemSemester());
            System.out.println("Sini year: " + Semester.Sem.s.getYearSemester() + "sem: " + Semester.Sem.s.getSemSemester());
            

            nextWindow.setTitle("Subject Registration");  //set title utk pop up
            nextWindow.setScene(scene);
            nextWindow.show();
            chooseYearSem.dapatkanNilaiLabel();
        }
}

    @FXML
    private void handleFormBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Menu.fxml"));
        Parent backBtn = loader.load();
        System.out.println("Back to menu");

        Scene scene = new Scene(backBtn);
        Stage backWin = (Stage) ((Node)event.getSource()).getScene().getWindow(); //getWindow adik-beradik stage

        backWin.setTitle("Subject Registration");  //set title utk pop up
        backWin.setResizable(false);
        backWin.setScene(scene);
        backWin.show();
    }

    @FXML
    private void cbSem(ActionEvent event) {
        pilihSem = (String) comboSem.getSelectionModel().getSelectedItem();
        semLabel.setText(pilihSem);
        switch (pilihSem) {
            case "Semester 1":
                Semester.Sem.s.setSemSemester(1);
                break;
            case "Semester 2":
                Semester.Sem.s.setSemSemester(2);
                break;
            case "Semester 3":
                Semester.Sem.s.setSemSemester(3);
                break;
            default:
                break;
        }
        System.out.println("Sem = " + Semester.Sem.s.getSemSemester());
        Semester.Sem.s.setSubjectList();
        System.out.println("Subject = " + Semester.Sem.s.getNameSubject());
        System.out.println("Code = " + Semester.Sem.s.getCodeSubject());
    }

    @FXML
    private void cbYear(ActionEvent event) {
        pilihYear = (String) comboYear.getSelectionModel().getSelectedItem();
        yearLabel.setText(pilihYear);
        switch (pilihYear) {
            case "Year 1":
                Semester.Sem.s.setYearSemester(1);
                break;
            case "Year 2":
                Semester.Sem.s.setYearSemester(2);
                break;
            case "Year 3":
                Semester.Sem.s.setYearSemester(3);
                break;
            default:
                break;
        }
        System.out.println("Year = " + Semester.Sem.s.getYearSemester());
    }
}
