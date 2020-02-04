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
public class Paciente {
    private int idpaciente;
    private String nombre;
    private String apellido;
    private String sexo;
    private String tipoDoc;
    private int numeroDoc;
    private String tipoSangre;
    private String eps;
    private int peso;
    private String estado;

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Paciente{" + "idpaciente=" + idpaciente + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo + ", tipoDoc=" + tipoDoc + ", numeroDoc=" + numeroDoc + ", tipoSangre=" + tipoSangre + ", eps=" + eps + ", peso=" + peso + ", estado=" + estado + '}';
    }
        
    public static Paciente load(ResultSet rs) throws SQLException {
        Paciente p = new Paciente();
        
        p.setIdpaciente(rs.getInt(1));
        p.setNombre(rs.getString(2));
        p.setApellido(rs.getString(3));
        p.setSexo(rs.getString(4));
        p.setTipoDoc(rs.getString(5));
        p.setNumeroDoc(rs.getInt(6));
        p.setTipoSangre(rs.getString(7));
        p.setEps(rs.getString(8));
        p.setPeso(rs.getInt(9));
        p.setEstado(rs.getString(10));
        
        return p;
    }
    
}
