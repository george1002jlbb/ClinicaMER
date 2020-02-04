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
public class Cirugia {
    private int idcirugia;
    private int idhistoria;
    private int idmedico;
    private String observacion;
    private Date fecha;

    public int getIdcirugia() {
        return idcirugia;
    }

    public void setIdcirugia(int idcirugia) {
        this.idcirugia = idcirugia;
    }

    public int getIdhistoria() {
        return idhistoria;
    }

    public void setIdhistoria(int idhistoria) {
        this.idhistoria = idhistoria;
    }

    public int getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(int idmedico) {
        this.idmedico = idmedico;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Cirugia{" + "idcirugia=" + idcirugia + ", idhistoria=" + idhistoria + ", idmedico=" + idmedico + ", observacion=" + observacion + ", fecha=" + fecha + '}';
    }

    public static Cirugia load(ResultSet rs) throws SQLException {
        Cirugia c = new Cirugia();
        
        c.setIdcirugia(rs.getInt(1));
        c.setIdmedico(rs.getInt(2));
        c.setIdhistoria(rs.getInt(3));
        c.setObservacion(rs.getString(4));
        c.setFecha(rs.getDate(5));
        
        return c;
    }    
    
}
