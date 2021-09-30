package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class ClienteDAO {
	
	
	Conexion cnn = new Conexion();
	Connection con = cnn.ConectarBase();
	PreparedStatement ps = null;
	ResultSet res = null;
	
	
	public ClienteDTO BuscarCliente(int cedula_cli) {

		ClienteDTO cliDTO = null;

		try {

			String sql = "select * from clientes where cedula_cliente=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cedula_cli);
			res = ps.executeQuery();
			while (res.next()) {
				cliDTO = new ClienteDTO(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),
						res.getString(5));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al consultar" + e);
		}
		return cliDTO;

	}
	
	
	public boolean InsertarCliente(ClienteDTO cliDTO) {
		boolean resul = false;
		try {
			String sql = "insert into clientes values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cliDTO.getCedula_cliente());
			ps.setString(2, cliDTO.getDireccion_cliente());
			ps.setString(3, cliDTO.getEmail_cliente());			
			ps.setString(4, cliDTO.getNombre_cliente());
			ps.setString(5, cliDTO.getTelefono_cliente());
			resul = ps.executeUpdate() > 0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al insertar: " + ex);
		}
		return resul;
	}
	
	
	public boolean EliminarCliente(int cedula_cliente) {
		boolean resul = false;
		try {
			String sql = "delete from clientes where cedula_cliente=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cedula_cliente);
			resul = ps.executeUpdate() > 0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al eliminar el cliente: " + ex);
		}
		return resul;
	}
	
	public boolean ActualizarCliente(ClienteDTO cliDTO) {
		boolean resul = false;
		try {
			String sql = "update clientes set direccion_cliente=?, email_cliente=?, nombre_cliente=?, telefono_cliente=? where cedula_cliente=?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, cliDTO.getDireccion_cliente());
			ps.setString(2, cliDTO.getEmail_cliente());			
			ps.setString(3, cliDTO.getNombre_cliente());
			ps.setString(4, cliDTO.getTelefono_cliente());
			ps.setInt(5, cliDTO.getCedula_cliente());
			resul = ps.executeUpdate() > 0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al actualizar: " + ex);
		}
		return resul;
	}

	
	
	

}
