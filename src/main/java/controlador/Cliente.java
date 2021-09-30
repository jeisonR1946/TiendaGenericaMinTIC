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
import modelo.UsuarioDTO;

/**
 * Servlet implementation class Cliente
 */
@WebServlet("/Cliente")
public class Cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cliente() {
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

		ClienteDAO cliDAO = new ClienteDAO();

		if (request.getParameter("crear_cli") != null) {

			String direccion_cliente, correo_cliente, nombre_cliente, telefono_cliente;
			int cedula_cli;
			cedula_cli = Integer.parseInt(request.getParameter("cedula_cli"));
			direccion_cliente = request.getParameter("direccion_cliente");
			correo_cliente = request.getParameter("correo_cliente");
			nombre_cliente = request.getParameter("nombre_cliente");
			telefono_cliente = request.getParameter("telefono_cliente");

			ClienteDTO cliDTO = new ClienteDTO(cedula_cli, direccion_cliente, correo_cliente, nombre_cliente,
					telefono_cliente);
			if (cliDAO.BuscarCliente(cedula_cli) == null) {

				if (cliDAO.InsertarCliente(cliDTO)) {
					response.sendRedirect(
							"MenuPrincipal.jsp?men=El Cliente: " + nombre_cliente + " fue registrado Exitosamente.");
				}

			} else {
				response.sendRedirect("MenuPrincipal.jsp?men=El Cliente ya existe");
			}

		}

		if (request.getParameter("consultar_cli") != null) {

			String direccion_cliente, correo_cliente, nombre_cliente, telefono_cliente;
			int cedula_cli;
			cedula_cli = Integer.parseInt(request.getParameter("cedula_cli"));
			ClienteDTO cli = cliDAO.BuscarCliente(cedula_cli);
			if (cli != null) {

				cedula_cli = cli.getCedula_cliente();
				direccion_cliente = cli.getDireccion_cliente();
				correo_cliente = cli.getEmail_cliente();
				nombre_cliente = cli.getNombre_cliente();
				telefono_cliente = cli.getTelefono_cliente();
				response.sendRedirect("Clientes.jsp?cedula_cli=" + cedula_cli + "&&direccion_cliente="
						+ direccion_cliente + "&&correo_cliente=" + correo_cliente + "&&nombre_cliente="
						+ nombre_cliente + "&&telefono_cliente=" + telefono_cliente);

			} else {
				response.sendRedirect("MenuPrincipal.jsp?men=El Usuario no existe");
			}
		}

		if (request.getParameter("borrar_cli") != null) {

			int cedula_cli;
			cedula_cli = Integer.parseInt(request.getParameter("ced_cli"));
			int op = JOptionPane.showConfirmDialog(null, "Desea Eliminar el usuario: " + cedula_cli);
			if (op == 0) {
				if (cliDAO.EliminarCliente(cedula_cli)) {
					response.sendRedirect("MenuPrincipal.jsp?men=Cliente Eliminado");

				} else {
					response.sendRedirect("MenuPrincipal.jsp?men=Cliente no eliminado");
				}
			} else {
				response.sendRedirect("MenuPrincipal.jsp");
			}

		}

		if (request.getParameter("actualizar_cli") != null) {

			String direccion_cliente, correo_cliente, nombre_cliente, telefono_cliente;
			int cedula_cli;
			cedula_cli = Integer.parseInt(request.getParameter("ced_cli"));
			direccion_cliente = request.getParameter("direccion_cliente");
			correo_cliente = request.getParameter("correo_cliente");
			nombre_cliente = request.getParameter("nombre_cliente");
			telefono_cliente = request.getParameter("telefono_cliente");
			ClienteDTO cliDTO_Act = new ClienteDTO(cedula_cli, direccion_cliente, correo_cliente, nombre_cliente, telefono_cliente);		

			if (cliDAO.ActualizarCliente(cliDTO_Act)) {

				response.sendRedirect("MenuPrincipal.jsp?men=Libro Actualizado Exitosamente.");
			} else {

				response.sendRedirect("MenuPrincipal.jsp?men=El libro no fue  actualizado.");
			}

		}

	}

}
