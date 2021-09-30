package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.UsuarioDAO;
import modelo.UsuarioDTO;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		if (request.getParameter("consultar") != null) {

			String nombre, correo,usuario,contrasena;
			int cedula;
			cedula = Integer.parseInt(request.getParameter("cedula"));
			UsuarioDTO usu = usuDAO.BuscarUsuario(cedula);
			if(usu !=null) {
				
				cedula = usu.getCedula_usuario();
				nombre = usu.getNombre_usuario();
				correo = usu.getEmail_usuario();
				usuario = usu.getUsuario();
				contrasena = usu.getPass();
				response.sendRedirect("Usuarios.jsp?cedula=" + cedula + "&&nombre=" + nombre + "&&correo=" + correo
						+ "&&usuario=" + usuario + "&&contrasena=" + contrasena);
			
			} else {
				response.sendRedirect("Usuarios.jsp?men=El Usuario no existe");
			}
	
		

		}
		
		
	}

}
