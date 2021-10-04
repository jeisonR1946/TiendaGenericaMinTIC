package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import modelo.ProductoDAO;
import modelo.ProductoDTO;

/**
 * Servlet implementation class Producto
 */
@WebServlet("/Producto")
@MultipartConfig
public class Producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Producto() {
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
	
		
		ProductoDAO prodDAO =  new ProductoDAO();
		
		if (request.getParameter("cargar") != null) {
			Part archivo = request.getPart("archivo");
			String nombre = request.getParameter("nombreArchivo");
			String Url ="C:/Doc/";
			//String Url = "C:/Users/jeiso/eclipse-workspace/Prestamos_31/src/main/webapp/Doc/";
			// JOptionPane.showMessageDialog(null, archivo.getSubmittedFileName());
			//String Url = "C:/Users/jeiso/eclipse-workspace/Prestamos_31/src/main/webapp/Doc/";
		//	String Url = "C:\\Users\\jeiso\\eclipse-workspace\\Prestamos_31\\src\\main\\webapp\\Doc\\";
		//	String Url = "C://Users//jeiso//eclipse-workspace//Prestamos_31//src//main//webapp//Doc//";
			// JOptionPane.showMessageDialog(null, Url);
			if(archivo.getContentType().equals("application/vnd.ms-excel")) {
				
				try {
					InputStream file = archivo.getInputStream();
					File copia = new File(Url + nombre + ".csv");
					FileOutputStream escribir = new FileOutputStream(copia);
					int num = file.read();
					while (num != -1) {
						escribir.write(num);
						num = file.read();
					}
					escribir.close();
					file.close();
					JOptionPane.showMessageDialog(null, "Archivo Cargado Correctamente");
					if (prodDAO.CargarProductos(Url + nombre + ".csv")) {
						
						response.sendRedirect("MenuPrincipal.jsp?men=Productos Registrado Correctamente");
					} else {

						response.sendRedirect("MenuPrincipal.jsp?men=Los Productos no se Registraron");
					}
				} catch (Exception e) {
					response.sendRedirect("MenuPrincipal.jsp?men=Error al cargar Archivo" + e);
					
				}
			} else {
				
				response.sendRedirect("MenuPrincipal.jsp?men=FORMATO NO VALIDO" );
				
			}
		
		}
	
	
		
		
	}

}
