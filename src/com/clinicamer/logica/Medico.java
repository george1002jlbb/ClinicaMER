/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinicamer.logica;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jorge Bermudez
 */
public class Medico {
    private int idmedico;
    private String nombre;
    private String apellido;
    private String tipoDoc;
    private int numeroDoc;
    private int numeroMed;
    private String idespecialidad;
    private String estado;

    public int getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(int idmedico) {
        this.idmedico = idmedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public int getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(int numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public int getNumeroMed() {
        return numeroMed;
    }

    public void setNumeroMed(int numeroMed) {
        this.numeroMed = numeroMed;
    }

    public String getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(String idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Medico{" + "idmedico=" + idmedico + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoDoc=" + tipoDoc + ", numeroDoc=" + numeroDoc + ", numeroMed=" + numeroMed + ", idespecialidad=" + idespecialidad + ", estado=" + estado + '}';
    }
        
    public static Medico load(ResultSet rs) throws SQLException {
        Medico m = new Medico();
        
        m.setIdmedico(rs.getInt(1));
        m.setNombre(rs.getString(2));
        m.setApellido(rs.getString(3));
        m.setTipoDoc(rs.getString(4));
        m.setNumeroDoc(rs.getInt(5));
        m.setNumeroMed(rs.getInt(6));
        m.setIdespecialidad(rs.getString(7));
        m.setEstado(rs.getString(8));
        
        return m;
    }
    
}
