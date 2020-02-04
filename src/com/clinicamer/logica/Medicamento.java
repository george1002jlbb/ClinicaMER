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
public class Medicamento {
    private int idmedicamento;
    private String nombre;
    private Date fecha;
    private  String observacion;

    public int getIdmedicamento() {
        return idmedicamento;
    }

    public void setIdmedicamento(int idmedicamento) {
        this.idmedicamento = idmedicamento;
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
        return "Medicamento{" + "idmedicamento=" + idmedicamento + ", nombre=" + nombre + ", fecha=" + fecha + ", observacion=" + observacion + '}';
    }
    
    public static Medicamento load(ResultSet rs) throws SQLException {
        Medicamento m = new Medicamento();
        
        m.setIdmedicamento(rs.getInt(1));
        m.setNombre(rs.getString(2));
        m.setFecha(rs.getDate(3));
        m.setObservacion(rs.getString(4));
        
        return m;
    }
}
