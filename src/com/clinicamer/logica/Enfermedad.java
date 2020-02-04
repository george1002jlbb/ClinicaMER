/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinicamer.logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Jorge Bermudez
 */
public class Enfermedad {
    private int idenfermedad;
    private String nombre;
    private Date fecha;
    private String observacion;

    public int getIdenfermedad() {
        return idenfermedad;
    }

    public void setIdenfermedad(int idenfermedad) {
        this.idenfermedad = idenfermedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "Enfermedad{" + "idenfermedad=" + idenfermedad + ", nombre=" + nombre + ", fecha=" + fecha + ", observacion=" + observacion + '}';
    }

    public static Enfermedad load(ResultSet rs) throws SQLException {
        Enfermedad e = new Enfermedad();
        
        e.setIdenfermedad(rs.getInt(1));
        e.setNombre(rs.getString(2));
        e.setFecha(rs.getDate(3));
        e.setObservacion(rs.getString(4));
        return e;
    }
    
}
