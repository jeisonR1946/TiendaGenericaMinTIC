package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import controlador.Conexion;

public class UsuarioDAO {

	Conexion cnn = new Conexion();
	Connection con = cnn.ConectarBase();
	PreparedStatement ps = null;
	ResultSet res = null;

	public UsuarioDTO BuscarUsuario(long cedula_usuario) {

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

}
