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
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author zamilahtaib
 */
public class AddDropSubController implements Initializable {
    @FXML
    private RadioButton addsub, dropsub;

    @FXML
    private ToggleGroup adddrop;

    @FXML
    private Button submit, buttonBack;
    
    @FXML
    private ListView<String> codeSub, subSub, credSub;


    @FXML
    void handleFormBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Menu.fxml"));
        Parent backBtn = loader.load();
        System.out.println("Back to menu");

        Scene scene = new Scene(backBtn);
        Stage backWin = (Stage) ((Node)event.getSource()).getScene().getWindow(); //getWindow adik-beradik stage

        backWin.setTitle("Add or Drop Subject");  //set title utk pop up
        backWin.setScene(scene);
        backWin.show();
    }

    @FXML
    void handlechoice(ActionEvent event) throws IOException {
        if(addsub.isSelected()) {
            Parent regSub = FXMLLoader.load(getClass().getResource("Add.fxml"));
            System.out.println("Add subject");
            Scene scene = new Scene(regSub);

            Stage nextWindow = (Stage) ((Node)event.getSource()).getScene().getWindow(); //getWindow adik-beradik stage

            nextWindow.setTitle("Add subject");  //set title utk pop up
            nextWindow.setScene(scene);
            nextWindow.show();
        }else if(dropsub.isSelected()) {                              
            Parent regSub = FXMLLoader.load(getClass().getResource("Drop.fxml"));
            System.out.println("Drop subject");
            Scene scene = new Scene(regSub);

            Stage nextWindow = (Stage) ((Node)event.getSource()).getScene().getWindow(); //getWindow adik-beradik stage
            
            nextWindow.setTitle("Drop subject");  //set title utk pop up
            nextWindow.setScene(scene);
            nextWindow.show();            
        }else{
            JOptionPane.showMessageDialog(null, "Please choose one option to continue process.");
        }
    }
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
    }    
    
}
