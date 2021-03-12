/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.controller;

import com.espol.controller.alerts.Alerts;
import com.espol.proyectobd.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author dilan
 */
public class VistaLoginController implements Initializable {

    @FXML
    private TextField textUsuario;
    @FXML
    private PasswordField textContaseña;
    @FXML
    private Button bttIngresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ingresar(MouseEvent event) throws IOException {
        if( textUsuario.getText().equals("admin") && textContaseña.getText().equals("1234"))
            App.setRoot("VistaMenu");
        else
        	Alerts.alertaError("Usuario o contraseña incorrecta");
    }
    
}
