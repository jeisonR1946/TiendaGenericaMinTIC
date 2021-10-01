package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class ProveedorDAO {

	Conexion cnn = new Conexion();
	Connection con = cnn.ConectarBase();
	PreparedStatement ps = null;
	ResultSet res = null;

	public ProveedorDTO BuscarProveedor(int nit_proveedor) {

		ProveedorDTO proDTO = null;

		try {

			String sql = "select * from proveedores where nit_proveedor=?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, nit_proveedor);
			res = ps.executeQuery();
			while (res.next()) {
				proDTO = new ProveedorDTO(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),
						res.getString(5));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al consultar" + e);
		}
		return proDTO;

	}

	public boolean InsertarProveedor(ProveedorDTO proDTO) {
		boolean resul = false;
		try {
			String sql = "insert into proveedores values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, proDTO.getNit_proveedor());
			ps.setString(2, proDTO.getCiudad_proveedor());
			ps.setString(3, proDTO.getDireccion_proveedor());
			ps.setString(4, proDTO.getNombre_proveedor());
			ps.setString(5, proDTO.getTelefono_proveedor());
			resul = ps.executeUpdate() > 0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al insertar: " + ex);
		}
		return resul;
	}

	public boolean EliminarProveedor(int nit_proveedor) {
		boolean resul = false;
		try {
			String sql = "delete from proveedores where nit_proveedor=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, nit_proveedor);
			resul = ps.executeUpdate() > 0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al eliminar el proveedor: " + ex);
		}
		return resul;
	}

	public boolean ActualizarProveedor(ProveedorDTO proDTO) {
		boolean resul = false;
		try {
			String sql = "update usuarios set ciudad_proveedor=?, direccion_proveedor=?, nombre_proveedor=?, telefono_proveedor=? where nit_proveedor=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, proDTO.getCiudad_proveedor());
			ps.setString(2, proDTO.getDireccion_proveedor());
			ps.setString(3, proDTO.getNombre_proveedor());
			ps.setString(4, proDTO.getTelefono_proveedor());
			ps.setInt(5, proDTO.getNit_proveedor());
			resul = ps.executeUpdate() > 0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al actualizar: " + ex);
		}
		return resul;
	}

}
