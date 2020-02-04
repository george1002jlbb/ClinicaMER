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
public class Incapacidad {
    private int idincapacidad;
    private int idpaciente;
    private int idmedico;
    private int dias;
    private String obs;
    private Date fecha;

    public int getIdincapacidad() {
        return idincapacidad;
    }

    public void setIdincapacidad(int idincapacidad) {
        this.idincapacidad = idincapacidad;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public int getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(int idmedico) {
        this.idmedico = idmedico;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Incapacidad{" + "idincapacidad=" + idincapacidad + ", idpaciente=" + idpaciente + ", idmedico=" + idmedico + ", dias=" + dias + ", obs=" + obs + ", fecha=" + fecha + '}';
    }
    
    public static Incapacidad load(ResultSet rs) throws SQLException {
        Incapacidad i = new Incapacidad();
        
        i.setIdincapacidad(rs.getInt(1));
        i.setIdpaciente(rs.getInt(2));
        i.setIdmedico(rs.getInt(3));
        i.setDias(rs.getInt(4));
        i.setObs(rs.getString(5));
        i.setFecha(rs.getDate(6));
        
        return i;
    }
    
}
