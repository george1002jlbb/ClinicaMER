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
public class HistoriaEnf {
    private int idhistoriaMed;
    private int idhistoria;
    private int idenfermedad;

    public int getIdhistoriaMed() {
        return idhistoriaMed;
    }

    public void setIdhistoriaMed(int idhistoriaMed) {
        this.idhistoriaMed = idhistoriaMed;
    }

    public int getIdhistoria() {
        return idhistoria;
    }

    public void setIdhistoria(int idhistoria) {
        this.idhistoria = idhistoria;
    }

    public int getIdenfermedad() {
        return idenfermedad;
    }

    public void setIdenfermedad(int idenfermedad) {
        this.idenfermedad = idenfermedad;
    }

    @Override
    public String toString() {
        return "HistoriaMed{" + "idhistoriaMed=" + idhistoriaMed + ", idhistoria=" + idhistoria + ", idmedicamento=" + idenfermedad + '}';
    }
    
    public static HistoriaEnf load(ResultSet rs) throws SQLException {
        HistoriaEnf he = new HistoriaEnf();
        
        he.setIdhistoriaMed(rs.getInt(1));
        he.setIdenfermedad(rs.getInt(2));
        he.setIdhistoria(rs.getInt(3));
        
        return he;
    }
}
