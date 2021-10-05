package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import controlador.Conexion;

public class ProductoDAO {

	Conexion cnn = new Conexion();
	Connection con = cnn.ConectarBase();
	PreparedStatement ps = null;
	ResultSet res = null;

	public boolean CargarProductos(String url) {

		boolean result = false;
		try {

			String sql = "load data infile '" + url
					+ "' into table productos fields terminated by ',' lines terminated by '\r\n' ";
			ps = con.prepareStatement(sql);
			// ps.setString(1, url);
			result = ps.executeUpdate() > 0;

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "error al insertar Productos: " + ex);

		}

		return result;

	}

	public ArrayList<ProductoDTO> cargar_select_pro() {

		ProductoDTO pro = null;
		ArrayList<ProductoDTO> lista = new ArrayList<>();
		try {
			String sql = "select  * from productos";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			while (res.next()) {
				pro = new ProductoDTO(res.getInt(0), res.getDouble(1), res.getInt(2), res.getString(3),
						res.getDouble(4), res.getDouble(5));
				lista.add(pro);
			}
		} catch (Exception ex) {
			// TODO: handle exception
		}
		return lista;

	}

	public ProductoDTO BuscarProducto(int codigo_producto) {

		ProductoDTO proDTO = null;

		try {

			String sql = "select * from productos where codigo_producto=?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, codigo_producto);
			res = ps.executeQuery();
			while (res.next()) {

				proDTO = new ProductoDTO(res.getInt(1), res.getDouble(2), res.getInt(3), res.getString(4),
						res.getDouble(5), res.getDouble(6));

			}
			
			

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al consultar" + e);
		}
		return proDTO;
	}
	
	public ProductoDTO SubtotalProducto(int cantidad, int codigo_producto) {

		ProductoDTO proDTO = null;


		try {

			String sql = "select precio_venta,sum(precio_venta*?) as subtota from tienda_generica.productos where codigo_producto=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cantidad);
			ps.setInt(2, codigo_producto);
			System.out.println(cantidad + codigo_producto);
			res = ps.executeQuery();
			while (res.next()) {

				proDTO = new ProductoDTO(res.getInt(1), res.getDouble(2));

			}
			
			

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al consultar" + e);
		}
		return proDTO;
	}
	
	

}
