package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import controlador.Conexion;

public class UsuarioDAO {

	Conexion cnn = new Conexion();
	Connection con = cnn.ConectarBase();
	PreparedStatement ps = null;
	ResultSet res = null;

	public UsuarioDTO BuscarUsuario(int cedula_usuario) {

		UsuarioDTO usuDTO = null;

		try {

			String sql = "select * from usuarios where cedula_usuario=?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, cedula_usuario);
			res = ps.executeQuery();
			while (res.next()) {
				usuDTO = new UsuarioDTO(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),
						res.getString(5));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al consultar" + e);
		}
		return usuDTO;

	}
	
	public boolean InsertarUsuario(UsuarioDTO usuDTO) {
		boolean resul = false;
		try {
			String sql = "insert into usuarios values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, usuDTO.getCedula_usuario());
			ps.setString(2, usuDTO.getNombre_usuario());
			ps.setString(3, usuDTO.getEmail_usuario());
			ps.setString(4, usuDTO.getPass());
			ps.setString(5, usuDTO.getUsuario());
			resul = ps.executeUpdate() > 0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al insertar: " + ex);
		}
		return resul;
	}
	
	public boolean EliminarUsuario(int cedula) {
		boolean resul = false;
		try {
			String sql = "delete from usuarios where cedula_usuario=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cedula);
			resul = ps.executeUpdate() > 0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al eliminar el usuario: " + ex);
		}
		return resul;
	}
	
	public boolean ActualizarUsuario(UsuarioDTO usuDTO) {
		boolean resul = false;
		try {
			String sql = "update usuarios set titulo=?, editorial=?, autor=?, No_paginas=? where isbn=?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, usuDTO.getNombre_usuario());
			ps.setString(2, usuDTO.getEmail_usuario());
			ps.setString(3, usuDTO.getPass());
			ps.setString(4, usuDTO.getUsuario());
			ps.setInt(5, usuDTO.getCedula_usuario());
			resul = ps.executeUpdate() > 0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al actualizar: " + ex);
		}
		return resul;
	}

}
