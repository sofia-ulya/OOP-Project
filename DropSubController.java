/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zamilahtaib
 */
public class DropSubController implements Initializable {

    @FXML
    private Button confirm, buttonCancel;
    
    @FXML
    private CheckBox sub1, sub2, sub3, sub4;
    
    @FXML
    private TextArea textAreaDrop;
    
    @FXML
    private Label year;
    
    @FXML
    void handleDropSub1(ActionEvent event) {
        if(sub1.isSelected()) {
            textAreaDrop.setText("\nDATA STRUCTURE AND ALGORITHM will be dropped.");
        }
        if (!(sub1.isSelected())) {
            textAreaDrop.setText(" ");
        }
    }

    @FXML
    void handleDropSub2(ActionEvent event) {
        if(sub2.isSelected()) {
            textAreaDrop.setText("\nOBJECT ORIENTED PROGRAMMING will be dropped.");
        }
        if (!(sub2.isSelected())) {
            textAreaDrop.setText(" ");
        }
    }

    @FXML
    void handleDropSub3(ActionEvent event) {
        if(sub3.isSelected()) {
            textAreaDrop.setText("\nDATA COMMUNICATION AND NETWORKING will be dropped.");
        }
        if (!(sub3.isSelected())) {
            textAreaDrop.setText(" ");
        }
    }

    @FXML
    void handleDropSub4(ActionEvent event) {
        if(sub4.isSelected()) {
            textAreaDrop.setText("\nLINEAR ALGEBRA AND NUMERICAL METHOD will be dropped.");
        }
        if (!(sub4.isSelected())) {
            textAreaDrop.setText(" ");
        }
    }
    
    @FXML
    void handleFormConfirmation(ActionEvent event) throws IOException {
        Parent dropSub = FXMLLoader.load(getClass().getResource("ConfirmDrop.fxml"));
        System.out.println("Application to drop subject(s)");
        Scene scene = new Scene(dropSub);

        Stage nextWindow = (Stage) ((Node)event.getSource()).getScene().getWindow(); //getWindow adik-beradik stage

        nextWindow.setTitle("Drop Subject Confirmation");  //set title utk pop up
        nextWindow.setScene(scene);
        nextWindow.show();
    }

    @FXML
    private void handleFormBack(ActionEvent event) throws IOException {
        Parent backBtn = FXMLLoader.load(getClass().getResource("AddDropSub.fxml"));
        System.out.println("Go back");
        Scene scene = new Scene(backBtn);
        
        Stage back = (Stage) ((Node)event.getSource()).getScene().getWindow(); //getWindow adik-beradik stage
        
        back.setTitle("Drop Subject Application");  //set title utk pop up
        back.setScene(scene);
        back.show();
    }
    
    public void dapatkanNilaiLabel(String pilihYear, String pilihSem) {
        year.setText(pilihYear + " / " + pilihSem);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
