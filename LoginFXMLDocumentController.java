/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class LoginFXMLDocumentController implements Initializable {
    
     @FXML
    private TextField TxtNoMatric,TxtPwdBox;

    @FXML
    private Button btnLogin;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    //Statement st = null;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private void handlebtnLogin(ActionEvent event) throws Exception{
          
        conn = mysqlconnect.ConnectDb();
        String sql = "Select * from student where Nomatric = ? and Password = ? ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, TxtNoMatric.getText());
            pst.setString(2, TxtPwdBox.getText());
            rs = pst.executeQuery();
            
            if(rs.next()) {
                Student.stu.setNameStudent(rs.getString("name"));
                Student.stu.setMatricStudent(TxtNoMatric.getText());
                
                System.out.println("Login Succesfully");
                btnLogin.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                Stage nextwindow = new Stage();
                Scene scene = new Scene(root);
                nextwindow.setTitle("Menu Page");
                nextwindow.setResizable(false);
                nextwindow.setScene(scene);
                nextwindow.show();
                System.out.println(Student.stu.getNameStudent());           
            } else {
                JOptionPane.showMessageDialog(null, "Invalid no matric Or password! Try Again.");
                System.out.println("Login Failed");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);   
        }
    }

    @FXML
    private void TxtNoMatAction(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            
        conn = mysqlconnect.ConnectDb();
        String sql = "Select * from student where Nomatric = ? and Password = ? ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, TxtNoMatric.getText());
            pst.setString(2, TxtPwdBox.getText());
            rs = pst.executeQuery();
            
            if(rs.next()) {
                Student.stu.setNameStudent(rs.getString("name"));
                Student.stu.setMatricStudent(TxtNoMatric.getText());
                
                System.out.println("Login Succesfully");
                btnLogin.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                Stage nextwindow = new Stage();
                Scene scene = new Scene(root);
                nextwindow.setTitle("Menu Page");
                nextwindow.setResizable(false);
                nextwindow.setScene(scene);
                nextwindow.show();
                System.out.println(Student.stu.getNameStudent());            
            } else {
                JOptionPane.showMessageDialog(null, "Please insert password.");
                TxtNoMatric.setText(" ");
                System.out.println("Login Failed");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        }
    }

    @FXML
    private void TxtPwdAction(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            
        conn = mysqlconnect.ConnectDb();
        String sql = "Select * from student where Nomatric = ? and Password = ? ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, TxtNoMatric.getText());
            pst.setString(2, TxtPwdBox.getText());
            rs = pst.executeQuery();
            
            if(rs.next()) {
                Student.stu.setNameStudent(rs.getString("name"));
                Student.stu.setMatricStudent(TxtNoMatric.getText());
                
                System.out.println("Login Succesfully");
                btnLogin.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                Stage nextwindow = new Stage();
                Scene scene = new Scene(root);
                nextwindow.setTitle("Menu Page");
                nextwindow.setResizable(false);
                nextwindow.setScene(scene);
                nextwindow.show();
                System.out.println(Student.stu.getNameStudent());
            } else {
                JOptionPane.showMessageDialog(null, "Invalid no matric Or password! Try Again.");
                TxtNoMatric.setText("");
                TxtPwdBox.setText("");
                System.out.println("Login Failed");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        }
    }
    
}
