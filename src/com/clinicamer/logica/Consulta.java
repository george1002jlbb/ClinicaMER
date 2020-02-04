/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinicamer.logica;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jorge Bermudez
 */
public class Consulta {
    private int idconsulta;
    private int idpaciente;
    private int idmedico;
    private String especialidad;
    private Date feconsulta;
    private String observacion;
    private String estado;

    public int getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(int idconsulta) {
        this.idconsulta = idconsulta;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Date getFeconsulta() {
        return feconsulta;
    }

    public void setFeconsulta(Date feconsulta) {
        this.feconsulta = feconsulta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Consulta{" + "idconsulta=" + idconsulta + ", idpaciente=" + idpaciente + ", idmedico=" + idmedico + ", especialidad=" + especialidad + ", feconsulta=" + feconsulta + ", observacion=" + observacion + ", estado=" + estado + '}';
    }
    
    public static Consulta load(ResultSet rs) throws SQLException {
        Consulta c = new Consulta();
        
        c.setIdconsulta(rs.getInt(1));
        c.setIdpaciente(rs.getInt(2));
        c.setIdmedico(rs.getInt(3));
        c.setEspecialidad(rs.getString(4));
        c.setFeconsulta(rs.getDate(5));
        c.setObservacion(rs.getString(6));
        c.setEstado(rs.getString(7));
        
        return c;
    }
    
}
