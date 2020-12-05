/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author dilan
 */
public class Empleado implements Datos{
    private int id;
    private int cedula;
    private String cargo;
    private String nombreCompleto;
    private String fechaNacimiento;
    private String correoElectronico;
    private String direccionDomicilio;
    private  String telefono;
    private  int idCurso;
     private String colorCinturon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public void setDireccionDomicilio(String direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getColorCinturon() {
        return colorCinturon;
    }

    public void setColorCinturon(String colorCinturon) {
        this.colorCinturon = colorCinturon;
    }

    @Override
    public void registrarBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        ArrayList<Empleado> empleados = new ArrayList<>();
        try(Connection con = ConectionMySQL.getConection()) {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM KUNGFUPANDA.empleados");
            while (rs.next()){
                Empleado empleado = new Empleado();
                empleado.id = rs.getInt("id_empleado");
                empleado.nombreCompleto =rs.getString("nombre_completo");
                empleado.fechaNacimiento = rs.getString("fecha_nacimiento");
                empleado.correoElectronico=rs.getString("correo_electronico");
                empleado.direccionDomicilio= rs.getString("direccion_domicilio");
                empleado.telefono = rs.getString("teléfono_contacto");
                empleados.add(empleado);
            }
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return FXCollections.observableArrayList(empleados);
    }
    
    public static Empleado buscarEmpleado( int cedula ){
        Empleado empleado = new Empleado();
        try(Connection con = ConectionMySQL.getConection()) {
             String query = "{CALL obtenerEmpleado(?)}";
             CallableStatement cs = con.prepareCall(query);
             cs.setInt(1, cedula);
             ResultSet rs = cs.executeQuery();
             while (rs.next()){
                empleado.id= rs.getInt("ID_Empleado");
                empleado.nombreCompleto =rs.getString("nombre_completo");
                empleado.fechaNacimiento = rs.getString("fecha_nacimiento");
                empleado.correoElectronico=rs.getString("correo_electronico");
                empleado.direccionDomicilio= rs.getString("direccion_domicilio");
                empleado.telefono = rs.getString("teléfono_contacto");
             }
        } catch (Exception e) {
        }
        
        return empleado;
    }
    
    public static ArrayList<String> obtenerProfesor(){
        ArrayList<String> profesores = new ArrayList<>();
        try (Connection con = ConectionMySQL.getConection()){
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("");
        } catch (Exception e) {
        }
        return profesores;
    }
 
}
