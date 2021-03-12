/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.espol.controller.alerts.Alerts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author dilan
 */
public class Estudiante implements  Datos{
    public int cedula;
    private int cedulaFamiliar;
    private String nombreCompleto;
    private String fechaRegistro;
    private String colorCinturon;
    private int idCurso;
    private int edad;
        
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getCedulaFamiliar() {
        return cedulaFamiliar;
    }

    public void setCedulaFamiliar(int cedulaFamiliar) {
        this.cedulaFamiliar = cedulaFamiliar;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getColorCinturon() {
        return colorCinturon;
    }

    public void setColorCinturon(String colorCinturon) {
        this.colorCinturon = colorCinturon;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public void registrarBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarBD() {
        try(Connection con = ConectionMySQL.getConection()) {
            String query = "Delete from Estudiante where Cedula =?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, this.cedula);
            ps.execute();
            
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText(e.getMessage());
            alerta.show();
        }
    }

    @Override
    public void actualizarBD() {
        try(Connection con = ConectionMySQL.getConection()) {
            String query = "Update  Estudiante set Nombre_Completo =? , Edad = ? where Cedula =?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, this.nombreCompleto);
            ps.setInt(2, this.edad);
            ps.setInt(3, this.cedula);
            ps.execute();
            
        } catch (Exception e) {
        	Alerts.alertaError(e.getMessage());
        }
    }

    
    public  static ObservableList buscarTodos() {
        ArrayList <Estudiante> estudiantes = new ArrayList<>();
        try(Connection con = ConectionMySQL.getConection()) {
             Statement s = con.createStatement();
             ResultSet rs = s.executeQuery ("SELECT * FROM KUNGFUPANDA.estudiantes");
             while(rs.next()){
                 Estudiante estudiante = new Estudiante();
                 estudiante.cedula= rs.getInt("cedula");
                 estudiante.nombreCompleto=rs.getString("nombre_completo");
                 estudiante.edad=rs.getInt("edad");
                 estudiante.colorCinturon=rs.getString("color");
                 estudiante.idCurso=rs.getInt("clase");
                 estudiantes.add(estudiante);
             } 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return FXCollections.observableArrayList(estudiantes);
    }
    
    public static Estudiante buscarEstudiante( int cedula ){
        Estudiante estudiante = new Estudiante();
        try(Connection con = ConectionMySQL.getConection()) {
             String query = "{CALL obtenerEstudiante(?)}";
             CallableStatement cs = con.prepareCall(query);
             cs.setInt(1, cedula);
             ResultSet rs = cs.executeQuery();
             while (rs.next()){
                estudiante.cedula= rs.getInt("cedula");
                estudiante.nombreCompleto=rs.getString("nombre_completo");
                estudiante.edad=rs.getInt("edad");
                 estudiante.colorCinturon=rs.getString("color");
                 estudiante.idCurso=rs.getInt("clase");
             }
        } catch (Exception e) {
        }
        
        return estudiante;
    }
    
  
     
}
