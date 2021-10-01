package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ProveedorDAO;
import modelo.ProveedorDTO;
import modelo.UsuarioDTO;

/**
 * Servlet implementation class Proveedor
 */
@WebServlet("/Proveedor")
public class Proveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Proveedor() {
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

		ProveedorDAO proDAO = new ProveedorDAO();

		if (request.getParameter("consultar_pro") != null) {

			String ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor;
			int nit_proveedor;
			nit_proveedor = Integer.parseInt(request.getParameter("nit_proveedor"));
			ProveedorDTO pro = proDAO.BuscarProveedor(nit_proveedor);

			if (pro != null) {

				nit_proveedor = pro.getNit_proveedor();
				ciudad_proveedor = pro.getCiudad_proveedor();
				direccion_proveedor = pro.getDireccion_proveedor();
				nombre_proveedor = pro.getNombre_proveedor();
				telefono_proveedor = pro.getTelefono_proveedor();
				response.sendRedirect("Proveedor.jsp?nit_proveedor=" + nit_proveedor + "&&ciudad_proveedor="
						+ ciudad_proveedor + "&&direccion_proveedor=" + direccion_proveedor + "&&nombre_proveedor="
						+ nombre_proveedor + "&&telefono_proveedor=" + telefono_proveedor);

			} else {
				response.sendRedirect("MenuPrincipal.jsp?men=El Usuario no existe");
			}
		}

		if (request.getParameter("crear_pro") != null) {

			String ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor;
			int nit_proveedor;
			nit_proveedor = Integer.parseInt(request.getParameter("nit_proveedor"));
			ciudad_proveedor = request.getParameter("ciudad_proveedor");
			direccion_proveedor = request.getParameter("direccion_proveedor");
			nombre_proveedor = request.getParameter("nombre_proveedor");
			telefono_proveedor = request.getParameter("telefono_proveedor");
			ProveedorDTO proDTO = new ProveedorDTO(nit_proveedor, ciudad_proveedor, direccion_proveedor,
					nombre_proveedor, telefono_proveedor);
			if (proDAO.BuscarProveedor(nit_proveedor) == null) {

				if (proDAO.InsertarProveedor(proDTO)) {
					response.sendRedirect("MenuPrincipal.jsp?men=El Proveedor: " + nombre_proveedor
							+ " fue registrado Exitosamente.");
				}

			} else {
				response.sendRedirect("MenuPrincipal.jsp?men=El proveedor ya existe");
			}

		}

		if (request.getParameter("borrar_pro") != null) {

			int nit_proveedor;
			nit_proveedor = Integer.parseInt(request.getParameter("nit"));
			int op = JOptionPane.showConfirmDialog(null, "Desea Eliminar el proveedor: " + nit_proveedor);
			if (op == 0) {
				if (proDAO.EliminarProveedor(nit_proveedor)) {
					response.sendRedirect("MenuPrincipal.jsp?men=Proveedor Eliminado");

				} else {
					response.sendRedirect("MenuPrincipal.jsp?men=Proveedor no se elimino");
				}
			} else {
				response.sendRedirect("MenuPrincipal.jsp");
			}

		}

		if (request.getParameter("actualizar_pro") != null) {

			String ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor;
			int nit_proveedor;
			nit_proveedor = Integer.parseInt(request.getParameter("nit_proveedor"));
			ciudad_proveedor = request.getParameter("ciudad_proveedor");
			direccion_proveedor = request.getParameter("direccion_proveedor");
			nombre_proveedor = request.getParameter("nombre_proveedor");
			telefono_proveedor = request.getParameter("telefono_proveedor");

			ProveedorDTO proDTO_Act = new ProveedorDTO(nit_proveedor, ciudad_proveedor, direccion_proveedor,
					nombre_proveedor, telefono_proveedor);

			if (proDAO.ActualizarProveedor(proDTO_Act)) {

				response.sendRedirect("MenuPrincipal.jsp?men=Proveedor Actualizado Exitosamente.");
			} else {

				response.sendRedirect("MenuPrincipal.jsp?men=El proveeodr no fue  actualizado.");
			}

		}

	}

}
