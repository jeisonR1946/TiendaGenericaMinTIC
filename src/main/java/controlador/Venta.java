package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ClienteDAO;
import modelo.ClienteDTO;
import modelo.DetalleVentaDAO;
import modelo.DetalleVentaDTO;
import modelo.ProductoDAO;
import modelo.ProductoDTO;
import modelo.UsuarioDAO;
import modelo.UsuarioDTO;
import modelo.VentaDAO;
import modelo.VentaDTO;

/**
 * Servlet implementation class Venta
 */
@WebServlet("/Venta")
public class Venta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuarioDAO usuDAO = new UsuarioDAO();
		ClienteDAO cliDAO = new ClienteDAO();
		ProductoDAO proDAO = new ProductoDAO();
		VentaDAO vDAO = new VentaDAO();
		DetalleVentaDAO dDAO = new DetalleVentaDAO();

		if (request.getParameter("consultarUsu") != null) {

			int cedula, cedula_cli;
			cedula = Integer.parseInt(request.getParameter("cedula"));
			cedula_cli = Integer.parseInt(request.getParameter("cedula_cli"));
			UsuarioDTO usu = usuDAO.BuscarUsuario(cedula);
			ClienteDTO cli = cliDAO.BuscarCliente(cedula_cli);
			if (usu != null && cli != null) {

				cedula = usu.getCedula_usuario();
				cedula_cli = cli.getCedula_cliente();

				response.sendRedirect("Ventas.jsp?cedula=" + cedula + "&&cedula_cli=" + cedula_cli);

			} else {
				response.sendRedirect("MenuPrincipal.jsp?men=El Usuario no existe");
			}
		}

		if (request.getParameter("consultarPro") != null) {

			int cod_pro1, valor_subtotal, cantidad;
			String nombre_producto;

			cod_pro1 = Integer.parseInt(request.getParameter("cod_pro1"));
			cantidad = Integer.parseInt(request.getParameter("cantidad"));
			valor_subtotal = Integer.parseInt(request.getParameter("valor_subtotal"));

			ProductoDTO pro = proDAO.BuscarProducto(cod_pro1);
			ProductoDTO pro1 = proDAO.SubtotalProducto(cantidad, cod_pro1);
			if (pro != null && pro1 != null) {

				cod_pro1 = pro.getCodigo_producto();
				nombre_producto = pro.getNombre_producto();
				valor_subtotal = (int) pro1.getSubtotal();
				cantidad = Integer.parseInt(request.getParameter("cantidad"));

				response.sendRedirect("Ventas.jsp?cod_pro1=" + cod_pro1 + "&&nombre_producto=" + nombre_producto
						+ "&&valor_subtotal=" + valor_subtotal + "&&cantidad=" + cantidad);

				System.out.println(cod_pro1 + "  " + valor_subtotal + "   " + cantidad);

			} else {
				response.sendRedirect("MenuPrincipal.jsp?men=El Usuario no existe");
			}
		}

		if (request.getParameter("consultarPro2") != null) {

			int cod_pro12, valor_total2, cantidad2;
			String nombre_producto2;

			cod_pro12 = Integer.parseInt(request.getParameter("cod_pro12"));
			cantidad2 = Integer.parseInt(request.getParameter("cantidad2"));
			valor_total2 = Integer.parseInt(request.getParameter("valor_total2"));

			ProductoDTO pro = proDAO.BuscarProducto(cod_pro12);
			ProductoDTO pro1 = proDAO.SubtotalProducto(cantidad2, cod_pro12);
			if (pro != null && pro1 != null) {

				cod_pro12 = pro.getCodigo_producto();
				nombre_producto2 = pro.getNombre_producto();
				valor_total2 = (int) pro1.getSubtotal();
				cantidad2 = Integer.parseInt(request.getParameter("cantidad2"));

				response.sendRedirect("Ventas.jsp?cod_pro12=" + cod_pro12 + "&&nombre_producto2=" + nombre_producto2
						+ "&&valor_total2=" + valor_total2 + "&&cantidad2=" + cantidad2);

			} else {
				response.sendRedirect("MenuPrincipal.jsp?men=El Usuario no existe");
			}
		}

		if (request.getParameter("consultarPro3") != null) {

			int cod_pro13, valor_total3, cantidad3;
			String nombre_producto3;

			cod_pro13 = Integer.parseInt(request.getParameter("cod_pro13"));
			cantidad3 = Integer.parseInt(request.getParameter("cantidad3"));
			valor_total3 = Integer.parseInt(request.getParameter("valor_total3"));

			ProductoDTO pro = proDAO.BuscarProducto(cod_pro13);
			ProductoDTO pro1 = proDAO.SubtotalProducto(cantidad3, cod_pro13);
			if (pro != null && pro1 != null) {

				cod_pro13 = pro.getCodigo_producto();
				nombre_producto3 = pro.getNombre_producto();
				valor_total3 = (int) pro1.getSubtotal();
				cantidad3 = Integer.parseInt(request.getParameter("cantidad3"));

				response.sendRedirect("Ventas.jsp?cod_pro13=" + cod_pro13 + "&&nombre_producto3=" + nombre_producto3
						+ "&&valor_total3=" + valor_total3 + "&&cantidad3=" + cantidad3);

			} else {
				response.sendRedirect("MenuPrincipal.jsp?men=El Usuario no existe");
			}
		}

		if (request.getParameter("confirmar") != null) {

			int cod_pro1, cantidad, cod_pro12, cantidad2, cod_pro13, cantidad3, cedula, cedula_cli,valor_subtotal;
			cedula = Integer.parseInt(request.getParameter("ced"));
			cedula_cli = Integer.parseInt(request.getParameter("ced_cli"));
			cod_pro1 = Integer.parseInt(request.getParameter("cod_producto"));
			valor_subtotal = Integer.parseInt(request.getParameter("valor_total_hidden"));			
			cantidad = Integer.parseInt(request.getParameter("cant"));
			
			
			//ProductoDTO pro1 = proDAO.SubtotalProducto(cantidad, cod_pro1);
			//valor_total = (int) pro1.getSubtotal();
			//cantidad = Integer.parseInt(request.getParameter("cant"));
			
			
			cod_pro12 = Integer.parseInt(request.getParameter("cod_producto2"));
			cantidad2 = Integer.parseInt(request.getParameter("cant2"));
			cod_pro13 = Integer.parseInt(request.getParameter("cod_producto3"));
			cantidad3 = Integer.parseInt(request.getParameter("cant3"));	
		
			System.out.println(valor_subtotal);
			

			if (cedula != 0 && cedula_cli != 0 && cod_pro1 != 0 && cantidad != 0) {

				VentaDTO v = new VentaDTO(cedula, cedula_cli);
				ProductoDTO p = new ProductoDTO(cod_pro1, cantidad,valor_subtotal);
				vDAO.InstertarVenta(v, p);
				dDAO.InsertarDetalle(p);

				/*if (vDAO.InstertarVenta(v, p)) {
				//	JOptionPane.showConfirmDialog(null, "ingreso 1 exitoso");
					//response.sendRedirect("Ventas.jsp?men=Venta exitosa ");
				} else {
					//response.sendRedirect("Ventas.jsp?men=No se registro la venta ");
				}*/
				
				

			}
			
			if (cedula != 0 && cedula_cli != 0 && cod_pro12 != 0 && cantidad2 != 0) {

				VentaDTO v = new VentaDTO(cedula, cedula_cli);
				ProductoDTO p = new ProductoDTO(cod_pro12, cantidad2);
				vDAO.InstertarVenta(v, p);	

			}
			

		

			if (cedula != 0 && cedula_cli != 0 && cod_pro13 != 0 && cantidad3 != 0) {

				VentaDTO v = new VentaDTO(cedula, cedula_cli);
				ProductoDTO p = new ProductoDTO(cod_pro13, cantidad3);
				vDAO.InstertarVenta(v, p);	

			}
			
			
			
			response.sendRedirect("MenuPrincipal.jsp?men=Ventas creadas");
			
			

		}

	}

}
