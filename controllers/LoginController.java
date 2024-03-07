/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.awt.Window;
import java.beans.EventHandler;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import models.Administrador;

/**
 * FXML Controller class
 *
 * @author spart
 */
public class LoginController implements Initializable {

    private Administrador admin = new Administrador();
    private int contador = 0;
    
    @FXML
    private PasswordField inputPassword;
    @FXML
    private Button btnAcceder;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void contadorIntentos(){
        if (contador >= 3){
            btnAcceder.setDisable(true);
        }
    }

    @FXML
    private void accederSistema(ActionEvent event) throws IOException {
        
        String password = inputPassword.getText();
        

        if (admin.accederSistema(password)==true) {
            
            Object eventSource = event.getSource(); 
            Node sourceAsNode = (Node) eventSource ;
            Scene oldScene = sourceAsNode.getScene();
            javafx.stage.Window window = oldScene.getWindow();
            Stage stage = (Stage) window ;
            //stage.hide(); OCULTA LA ECENA
                        
            Parent root = FXMLLoader.load(getClass().getResource("/views/viewPrincipal.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Inicio");
            stage.setScene(scene);
                                  
            
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Le queda "+(2-contador)+" intentos");
            alert.showAndWait();
            contador++;
            contadorIntentos();
        }
       
    }
    
}
