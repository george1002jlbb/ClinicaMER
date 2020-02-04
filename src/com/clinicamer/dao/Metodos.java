/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinicamer.dao;

import com.clinicamer.logica.Cirugia;
import com.clinicamer.logica.Consulta;
import com.clinicamer.logica.Enfermedad;
import com.clinicamer.logica.Historia;
import com.clinicamer.logica.HistoriaEnf;
import com.clinicamer.logica.HistoriaMed;
import com.clinicamer.logica.Incapacidad;
import com.clinicamer.logica.Medicamento;
import com.clinicamer.logica.Medico;
import com.clinicamer.logica.Paciente;
import com.clinicamer.logica.Usuario;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jorge Bermudez
 */
public class Metodos {

    private Conn conn = new Conn();

    // MODULO DE USUARIO
    public boolean Iniciosesion(String id, String clave) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("SELECT COUNT(*) FROM usuarios WHERE usuario=? AND clave=? AND estado='ACTIVO'");
            pst.setString(1, id);
            pst.setString(2, clave);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - Iniciosesion -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return true;
    }

    public void guardarUsuario(Usuario u) throws IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("INSERT INTO usuarios VALUES (?,?,?,?,?,?)");
            pst.setInt(1, u.getIdusuario());
            pst.setString(2, u.getUsuario());
            pst.setString(3, u.getClave());
            pst.setString(4, u.getNombre());
            pst.setDate(5, new java.sql.Date(u.getFechaNew().getTime()));
            pst.setString(6, "ACTIVO");
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error Method - guardarUsuario -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }
    
     public Usuario consultarUsuarioId(int Idpaciente) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario u = new Usuario();
        try {
            pst = conexion.prepareStatement("SELECT * FROM usuarios WHERE idusuario = ?");
            pst.setInt(1, Idpaciente);
            rs = pst.executeQuery();
            while (rs.next()) {
                u = Usuario.load(rs);
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarUsuarioId -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return u;
    }

    public boolean existeUser(String user) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Paciente p = new Paciente();
        try {
            pst = conexion.prepareStatement("SELECT COUNT(*) FROM usuarios WHERE usuario = ?");
            pst.setString(1, user);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - existeUsuario -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return true;
    }

    public void modificarUser(Usuario u) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("UPDATE usuarios SET clave=?, nombre=?, estado=? WHERE usuario=?");
            pst.setString(1, u.getClave());
            pst.setString(2, u.getNombre());
            pst.setString(3, u.getEstado());
            pst.setString(4, u.getUsuario());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error Method - modificarUser -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }
    
    public List consultarUserNombre(String NOMBRE) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lusuario = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM usuarios WHERE nombre LIKE ?");
            NOMBRE = NOMBRE + "%";
            pst.setString(1, NOMBRE);
            rs = pst.executeQuery();
            while (rs.next()) {
                lusuario.add(Usuario.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarUserNombre -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lusuario;
    }
    
    public List listarTodosUsers() throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lusuario = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM usuarios");
            rs = pst.executeQuery();
            while (rs.next()) {
                lusuario.add(Usuario.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - listarTodosUsers -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lusuario;
    }

    // MODULO PACIENTE
    public void guardarPaciente(Paciente p) throws IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("INSERT INTO paciente VALUES (?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, p.getIdpaciente());
            pst.setString(2, p.getNombre().toUpperCase());
            pst.setString(3, p.getApellido().toUpperCase());
            pst.setString(4, p.getSexo().toUpperCase());
            pst.setString(5, p.getTipoDoc().toUpperCase());
            pst.setInt(6, p.getNumeroDoc());
            pst.setString(7, p.getTipoSangre());
            pst.setString(8, p.getEps().toUpperCase());
            pst.setInt(9, p.getPeso());
            pst.setString(10, "ACTIVO");
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error Method - guardarPaciente -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }

    public Paciente consultarPaciente(String cedula) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Paciente p = new Paciente();
        try {
            pst = conexion.prepareStatement("SELECT * FROM paciente WHERE numeroDoc = ?");
            pst.setInt(1, Integer.parseInt(cedula));
            rs = pst.executeQuery();
            while (rs.next()) {
                p = Paciente.load(rs);
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarPaciente -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return p;
    }

    public Paciente consultarPacienteId(int Idpaciente) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Paciente p = new Paciente();
        try {
            pst = conexion.prepareStatement("SELECT * FROM paciente WHERE Idpaciente = ?");
            pst.setInt(1, Idpaciente);
            rs = pst.executeQuery();
            while (rs.next()) {
                p = Paciente.load(rs);
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarPacienteId -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return p;
    }

    public List consultarPacientes(String cedula) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lpaciente = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM paciente WHERE numeroDoc = ?");
            pst.setInt(1, Integer.parseInt(cedula));
            rs = pst.executeQuery();
            while (rs.next()) {
                lpaciente.add(Paciente.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarPacientes -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lpaciente;
    }

    public List consultarPacienteNombre(String NOMBRE) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lpaciente = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM paciente WHERE nombre LIKE ?");
            NOMBRE = NOMBRE + "%";
            pst.setString(1, NOMBRE);
            rs = pst.executeQuery();
            while (rs.next()) {
                lpaciente.add(Paciente.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarPacienteNombre -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lpaciente;
    }

    public List listarPacienteNombre() throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lpaciente = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM paciente ORDER BY nombre");
            rs = pst.executeQuery();
            while (rs.next()) {
                lpaciente.add(Paciente.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - listarPacienteNombre -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lpaciente;
    }

    public List consultarPacienteApellido(String NOMBRE) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lpaciente = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM paciente WHERE apellido LIKE ?");
            NOMBRE = NOMBRE + "%";
            pst.setString(1, NOMBRE);
            rs = pst.executeQuery();
            while (rs.next()) {
                lpaciente.add(Paciente.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarPacienteApellido -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lpaciente;
    }

    public List listarTodosPacientes() throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lpaciente = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM paciente");
            rs = pst.executeQuery();
            while (rs.next()) {
                lpaciente.add(Paciente.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - listarTodosPacientes -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lpaciente;
    }

    public boolean existePaciente(int cedula) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Paciente p = new Paciente();
        try {
            pst = conexion.prepareStatement("SELECT COUNT(*) FROM paciente WHERE numeroDoc = ?");
            pst.setInt(1, cedula);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarPaciente -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return true;
    }

    public void modificarPaciente(Paciente p) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("UPDATE paciente SET nombre=?, apellido=?, sexo=?, tipoSangre=?, eps=?, peso=?, estado=? WHERE numeroDoc=?");
            pst.setString(1, p.getNombre().toUpperCase());
            pst.setString(2, p.getApellido().toUpperCase());
            pst.setString(3, p.getSexo());
            pst.setString(4, p.getTipoSangre().toUpperCase());
            pst.setString(5, p.getEps().toUpperCase());
            pst.setInt(6, p.getPeso());
            pst.setString(7, p.getEstado());
            pst.setInt(8, p.getNumeroDoc());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error Method - modificarPaciente -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }

    // MODULO MEDICO
    public void guardarMedico(Medico m) throws IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("INSERT INTO medico VALUES (?,?,?,?,?,?,?,?)");
            pst.setInt(1, m.getIdmedico());
            pst.setString(2, m.getNombre().toUpperCase());
            pst.setString(3, m.getApellido().toUpperCase());
            pst.setString(4, m.getTipoDoc().toUpperCase());
            pst.setInt(5, m.getNumeroDoc());
            pst.setInt(6, m.getNumeroMed());
            pst.setString(7, m.getIdespecialidad());
            pst.setString(8, "ACTIVO");
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error Method - guardarMedico -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }

    public Medico consultarMedico(String cedula) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Medico m = new Medico();
        try {
            pst = conexion.prepareStatement("SELECT * FROM medico WHERE numeroDoc = ?");
            pst.setInt(1, Integer.parseInt(cedula));
            rs = pst.executeQuery();
            while (rs.next()) {
                m = Medico.load(rs);
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarMedico -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return m;
    }

    public Medico consultarMedicoId(int idmedico) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Medico m = new Medico();
        try {
            pst = conexion.prepareStatement("SELECT * FROM medico WHERE idmedico = ?");
            pst.setInt(1, idmedico);
            rs = pst.executeQuery();
            while (rs.next()) {
                m = Medico.load(rs);
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarMedicoId -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return m;
    }

    public List consultarMedicos(String cedula) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lmedico = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM medico WHERE numeroDoc = ?");
            pst.setInt(1, Integer.parseInt(cedula));
            rs = pst.executeQuery();
            while (rs.next()) {
                lmedico.add(Medico.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarMedicos -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lmedico;
    }

    public List consultarMedicoNombre(String NOMBRE) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lmedico = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM medico WHERE nombre LIKE ?");
            NOMBRE = NOMBRE + "%";
            pst.setString(1, NOMBRE);
            rs = pst.executeQuery();
            while (rs.next()) {
                lmedico.add(Medico.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarMedicoNombre -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lmedico;
    }

    public List listarMedicoNombre() throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lmedico = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM medico ORDER BY nombre");
            rs = pst.executeQuery();
            while (rs.next()) {
                lmedico.add(Medico.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - listarMedicoNombre -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lmedico;
    }

    public List consultarMedicoApellido(String NOMBRE) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lmedico = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM medico WHERE apellido LIKE ?");
            NOMBRE = NOMBRE + "%";
            pst.setString(1, NOMBRE);
            rs = pst.executeQuery();
            while (rs.next()) {
                lmedico.add(Medico.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarMedicoApellido -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lmedico;
    }

    public List listarTodosMedicos() throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lmedico = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM medico");
            rs = pst.executeQuery();
            while (rs.next()) {
                lmedico.add(Medico.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - listarTodosMedicos -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lmedico;
    }

    public boolean existeMedico(int cedula) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("SELECT COUNT(*) FROM medico WHERE numeroDoc = ?");
            pst.setInt(1, cedula);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarPaciente -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return true;
    }

    public void modificarMedico(Medico m) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("UPDATE medico SET nombre=?, apellido=?, numeroMed=?, idespecialidad=?, estado=? WHERE numeroDoc=?");
            pst.setString(1, m.getNombre().toUpperCase());
            pst.setString(2, m.getApellido().toUpperCase());
            pst.setInt(3, m.getNumeroMed());
            pst.setString(4, m.getIdespecialidad());
            pst.setString(5, m.getEstado());
            pst.setInt(6, m.getNumeroDoc());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error Method - modificarMedico -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }

    // CONSULTAS
    public void guardarCita(Consulta c) throws IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("INSERT INTO consulta VALUES (?,?,?,?,?,?,?)");
            pst.setInt(1, c.getIdconsulta());
            pst.setInt(2, c.getIdpaciente());
            pst.setInt(3, c.getIdmedico());
            pst.setString(4, c.getEspecialidad());
            pst.setDate(5, new java.sql.Date(c.getFeconsulta().getTime()));
            pst.setString(6, c.getObservacion());
            pst.setString(7, "ACTIVO");
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error Method - guardarCita -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }

    public Consulta consultarCita(String cedula, Date fecha) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Consulta c = new Consulta();
        try {
            pst = conexion.prepareStatement("SELECT c.* FROM consulta c, paciente p WHERE p.idpaciente=c.idpaciente AND p.cedula=? AND c.feconsulta=?");
            pst.setInt(1, Integer.parseInt(cedula));
            pst.setDate(2, fecha);
            rs = pst.executeQuery();
            while (rs.next()) {
                c = Consulta.load(rs);
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarCitas -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return c;
    }

    public Consulta consultarCita(int nroorden) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Consulta c = new Consulta();
        try {
            pst = conexion.prepareStatement("SELECT c.* FROM consulta c, paciente p WHERE p.idpaciente=c.idpaciente AND c.idconsulta=?");
            pst.setInt(1, nroorden);
            rs = pst.executeQuery();
            while (rs.next()) {
                c = Consulta.load(rs);
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarCita -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return c;
    }

    public List consultarCitaPaciente(String cedula) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lcitas = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT c.* FROM consulta c, paciente p WHERE p.idpaciente=c.idpaciente AND p.cedula=?");
            pst.setInt(1, Integer.parseInt(cedula));
            rs = pst.executeQuery();
            while (rs.next()) {
                lcitas.add(Consulta.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarCitas -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lcitas;
    }

    public List consultarCitaNombre(String NOMBRE) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lcitas = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT c.* FROM consulta c, paciente p WHERE p.idpaciente=c.idpaciente AND p.nombre LIKE ?");
            NOMBRE = NOMBRE + "%";
            pst.setString(1, NOMBRE);
            rs = pst.executeQuery();
            while (rs.next()) {
                lcitas.add(Consulta.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarCitaNombre -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lcitas;
    }

    public List consultarCitaApellido(String NOMBRE) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lcitas = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT c.* FROM consulta c, paciente p WHERE p.idpaciente=c.idpaciente AND p.apellido LIKE ?");
            NOMBRE = NOMBRE + "%";
            pst.setString(1, NOMBRE);
            rs = pst.executeQuery();
            while (rs.next()) {
                lcitas.add(Consulta.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarCitaApellido -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lcitas;
    }

    public List listarTodosCitas() throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lcitas = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT c.* FROM consulta c, paciente p WHERE p.idpaciente=c.idpaciente");
            rs = pst.executeQuery();
            while (rs.next()) {
                lcitas.add(Consulta.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - listarTodosCitas -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lcitas;
    }

    public boolean existeCita(int cedula, Date fecha) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("SELECT COUNT(*) FROM consulta c, paciente p WHERE c.idpaciente = p.idpaciente AND p.numeroDoc=? AND c.feconsulta=?");
            pst.setInt(1, cedula);
            pst.setDate(2, fecha);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - existeCita -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return true;
    }

    public void modificarCita(Consulta c) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("UPDATE consulta SET feconsulta=?, observacion=?, estado=? WHERE idconsulta=?");
            pst.setDate(1, new java.sql.Date(c.getFeconsulta().getTime()));
            pst.setString(2, c.getObservacion());
            pst.setString(3, c.getEstado());
            pst.setInt(4, c.getIdconsulta());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error Method - modificarCita -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }

    // HISTORIA
    public void guardarHistoria(Historia h) throws IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("INSERT INTO historia VALUES (?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, h.getIdhistoria());
            pst.setInt(2, h.getIdpaciente());
            pst.setDate(3, new java.sql.Date(h.getFehistoria().getTime()));
            pst.setString(4, h.getObservacion());
            pst.setString(5, h.getDiagnostico());
            pst.setString(6, h.getTratamiento());
            pst.setString(7, h.getAlergias());
            pst.setString(8, h.getAntecedentes());
            pst.setString(9, h.getHabitos());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error Method - guardarHistoria -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }

    public Historia consultarhistoria(String cedula) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Historia h = new Historia();
        try {
            pst = conexion.prepareStatement("SELECT h.* FROM historia h, paciente p WHERE p.idpaciente=h.idpaciente AND p.cedula=?");
            pst.setInt(1, Integer.parseInt(cedula));
            rs = pst.executeQuery();
            while (rs.next()) {
                h = Historia.load(rs);
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarhistoria -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return h;
    }
    
    public Paciente consultarhistoriaIdPaciente(int idhistoria) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Paciente p = new Paciente();
        try {
            pst = conexion.prepareStatement("SELECT p.* FROM historia h, paciente p WHERE p.idpaciente=h.idpaciente AND h.idhistoria=?");
            pst.setInt(1, idhistoria);
            rs = pst.executeQuery();
            while (rs.next()) {
                p = Paciente.load(rs);
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarhistoriaIdPaciente -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return p;
    }

    public List consultarhistorias(String cedula) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lhistorias = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT h.* FROM historia h, paciente p WHERE p.idpaciente=h.idpaciente AND p.numeroDoc=?");
            pst.setInt(1, Integer.parseInt(cedula));
            rs = pst.executeQuery();
            while (rs.next()) {
                lhistorias.add(Historia.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarhistoria -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lhistorias;
    }

    public Historia consultarhistoria(int nroorden) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Historia h = new Historia();
        try {
            pst = conexion.prepareStatement("SELECT h.* FROM historia h, paciente p WHERE p.idpaciente=h.idpaciente AND h.idhistoria=?");
            pst.setInt(1, nroorden);
            rs = pst.executeQuery();
            while (rs.next()) {
                h = Historia.load(rs);
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarhistoria -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return h;
    }

    public List consultarHistoriaNombre(String NOMBRE) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lhistorias = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT h.* FROM historia h, paciente p WHERE p.idpaciente=h.idpaciente AND p.nombre LIKE ?");
            NOMBRE = NOMBRE + "%";
            pst.setString(1, NOMBRE);
            rs = pst.executeQuery();
            while (rs.next()) {
                lhistorias.add(Historia.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarHistoriaNombre -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lhistorias;
    }
    
    public List consultarHistoriaNombre() throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lhistorias = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT h.* FROM historia h, paciente p WHERE p.idpaciente=h.idpaciente");
            rs = pst.executeQuery();
            while (rs.next()) {
                lhistorias.add(Historia.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarHistoriaNombre -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lhistorias;
    }

    public List consultarHistoriaApellido(String NOMBRE) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lhistorias = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT h.* FROM historia h, paciente p WHERE p.idpaciente=h.idpaciente AND p.apellido LIKE ?");
            NOMBRE = NOMBRE + "%";
            pst.setString(1, NOMBRE);
            rs = pst.executeQuery();
            while (rs.next()) {
                lhistorias.add(Historia.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarHistoriaApellido -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lhistorias;
    }

    public List listarTodosHistoria() throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lhistorias = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT h.* FROM historia h, paciente p WHERE p.idpaciente=h.idpaciente");
            rs = pst.executeQuery();
            while (rs.next()) {
                lhistorias.add(Historia.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - listarTodosHistoria -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lhistorias;
    }
    
    public boolean existeHistoria(int cedula) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("SELECT COUNT(*) FROM historia h, paciente p WHERE h.idpaciente = p.idpaciente AND p.numeroDoc=?");
            pst.setInt(1, cedula);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - existeHistoria -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return true;
    }

    public void modificarHistoria(Historia h) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("UPDATE historia SET observacion=?, diagnostico=?, tratamiento=?, alergias=?, antecedentes=?, habitos=?  WHERE idhistoria=?");
            pst.setString(1, h.getObservacion());
            pst.setString(2, h.getDiagnostico());
            pst.setString(3, h.getTratamiento());
            pst.setString(4, h.getAlergias());
            pst.setString(5, h.getAntecedentes());
            pst.setString(6, h.getHabitos());
            pst.setInt(7, h.getIdhistoria());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error Method - modificarHistoria -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }
    
    // ENFERMEDAD
    public void guardarEnfermedad(Enfermedad e) throws IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("INSERT INTO enfermedad VALUES (?,?,?,?)");
            pst.setInt(1, e.getIdenfermedad());
            pst.setString(2, e.getNombre());
            pst.setDate(3, new java.sql.Date(e.getFecha().getTime()));
            pst.setString(4, e.getObservacion());
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Error Method - guardarEnfermedad -- " + ex.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }

    public Enfermedad consultarEnfermedadId(int idenfermedad) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Enfermedad e = new Enfermedad();
        try {
            pst = conexion.prepareStatement("SELECT * FROM enfermedad WHERE idenfermedad=?");
            pst.setInt(1, idenfermedad);
            rs = pst.executeQuery();
            while (rs.next()) {
                e = Enfermedad.load(rs);
            }
        } catch (SQLException ex) {
            throw new SQLException("Error Method - consultarEnfermedadId -- " + ex.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return e;
    }

    public boolean consultarEnfermedad(String nombre) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("SELECT COUNT(*) FROM enfermedad WHERE nombre=?");
            pst.setString(1, nombre);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarEnfermedad -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return true;
    }

    public List consultarEnfermedadNombre(String NOMBRE) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lenfermedad = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM enfermedad WHERE nombre LIKE ?");
            NOMBRE = NOMBRE + "%";
            pst.setString(1, NOMBRE);
            rs = pst.executeQuery();
            while (rs.next()) {
                lenfermedad.add(Enfermedad.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarEnfermedadNombre -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lenfermedad;
    }
    
    public List consultarTodosEnfermedad() throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lenfermedad = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM enfermedad");
            rs = pst.executeQuery();
            while (rs.next()) {
                lenfermedad.add(Enfermedad.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarEnfermedadNombre -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lenfermedad;
    }

    public void modificarEnfermedad(Enfermedad e) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("UPDATE enfermedad SET nombre=?, observacion=? WHERE idenfermedad=?");
            pst.setString(1, e.getNombre());
            pst.setString(2, e.getObservacion());
            pst.setInt(3, e.getIdenfermedad());
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Error Method - modificarEnfermedad -- " + ex.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }
    
    // MEDICAMENTO
    public void guardarMedicamento(Medicamento m) throws IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("INSERT INTO medicamento VALUES (?,?,?,?)");
            pst.setInt(1, m.getIdmedicamento() );
            pst.setString(2, m.getNombre());
            pst.setDate(3, new java.sql.Date(m.getFecha().getTime()));
            pst.setString(4, m.getObservacion());
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Error Method - guardarMedicamento -- " + ex.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }

    public Medicamento consultarMedicamentoId(int idmedicamento) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Medicamento m = new Medicamento();
        try {
            pst = conexion.prepareStatement("SELECT * FROM medicamento WHERE idmedicamento=?");
            pst.setInt(1, idmedicamento);
            rs = pst.executeQuery();
            while (rs.next()) {
                m = Medicamento.load(rs);
            }
        } catch (SQLException ex) {
            throw new SQLException("Error Method - consultarMedicamentoId -- " + ex.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return m;
    }

    public boolean consultarMedicamento(String nombre) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("SELECT COUNT(*) FROM medicamento WHERE nombre=?");
            pst.setString(1, nombre);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarMedicamento -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return true;
    }

    public List consultarMedicamentoNombre(String NOMBRE) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lenfermedad = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM medicamento WHERE nombre LIKE ?");
            NOMBRE = NOMBRE + "%";
            pst.setString(1, NOMBRE);
            rs = pst.executeQuery();
            while (rs.next()) {
                lenfermedad.add(Medicamento.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarMedicamentoNombre -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lenfermedad;
    }
    
    public List consultarTodosMedicamento() throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lenfermedad = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM medicamento");
            rs = pst.executeQuery();
            while (rs.next()) {
                lenfermedad.add(Medicamento.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarTodosMedicamento -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lenfermedad;
    }

    public void modificarMedicamento(Medicamento m) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("UPDATE medicamento SET nombre=?, observacion=? WHERE idmedicamento=?");
            pst.setString(1, m.getNombre());
            pst.setString(2, m.getObservacion());
            pst.setInt(3, m.getIdmedicamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Error Method - modificarMedicamento -- " + ex.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }
    
    // CIRUGIA
    public void guardarCirugia(Cirugia c) throws IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("INSERT INTO cirugia VALUES (?,?,?,?,?)");
            pst.setInt(1, c.getIdcirugia() );
            pst.setInt(2, c.getIdmedico() );
            pst.setInt(3, c.getIdhistoria() );
            pst.setString(4, c.getObservacion());
            pst.setDate(5, new java.sql.Date(c.getFecha().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Error Method - guardarCirugia -- " + ex.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }

    public Cirugia consultarCirugiaId(int idcirugia) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Cirugia c = new Cirugia();
        try {
            pst = conexion.prepareStatement("SELECT * FROM cirugia WHERE idcirugia=?");
            pst.setInt(1, idcirugia);
            rs = pst.executeQuery();
            while (rs.next()) {
                c = Cirugia.load(rs);
            }
        } catch (SQLException ex) {
            throw new SQLException("Error Method - consultarCirugiaId -- " + ex.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return c;
    }

    public List consultarCirugiaNombrePaciente(String NOMBRE) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lcirugia = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT c.* FROM cirugia c, historia h, paciente p WHERE c.idhistoria=h.idhistoria AND h.idpaciente=p.idpaciente AND p.nombre LIKE ?");
            NOMBRE = NOMBRE + "%";
            pst.setString(1, NOMBRE);
            rs = pst.executeQuery();
            while (rs.next()) {
                lcirugia.add(Cirugia.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarCirugiaNombrePaciente -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lcirugia;
    }
    
    public List consultarTodosCirugia() throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lcirugia = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM cirugia");
            rs = pst.executeQuery();
            while (rs.next()) {
                lcirugia.add(Cirugia.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarTodosCirugia -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lcirugia;
    }

    public void modificarCirugia(Cirugia c) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("UPDATE cirugia SET idmedico=?, observacion=?, fecha=? WHERE idcirugia=?");
            pst.setInt(1, c.getIdmedico());
            pst.setString(2, c.getObservacion());
            pst.setDate(3, new java.sql.Date(c.getFecha().getTime() ));
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Error Method - modificarCirugia -- " + ex.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }
    
    // INCAPACIDAD
    public void guardarIncapacidad(Incapacidad i) throws IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("INSERT INTO incapacidad VALUES (?,?,?,?,?,?)");
            pst.setInt(1, i.getIdincapacidad() );
            pst.setInt(2, i.getIdpaciente() );
            pst.setInt(3, i.getIdmedico() );
            pst.setInt(4, i.getDias() );
            pst.setString(5, i.getObs());
            pst.setDate(6, new java.sql.Date(i.getFecha().getTime()));
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Error Method - guardarIncapacidad -- " + ex.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }

    public Incapacidad consultarIncapacidadId(int idmedicamento) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Incapacidad i = new Incapacidad();
        try {
            pst = conexion.prepareStatement("SELECT * FROM incapacidad i, paciente p WHERE p.idpaciente=I.idpaciente AND i.idincapacidad=?");
            pst.setInt(1, idmedicamento);
            rs = pst.executeQuery();
            while (rs.next()) {
                i = Incapacidad.load(rs);
            }
        } catch (SQLException ex) {
            throw new SQLException("Error Method - consultarIncapacidadId -- " + ex.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return i;
    }

    public boolean consultarIncapacidad(String nombre) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("SELECT COUNT(*) FROM incapacidad i, paciente p WHERE p.idpaciente=I.idpaciente AND P.nombre=?");
            pst.setString(1, nombre);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarIncapacidad -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return true;
    }

    public List consultarIncapacidadNombre(String NOMBRE) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lenfermedad = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT i.* FROM incapacidad i, paciente p WHERE p.idpaciente=I.idpaciente AND P.nombre LIKE ?");
            NOMBRE = NOMBRE + "%";
            pst.setString(1, NOMBRE);
            rs = pst.executeQuery();
            while (rs.next()) {
                lenfermedad.add(Incapacidad.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarIncapacidadNombre -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lenfermedad;
    }
    
    public List consultarTodosIncapdidad() throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lenfermedad = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT i.* FROM incapacidad i , paciente p WHERE p.idpaciente=I.idpaciente");
            rs = pst.executeQuery();
            while (rs.next()) {
                lenfermedad.add(Incapacidad.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarTodosIncapdidad -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lenfermedad;
    }

    public void modificarIncapacidad(Incapacidad i) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("UPDATE incapacidad SET idmedico=?, dias=?, observacion=? WHERE idincapacidad=?");
            pst.setInt(1, i.getIdmedico());
            pst.setInt(2, i.getDias());
            pst.setString(3, i.getObs());
            pst.setInt(4, i.getIdincapacidad());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Error Method - modificarIncapacidad -- " + ex.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }
    
    // HISTORIA MEDICAMENTO
    public void guardarHistoriaMed(HistoriaMed hm) throws IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("INSERT INTO historiamed VALUES (?,?,?)");
            pst.setInt(1, hm.getIdhistoriaMed() );
            pst.setInt(2, hm.getIdmedicamento() );
            pst.setInt(3, hm.getIdhistoria() );
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Error Method - guardarHistoriaMed -- " + ex.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }
    
    // HISTORIA ENFERMEDAD
    public void guardarHistoriaEnf(HistoriaEnf he) throws IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("INSERT INTO historiaenf VALUES (?,?,?)");
            pst.setInt(1, he.getIdhistoriaMed() );
            pst.setInt(2, he.getIdenfermedad() );
            pst.setInt(3, he.getIdhistoria() );
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Error Method - guardarHistoriaEnf -- " + ex.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }
    
    public List consultarHistoriaEnf(int idhistoria) throws IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lenfermedad = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM historiaenf WHERE idhistoria=?");
            pst.setInt(1, idhistoria );
            rs = pst.executeQuery();
             while (rs.next()) {
                lenfermedad.add(HistoriaEnf.load(rs));
            }           

        } catch (SQLException ex) {
            throw new SQLException("Error Method - consultarHistoriaEnf -- " + ex.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
        return lenfermedad;
    }
    
    public List consultarHistoriaMed(int idhistoria) throws IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lmedicamentos = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM historiamed WHERE idhistoria=?");
            pst.setInt(1, idhistoria );
            rs = pst.executeQuery();
             while (rs.next()) {
                lmedicamentos.add(HistoriaMed.load(rs));
            }           

        } catch (SQLException ex) {
            throw new SQLException("Error Method - consultarHistoriaMed -- " + ex.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
        return lmedicamentos;
    }

}
