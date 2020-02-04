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
public class Usuario {
    private int idusuario;
    private String usuario;
    private String clave;
    private String nombre;
    private Date fechaNew;
    private String estado;

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNew() {
        return fechaNew;
    }

    public void setFechaNew(Date fechaNew) {
        this.fechaNew = fechaNew;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public static Usuario load(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        
        u.setIdusuario(rs.getInt(1));
        u.setUsuario(rs.getString(2));
        u.setClave(rs.getString(3));
        u.setNombre(rs.getString(4));
        u.setFechaNew(rs.getDate(5));
        u.setEstado(rs.getString(6));
        
        return u;
    }
}
