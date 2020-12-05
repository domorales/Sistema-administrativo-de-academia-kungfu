/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.controller;

import com.espol.model.Estudiante;
import com.espol.proyectobd.App;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author dilan
 */
public class VistaMenuController implements Initializable {

    @FXML
    private Button bttRegistar;
    @FXML
    private Button bttBuscar;
    @FXML
    private Button bttPagos;
    @FXML
    private Button bttCeerrarSesion;
    @FXML
    private Button bttCompetir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registrar(MouseEvent event) throws IOException {
        App.setRoot("VistaRegistrar");
    }

    @FXML
    private void buscar(MouseEvent event) throws IOException {
            App.setRoot("VistaBuscar");
 
    }

    @FXML
    private void pagos(MouseEvent event) {
    }

    @FXML
    private void cerrarSesion(ActionEvent event) throws IOException {
         Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
       alerta.setContentText("¿Esta seguro de cerrar sesión? ");
       Optional<ButtonType> result = alerta.showAndWait();
       if(result.get().getText().equals("Aceptar")){
            App.setRoot("VistaLogin");
       } 
        
    }

    @FXML
    private void competir(MouseEvent event) throws IOException {
        App.setRoot("VistaCompetir2");
    }
    
}
