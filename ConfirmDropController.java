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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ConfirmDropController implements Initializable {

    @FXML
    private ListView<String> codeSub, subSub, credSub;
    @FXML
    private Button backBtn;
    @FXML
    private Button dropBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void getList(ListView codeList, ListView subjectList, ListView creditList) {
        ObservableList<String> dispCode = FXCollections.observableArrayList(codeList.getSelectionModel().getSelectedItems());
        codeSub.setItems(dispCode);
        ObservableList<String> dispSub = FXCollections.observableArrayList(subjectList.getSelectionModel().getSelectedItems());
        subSub.setItems(dispSub);
        ObservableList<String> dispCred = FXCollections.observableArrayList(creditList.getSelectionModel().getSelectedItems());
        credSub.setItems(dispCred);
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        Parent backBtn = FXMLLoader.load(getClass().getResource("Drop.fxml"));
        System.out.println("Go back");
        Scene scene = new Scene(backBtn);
        
        Stage back = (Stage) ((Node)event.getSource()).getScene().getWindow(); //getWindow adik-beradik stage
        
        back.setTitle("Drop Subject");  //set title utk pop up
        back.setScene(scene);
        back.show();
    }

    @FXML
    private void handleDropButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Menu.fxml"));
        Parent menuBtn = loader.load();
        System.out.println("Subject has been dropped!");
        
        Scene scene = new Scene(menuBtn);
        Stage nextWindow = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        nextWindow.setTitle("Menu page");  //set title utk pop up
        nextWindow.setScene(scene);
        nextWindow.show();
        Student.stu.setDropSubject(codeSub.getItems(), subSub.getItems(), credSub.getItems());
    }
 
}
