/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.controller;

import com.espol.model.Curso;
import com.espol.model.Empleado;
import com.espol.model.Estudiante;
import com.espol.model.Validaciones;
import com.espol.proyectobd.App;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author dilan
 */
public class VistaBuscarController implements Initializable {

    @FXML
    private ImageView imgUsuario;
    @FXML
    private ImageView imgEmpleado;
    @FXML
    private ImageView imgCurso;
    @FXML
    private ImageView imgSalir;
    @FXML
    private Pane panelEstuiante;
    @FXML
    private TextField textCedulaEstudiante;
    @FXML
    private Button bttBuscarEstudiante;
    @FXML
    private TextField textNombreEstudiante;
    @FXML
    private ComboBox comboBoxCinturonEstudiante;
    @FXML
    private ComboBox comboBoxCursoEstudiante;
    @FXML
    private TableView tableEstudiante;
    @FXML
    private TableColumn columnCedulaEstudiante;
    @FXML
    private TableColumn columnNombreEstudiante;
    @FXML
    private TableColumn columnCinturonEstudiante;
    @FXML
    private TableColumn columnCursoEstudiante;
    @FXML
    private Button bttEliminarEstudiante;
    @FXML
    private Button bttActualizarEstudiante;
    @FXML
    private Pane panelEmpleado;
    @FXML
    private TextField textIDempleado;
    @FXML
    private Button bttBuscarEmpleado;
    @FXML
    private TextField textFechaNacEmpleado;
    @FXML
    private ComboBox comboBoxCursoEmpleado;
    @FXML
    private TextField textNombreEmpleado;
    @FXML
    private TextField textDireccionEmpleado;
    @FXML
    private TextField textCorreoEmpleado;
    @FXML
    private TextField textTelfEmpleado;
    @FXML
    private TableView tableEmpleado;
    @FXML
    private TableColumn columnIDEmpleado;
    @FXML
    private TableColumn columnNombreEmpleado;
    @FXML
    private TableColumn columnFechaNacEmpleado;
    @FXML
    private TableColumn columnCorreoEmpleado;
    @FXML
    private TableColumn columnDireccionEmpleado;
    @FXML
    private TableColumn columnTelfEmpleado;
    @FXML
    private Button bttEliminarEmpleado;
    @FXML
    private Button bttActualizarEmpleado;
    @FXML
    private Pane panelCurso;
    @FXML
    private TextField textIDCurso;
    @FXML
    private TextField textProfesorCurso;
    @FXML
    private Button bttBuscarCurso;
    @FXML
    private TextField textFechaCurso;
    @FXML
    private TableView tableEstudiante1;
    @FXML
    private TableColumn columnIDCurso;
    @FXML
    private TableColumn columnProfesorCurso;
    @FXML
    private TableColumn columnFechaCurso;
    @FXML
    private Button bttEliminarCurso;
    @FXML
    private Button bttActualizarCurso;
    @FXML
    private TextField textEdadEstudiante;
    @FXML
    private TableColumn  columnEdadEstudiante;
    @FXML
    private Button bttLimpiarEstudiante;
    @FXML
    private Button bttLimpiarEmpleado;
    @FXML
    private Button bttLimpiarCurso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // columnas de la tabla empleado
        columnIDEmpleado.setCellValueFactory(new PropertyValueFactory("id"));
        columnNombreEmpleado.setCellValueFactory(new PropertyValueFactory("nombreCompleto"));
        columnCorreoEmpleado.setCellValueFactory(new PropertyValueFactory("correoElectronico"));
        columnFechaNacEmpleado.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        columnDireccionEmpleado.setCellValueFactory(new PropertyValueFactory("direccionDomicilio"));
        columnTelfEmpleado.setCellValueFactory(new PropertyValueFactory("telefono"));
        //columnCursoEmpleado.setCellValueFactory(new PropertyValueFactory("idCurso"));

        //columnas de la tabla estudiante
        columnCedulaEstudiante.setCellValueFactory(new PropertyValueFactory("cedula"));
        columnNombreEstudiante.setCellValueFactory(new PropertyValueFactory("nombreCompleto"));
        columnCinturonEstudiante.setCellValueFactory(new PropertyValueFactory("colorCinturon"));
        columnCursoEstudiante.setCellValueFactory(new PropertyValueFactory("idCurso"));
        columnEdadEstudiante.setCellValueFactory(new PropertyValueFactory("edad"));
        // columnas de la tabla curso
        columnIDCurso.setCellValueFactory(new PropertyValueFactory("idCurso"));
        columnProfesorCurso.setCellValueFactory(new PropertyValueFactory("nombreProfesor"));
        columnFechaCurso.setCellValueFactory(new PropertyValueFactory("fechaClase"));

