/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.controller;

import com.espol.model.Curso;
import com.espol.model.Validaciones;
import com.espol.proyectobd.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author dilan
 */
public class VistaRegistrarController implements Initializable {

    @FXML
    private ImageView imgUsuario;
    @FXML
    private ImageView imgEmpleado;
    @FXML
    private ImageView imgCurso;
    @FXML
    private ImageView imgSalir;
    @FXML
    private Pane panelEstudiante;
    @FXML
    private TextField textCedula;
    @FXML
    private TextField textFechaRegistro;
    @FXML
    private ComboBox comboBoxCinturon;
    @FXML
    private ComboBox comboBoxCurso;
    @FXML
    private RadioButton radioBttSI;
    @FXML
    private ToggleGroup tieneFamiliar;
    @FXML
    private TextField textCedulaFamiliar;
    @FXML
    private RadioButton radioBttNo;
    @FXML
    private TextField textNombreCompleto;
    @FXML
    private Button bttRegistrarEstudiante;
    @FXML
    private Label labelCedulaFamiliar;
    @FXML
    private Label labelRegEmpleado;
    @FXML
    private TextField textCedulaEmpleado;
    @FXML
    private ComboBox comboBoxCinturonEmpleado;
    @FXML
    private TextField textFechaEmpleado;
    @FXML
    private TextField textNombreEmpleado;
    @FXML
    private Button bttRegistrarEmplrado;
    @FXML
    private Pane panelEmpleado;
    @FXML
    private TextField textCorreoEmpleado;
    @FXML
    private TextField textTelefonoEmpleado;
    @FXML
    private ComboBox comboBoxCursoEmpleado;
    @FXML
    private ComboBox comboBoxCargo;
    @FXML
    private Pane panelCurso;
    @FXML
    private Label labelRegCurso;
    @FXML
    private Button bttRegistrarCurso;
    @FXML
    private Label labelRegEstudiante;
    @FXML
    private TextField idClase;
    @FXML
    private TextField textFechaClase;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	definirFormatoTexto();
        configurarComboxs();
        
    }
    
    private void definirFormatoTexto(){
    	 textNombreCompleto.setTextFormatter(Validaciones.restriccionesText("[A-Za-z\\s]*"));
         textNombreEmpleado.setTextFormatter(Validaciones.restriccionesText("[A-Za-z\\s]*"));
         textCedula.setTextFormatter(Validaciones.restriccionesText("[0-9].{0,10}"));
         textCedulaEmpleado.setTextFormatter(Validaciones.restriccionesText("[0-9]{0,10}"));
         textCedulaFamiliar.setTextFormatter(Validaciones.restriccionesText("[0-9]{0,10}"));
         textTelefonoEmpleado.setTextFormatter(Validaciones.restriccionesText("[0-9]{0,10}"));
         textCorreoEmpleado.setTextFormatter(Validaciones.restriccionesText("[A-Za-z0-9._%+-@.]*"));
    }
    
    private void configurarComboxs(){
    	comboBoxCurso.getItems().clear();
        comboBoxCurso.setItems(FXCollections.observableArrayList(Curso.obtenerCursos()));
        comboBoxCursoEmpleado.getItems().clear();
        comboBoxCursoEmpleado.setItems(FXCollections.observableArrayList(Curso.obtenerCursos()));
        comboBoxCargo.getItems().clear();
        comboBoxCargo.getItems().addAll("Administración", "Mantenimiento","Profesor");
    }
    
    @FXML
    private void cambiarUsuario(MouseEvent event) {
        panelEmpleado.setVisible(false);
       bttRegistrarEmplrado.setVisible(false);
       labelRegEmpleado.setVisible(false);
       panelCurso.setVisible(false);
       bttRegistrarCurso.setVisible(false);
       labelRegCurso.setVisible(false);
       panelEstudiante.setVisible(true);
       labelRegEstudiante.setVisible(true);
       bttRegistrarEstudiante.setVisible(true);
    }

    @FXML
    private void cambiarEmpleado(MouseEvent event) {
       panelCurso.setVisible(false);
       bttRegistrarCurso.setVisible(false);
       labelRegCurso.setVisible(false);
       panelEstudiante.setVisible(false);
       labelRegEstudiante.setVisible(false);
       bttRegistrarEstudiante.setVisible(false);
        panelEmpleado.setVisible(true);
       bttRegistrarEmplrado.setVisible(true);
       labelRegEmpleado.setVisible(true);
    }

    @FXML
    private void cambiarCurso(MouseEvent event) {
       panelEstudiante.setVisible(false);
       labelRegEstudiante.setVisible(false);
       bttRegistrarEstudiante.setVisible(false);
       panelEmpleado.setVisible(false);
       bttRegistrarEmplrado.setVisible(false);
       labelRegEmpleado.setVisible(false);
       panelCurso.setVisible(true);
       bttRegistrarCurso.setVisible(true);
       labelRegCurso.setVisible(true);
    }

    @FXML
    private void salir(MouseEvent event) throws IOException {
        App.setRoot("VistaMenu");
    }

    @FXML
    private void elegirCinturon(ActionEvent event) {

    }

    @FXML
    private void elegirCurso(ActionEvent event) {
    }

    @FXML
    private void mostrarCedulaFamiliar(ActionEvent event) {
        if (radioBttSI.isSelected()) {
            textCedulaFamiliar.setVisible(true);
            labelCedulaFamiliar.setVisible(true);
        }
    }
    
    @FXML
    private void ocultarCedulaFamiliar(ActionEvent event) {
        if (radioBttNo.isSelected()) {
            textCedulaFamiliar.setVisible(false);
            labelCedulaFamiliar.setVisible(false);
        }
    }

    @FXML
    private void registrarEstudiante(ActionEvent event) {
        
    }

    @FXML
    private void elegirCinturonEmpleado(ActionEvent event) {
    }

    @FXML
    private void registrarEmpleado(ActionEvent event) {
    }

    @FXML
    private void elegirCursoEmpleado(ActionEvent event) {
    }

    @FXML
    private void elegirCargoEmpleado(ActionEvent event) {
    }


    @FXML
    private void registrarCurso(ActionEvent event) {
        Curso curso = new Curso();
        curso.setIdCurso(Integer.parseInt(idClase.getText()));
        curso.setFechaClase(textFechaClase.getText());
        curso.registrarBD();
    }


    }

    
    

