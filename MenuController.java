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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class MenuController implements Initializable {
    @FXML
    private RadioButton registerSub, adddropSub, viewSub;
    @FXML
    private TextArea desc;
    @FXML
    private Label choice;
    @FXML
    private Button handleNext,handleLogout;
    @FXML
    private ToggleGroup choiceSub;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void registerSub(ListView codeSub, ListView subSub, ListView credSub)
    {
       ObservableList<String> subCode = FXCollections.observableArrayList(codeSub.getSelectionModel().getSelectedItems());
       ObservableList<String> subName = FXCollections.observableArrayList(subSub.getSelectionModel().getSelectedItems());
       ObservableList<String> subCred = FXCollections.observableArrayList(credSub.getSelectionModel().getSelectedItems());
       Student.stu.setSubject(subCode, subName, subCred);
    }

    @FXML
    private void handleReg(ActionEvent event) {
        choice.setText("Register Subject");
        desc.setText("This menu is for students to choose subjects to register");
    }

    @FXML
    private void handleAddDrop(ActionEvent event) {
        choice.setText("Add/Drop Subject");
        desc.setText("This menu is for students to add/drop subjects for the semester");
    }

    @FXML
    private void handleView(ActionEvent event) {
        choice.setText("Register Subject");
        desc.setText("This menu is for students to view the subjects they registered for");
    }

    @FXML
    private void handleNextButton(ActionEvent event) throws IOException {
        if(registerSub.isSelected()) {
            Parent regSub = FXMLLoader.load(getClass().getResource("ChooseSemYear.fxml"));
            System.out.println("Register subject");
            Scene scene = new Scene(regSub);

            Stage nextWindow = (Stage) ((Node)event.getSource()).getScene().getWindow(); //getWindow adik-beradik stage

            nextWindow.setTitle("Subject Registration");  //set title utk pop up
            nextWindow.setScene(scene);
            nextWindow.show();
        }
        if(adddropSub.isSelected()) {                              //AddDropSub ni tukar ke fxml file utk add n drop subject
            Parent regSub = FXMLLoader.load(getClass().getResource("AddDropSub.fxml"));
            System.out.println("Register subject");
            Scene scene = new Scene(regSub);

            Stage nextWindow = (Stage) ((Node)event.getSource()).getScene().getWindow(); //getWindow adik-beradik stage
            
            nextWindow.setTitle("Subject Registration");  //set title utk pop up
            nextWindow.setScene(scene);
            nextWindow.show();
            
        }
        if(viewSub.isSelected()) {                                  //viewSub ni tukar jadi file yg utk view subjek dia ambik
            Parent regSub = FXMLLoader.load(getClass().getResource("viewSub.fxml"));
            System.out.println("Register subject");
            Scene scene = new Scene(regSub);

            Stage nextWindow = (Stage) ((Node)event.getSource()).getScene().getWindow(); //getWindow adik-beradik stage

            nextWindow.setTitle("Subject Registration");  //set title utk pop up
            nextWindow.setScene(scene);
            nextWindow.show();
            
        }
    }
    
    @FXML
    void handleLogoutButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("LoginFXMLDocument.fxml"));
        Parent logout = loader.load();
        System.out.println("Logout from system.");
        
        Scene scene = new Scene(logout);
        Stage nextWindow = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        nextWindow.setTitle("Login page");  //set title utk pop up
        nextWindow.setScene(scene);
        nextWindow.show();
    }
    
}
