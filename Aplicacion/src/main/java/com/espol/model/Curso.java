/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Curso implements Datos {
    
    private int idCurso;
    private int profesor;
    private String nombreProfesor;
    private String fechaClase;

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getProfesor() {
        return profesor;
    }

    public void setProfesor(int profesor) {
        this.profesor = profesor;
    }

    public String getFechaClase() {
        return fechaClase;
    }

    public void setFechaClase(String fechaClase) {
        this.fechaClase = fechaClase;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }
    
    
    
    @Override
    public void registrarBD() {
        try(Connection con = ConectionMySQL.getConection()) {
            String query ="INSERT INTO Clase(ID, Profesor ,Fecha_clase) VALUES (?,?,?)";
            PreparedStatement cs = con.prepareStatement(query);
            cs.setInt(1, this.idCurso);
            cs.setInt(2,946434396);
            cs.setDate(3,Date.valueOf(this.fechaClase ));
            cs.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Alerts.alertaError("Clase ya existente");
      }
    }

    @Override
    public void eliminarBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public static ObservableList buscarTodos() {
        ArrayList <Curso> cursos= new ArrayList<>();
        try(Connection con = ConectionMySQL.getConection()) {
             Statement s = con.createStatement();
             ResultSet rs = s.executeQuery ("SELECT * FROM KUNGFUPANDA.clases;");
             while(rs.next()){
                 Curso curso = new Curso();
                 curso.idCurso= rs.getInt("id");
                 curso.nombreProfesor=rs.getString("nombre_completo");
                 curso.fechaClase = rs.getString("fecha_clase");
                 cursos.add(curso);
             } 
        } catch (Exception e) {
        }
        return FXCollections.observableArrayList(cursos);
    
    }
    
      public static ArrayList<String> obtenerCursos (){
        ArrayList<String> cursos = new ArrayList<>();
        cursos.add("");
        try(Connection con = ConectionMySQL.getConection()) {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select distinct id from Clase");
            while(rs.next()){
                cursos.add(String.valueOf(rs.getInt("id")));
            }
        } catch (Exception e) {
        }
        return cursos;
    }
    
}
