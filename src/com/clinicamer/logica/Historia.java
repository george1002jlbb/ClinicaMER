/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinicamer.logica;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jorge Bermudez
 */
public class Historia {
    private int idhistoria;
    private int idpaciente;
    private Date fehistoria;
    private String alergias;
    private String habitos;
    private String antecedentes;
    private String diagnostico;
    private String tratamiento;
    private String observacion;

    public int getIdhistoria() {
        return idhistoria;
    }

    public void setIdhistoria(int idhistoria) {
        this.idhistoria = idhistoria;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Date getFehistoria() {
        return fehistoria;
    }

    public void setFehistoria(Date fehistoria) {
        this.fehistoria = fehistoria;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getHabitos() {
        return habitos;
    }

    public void setHabitos(String habitos) {
        this.habitos = habitos;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    public static Historia load(ResultSet rs) throws SQLException {
        Historia h = new Historia();
        
        h.setIdhistoria(rs.getInt(1));
        h.setIdpaciente(rs.getInt(2));
        h.setFehistoria(rs.getDate(3));
        h.setObservacion(rs.getString(4));
        h.setDiagnostico(rs.getString(5));
        h.setTratamiento(rs.getString(6));
        h.setAlergias(rs.getString(7));
        h.setAntecedentes(rs.getString(8));
        h.setHabitos(rs.getString(9));
        
        return h;
    }
}