        // restricciones en el textfield
        textCedulaEstudiante.setTextFormatter(Validaciones.restriccionesText("[0-9]{0,10}"));
        textIDempleado.setTextFormatter(Validaciones.restriccionesText("[0-9]*"));
        textIDCurso.setTextFormatter(Validaciones.restriccionesText("[0-9]*"));
        textProfesorCurso.setTextFormatter(Validaciones.restriccionesText("[a-zA-Z.,\\s]*"));

        tableEstudiante.setItems(Estudiante.buscarTodos());
        tableEstudiante1.setItems(Curso.buscarTodos());
        tableEmpleado.setItems(Empleado.buscarTodos());

    }

    @FXML
    private void cambiarUsuario(MouseEvent event) {
        panelCurso.setVisible(false);
        panelEmpleado.setVisible(false);
        panelEstuiante.setVisible(true);
    }

    @FXML
    private void cambiarEmpleado(MouseEvent event) {
        panelCurso.setVisible(false);
        panelEstuiante.setVisible(false);
        panelEmpleado.setVisible(true);
    }

    @FXML
    private void cambiarCurso(MouseEvent event) {
        panelEstuiante.setVisible(false);
        panelEmpleado.setVisible(false);
        panelCurso.setVisible(true);
    }

    @FXML
    private void salir(MouseEvent event) throws IOException {
        App.setRoot("VistaMenu");
    }

    @FXML
    private void buscarEstudiante(ActionEvent event) {
        try {
            Estudiante estudiante = Estudiante.buscarEstudiante(Integer.parseInt(textCedulaEstudiante.getText()));
            if (estudiante.getNombreCompleto() != null) {
                textCedulaEstudiante.setText(String.valueOf(estudiante.getCedula()));
                textNombreEstudiante.setText(estudiante.getNombreCompleto());
                textEdadEstudiante.setText(String.valueOf(estudiante.getEdad()));
                comboBoxCinturonEstudiante.getItems().clear();
                comboBoxCinturonEstudiante.getItems().add(estudiante.getColorCinturon());
                comboBoxCinturonEstudiante.getSelectionModel().selectFirst();
                comboBoxCursoEstudiante.getItems().clear();
                comboBoxCursoEstudiante.setItems(FXCollections.observableArrayList(Curso.obtenerCursos()));
                comboBoxCursoEstudiante.getSelectionModel().select(String.valueOf(estudiante.getIdCurso()));
                tableEstudiante.getItems().clear();
                ArrayList<Estudiante> lista = new ArrayList<>();
                lista.add(estudiante);
                tableEstudiante.setItems(FXCollections.observableArrayList(lista));
                tableEstudiante.getSelectionModel().select(estudiante);
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setContentText("Numero de cedula incorrecto o inexistente");
                alerta.show();

            }
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setContentText("Debe llenar el campo cedula");
            alerta.show();
        }
    }

    @FXML
    private void elegirCinturonEstudiante(ActionEvent event) {
    }

    @FXML
    private void elegirCursoEstudiante(ActionEvent event) {
    }

    @FXML
    private void eliminarEstudiante(ActionEvent event) {
        Estudiante estudiante = (Estudiante) tableEstudiante.getSelectionModel().getSelectedItem();
       Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
       alerta.setContentText("Esta seguro de eliminar al estudiante "+ estudiante.getNombreCompleto());
       Optional<ButtonType> result = alerta.showAndWait();
       if(result.get().getText().equals("Aceptar")){
            estudiante.eliminarBD();
            tableEstudiante.getItems().clear();
            tableEstudiante.setItems(Estudiante.buscarTodos());
            alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText(null);
            alerta.setContentText("Usuario eliminado");
            alerta.show();
       }
    }

    @FXML
    private void actualizarEstudiante(ActionEvent event) {
        Estudiante estudiante = (Estudiante) tableEstudiante.getSelectionModel().getSelectedItem();
       Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
       alerta.setContentText("Esta seguro de actualizar datos del estudiante "+ estudiante.getNombreCompleto());
       Optional<ButtonType> result = alerta.showAndWait();
       if(result.get().getText().equals("Aceptar")){
           estudiante.setEdad(Integer.parseInt(textEdadEstudiante.getText()));
           estudiante.setNombreCompleto(textNombreEstudiante.getText());
            estudiante.actualizarBD();
            tableEstudiante.getItems().clear();
            tableEstudiante.setItems(Estudiante.buscarTodos());
            alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText(null);
            alerta.setContentText("Usuario actualizado");
            alerta.show();
       }
    }

    @FXML
    private void buscarEmpleado(ActionEvent event) {
        try {
            Empleado empleado = Empleado.buscarEmpleado(Integer.parseInt(textIDempleado.getText()));
            if (empleado.getNombreCompleto() != null) {
                textIDempleado.setText(String.valueOf(empleado.getId()));
                textNombreEmpleado.setText(empleado.getNombreCompleto());
                textFechaNacEmpleado.setText(empleado.getFechaNacimiento());
                textCorreoEmpleado.setText(empleado.getCorreoElectronico());
                textDireccionEmpleado.setText(empleado.getDireccionDomicilio());
                textTelfEmpleado.setText(empleado.getTelefono());
                tableEmpleado.getItems().clear();
                ArrayList<Empleado> lista = new ArrayList<>();
                lista.add(empleado);
                tableEmpleado.setItems(FXCollections.observableArrayList(lista));
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setContentText("Numero de ID incorrecto o inexistente");
                alerta.show();
            }
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setContentText("Debe llenar el campo ID");
            alerta.show();
        }
    }


    @FXML
    private void elegirCursoEmpleado(ActionEvent event) {
    }


    @FXML
    private void eliminarEmpleado(ActionEvent event) {
       

       
    }

    @FXML
    private void actualizarEmpleado(ActionEvent event) {
    }

    @FXML
    private void buscarCurso(ActionEvent event) {
    }

    @FXML
    private void eliminarCurso(ActionEvent event) {
    }

    @FXML
    private void actualizarCurso(ActionEvent event) {
    }

    @FXML
    private void obtenerDatosTablaEstudiante(MouseEvent event) {
        Estudiante estudiante = (Estudiante) tableEstudiante.getSelectionModel().getSelectedItem();
        textCedulaEstudiante.setText(String.valueOf(estudiante.getCedula()));
        textCedulaEstudiante.setEditable(false);
        textNombreEstudiante.setText(estudiante.getNombreCompleto());
        textEdadEstudiante.setText(String.valueOf(estudiante.getEdad()));
        comboBoxCinturonEstudiante.getItems().clear();
        comboBoxCinturonEstudiante.getItems().add(estudiante.getColorCinturon());
        comboBoxCinturonEstudiante.getSelectionModel().selectFirst();
        comboBoxCursoEstudiante.setItems(FXCollections.observableArrayList(Curso.obtenerCursos()));
        comboBoxCursoEstudiante.getSelectionModel().select(String.valueOf(estudiante.getIdCurso()));
    }

    @FXML
    private void obtenerDatosTablaCurso(MouseEvent event) {
        Curso curso = (Curso) tableEstudiante1.getSelectionModel().getSelectedItem();
        textIDCurso.setText(String.valueOf(curso.getIdCurso()));
        textProfesorCurso.setText(curso.getNombreProfesor());
        textFechaCurso.setText(curso.getFechaClase());
    }

    @FXML
    private void limpiarEstudiante(ActionEvent event) {
        textCedulaEstudiante.clear();
        textNombreEstudiante.clear();
        textEdadEstudiante.clear();
        comboBoxCinturonEstudiante.getItems().clear();
        comboBoxCursoEstudiante.getItems().clear();
        tableEstudiante.getItems().clear();
        tableEstudiante.setItems(Estudiante.buscarTodos());
        textCedulaEstudiante.setEditable(true);
    }

    @FXML
    private void obtenerDatosTablaEmpleado(MouseEvent event) {
        Empleado empleado = (Empleado) tableEmpleado.getSelectionModel().getSelectedItem();
        textIDempleado.setText(String.valueOf(empleado.getId()));
        textNombreEmpleado.setText(empleado.getNombreCompleto());
         textFechaNacEmpleado.setText(empleado.getFechaNacimiento());
         textCorreoEmpleado.setText(empleado.getCorreoElectronico());
         textDireccionEmpleado.setText(empleado.getDireccionDomicilio());
         textTelfEmpleado.setText(empleado.getTelefono());
    }

    @FXML
    private void limpiarEmpleado(ActionEvent event) {    
        textIDempleado.clear();
        textNombreEmpleado.clear();
        textFechaNacEmpleado.clear();
        textCorreoEmpleado.clear();
        textDireccionEmpleado.clear();
        textTelfEmpleado.clear();
        tableEmpleado.setItems(Empleado.buscarTodos());
        textCedulaEstudiante.setEditable(true);
    }

    @FXML
    private void limpiarCurso(ActionEvent event) {
    }
          

}