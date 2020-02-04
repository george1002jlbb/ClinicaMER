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
public class HistoriaMed {
    private int idhistoriaMed;
    private int idhistoria;
    private int idmedicamento;

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

    public int getIdmedicamento() {
        return idmedicamento;
    }

    public void setIdmedicamento(int idmedicamento) {
        this.idmedicamento = idmedicamento;
    }

    @Override
    public String toString() {
        return "HistoriaMed{" + "idhistoriaMed=" + idhistoriaMed + ", idhistoria=" + idhistoria + ", idmedicamento=" + idmedicamento + '}';
    }
    
    public static HistoriaMed load(ResultSet rs) throws SQLException {
        HistoriaMed hm = new HistoriaMed();
        
        hm.setIdhistoriaMed(rs.getInt(1));
        hm.setIdmedicamento(rs.getInt(2));
        hm.setIdhistoria(rs.getInt(3));
        
        return hm;
    }
}
