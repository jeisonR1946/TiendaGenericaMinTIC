package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import controlador.Conexion;


public class VentaDAO {

	Conexion cnn = new Conexion();
	Connection con = cnn.ConectarBase();
	PreparedStatement ps = null;
	ResultSet res = null;
	
	public boolean InstertarVenta(VentaDTO v, ProductoDTO p) {
		
		boolean resul = false;
		
		try {
			
			String sql ="INSERT INTO `tienda_generica`.`venta` \r\n"
					+ " (`cedula_cliente`, `cedula_usuario`, `iva_venta`, `total_venta`, `valor_venta`)\r\n"
					+ " VALUES ((select cedula_cliente from tienda_generica.clientes where cedula_cliente=?), \r\n"
					+ " (select cedula_usuario from tienda_generica.usuarios where cedula_usuario=?),\r\n"
					+ " (select sum(iva_compra*?) as iva from tienda_generica.productos where codigo_producto=?), \r\n"
					+ " (select sum(precio_venta*?) as subtota from tienda_generica.productos where codigo_producto=?), \r\n"
					+ " ( (select sum(iva_compra*?) as iva from tienda_generica.productos where codigo_producto=?)+\r\n"
					+ " (select sum(precio_venta*?) as subtota from tienda_generica.productos where codigo_producto=?)))";
			
			ps= con.prepareStatement(sql);
			ps.setInt(1, v.getCedula_cliente());
			ps.setInt(2, v.getCedula_usuario());
			ps.setInt(3, p.getCantidad());
			ps.setInt(4, p.getCodigo_producto());
			ps.setInt(5, p.getCantidad());
			ps.setInt(6, p.getCodigo_producto());
			ps.setInt(7, p.getCantidad());
			ps.setInt(8, p.getCodigo_producto());
			ps.setInt(9, p.getCantidad());
			ps.setInt(10, p.getCodigo_producto());
		
			resul = ps.executeUpdate() > 0;
			
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al crear" + e);
		}
		
		return resul;		
		
	}

}
