package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ClienteDAO;
import modelo.ClienteDTO;
import modelo.ProductoDAO;
import modelo.ProductoDTO;
import modelo.UsuarioDAO;
import modelo.UsuarioDTO;

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

		if (request.getParameter("consultarUsu") != null) {

			int cedula, cedula_cli;
			cedula = Integer.parseInt(request.getParameter("cedula"));
			cedula_cli = Integer.parseInt(request.getParameter("cedula_cli"));
			UsuarioDTO usu = usuDAO.BuscarUsuario(cedula);
			ClienteDTO cli = cliDAO.BuscarCliente(cedula_cli);
			if (usu != null && cli != null) {

				cedula = usu.getCedula_usuario();
				cedula_cli = cli.getCedula_cliente();
				response.sendRedirect(
						"Ventas.jsp?cedula=" + cedula + "&&correo=" + cedula + "&&cedula_cli=" + cedula_cli);

			} else {
				response.sendRedirect("MenuPrincipal.jsp?men=El Usuario no existe");
			}
		}

		if (request.getParameter("consultarPro") != null) {

			int cod_producto, valor_total, cantidad;
			String nombre_producto;
			cod_producto = Integer.parseInt(request.getParameter("cod_pro1"));
			cantidad = Integer.parseInt(request.getParameter("cantidad"));
			valor_total = Integer.parseInt(request.getParameter("valor_total"));

			ProductoDTO pro = proDAO.BuscarProducto(cod_producto);
			ProductoDTO pro1 = proDAO.SubtotalProducto(cantidad, cod_producto);
			if (pro != null && pro1 != null) {

				cod_producto = pro.getCodigo_producto();
				nombre_producto = pro.getNombre_producto();
				valor_total = (int) pro1.getSubtotal();

				response.sendRedirect("Ventas.jsp?cod_producto=" + cod_producto + "&&nombre_producto=" + nombre_producto
						+ "&&valor_total=" + valor_total);
				System.out.println(cod_producto+""+valor_total);

			} else {
				response.sendRedirect("MenuPrincipal.jsp?men=El Usuario no existe");
			}
		}

	}

}
