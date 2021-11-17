package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controlador.Conexion;

public class DetalleVentaDAO {

	Conexion cnn = new Conexion();
	Connection con = cnn.ConectarBase();
	PreparedStatement ps = null;
	ResultSet res = null;

	public boolean InsertarDetalle(ProductoDTO p) {

		boolean resul = false;

		try {

			String sql = "INSERT INTO `tienda_generica`.`detalle_ventas`\r\n"
					+ "(`cantidad_producto`, `codigo_producto`, `codigo_venta`, `valor_total`, `valor_renta`, `valor_iva`)\r\n"
					+ " VALUES (?, ?, '34', \r\n"
					+ " ( (select sum(iva_compra*?) as iva from tienda_generica.productos where codigo_producto=?)+\r\n"
					+ " (select sum(precio_venta*?) as subtota from tienda_generica.productos where codigo_producto=?)),\r\n"
					+ " ?, \r\n"
					+ "(select sum(iva_compra*?) as iva from tienda_generica.productos where codigo_producto=?))";

			ps = con.prepareStatement(sql);
			ps.setInt(1, p.getCantidad());
			ps.setInt(2, p.getCodigo_producto());
			ps.setInt(3, p.getCantidad());
			ps.setInt(4, p.getCodigo_producto());
			ps.setInt(5, p.getCantidad());
			ps.setInt(6, p.getCodigo_producto());
			ps.setDouble(7, p.getSubtotal());
			ps.setInt(8, p.getCantidad());
			ps.setInt(9, p.getCodigo_producto());

			resul = ps.executeUpdate() > 0;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return resul;
	}

}
