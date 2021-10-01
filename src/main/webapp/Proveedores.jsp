<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proveedores</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
</head>
<body>


	<%!String mensaje = "";
	String ciudad_proveedor = "", direccion_proveedor = "", nombre_proveedor = "", telefono_proveedor = "", estado = "";
	int nit_proveedor = 0;%>
	<%
	if (request.getParameter("nit_proveedor") != null) {

		nit_proveedor = Integer.parseInt(request.getParameter("nit_proveedor"));
		ciudad_proveedor = request.getParameter("ciudad_proveedor");
		direccion_proveedor = request.getParameter("direccion_proveedor");
		nombre_proveedor = request.getParameter("nombre_proveedor");
		telefono_proveedor = request.getParameter("telefono_proveedor");
		estado = "disabled";
	}
	%>
	<%
	if (request.getParameter("men") != null) {
		nit_proveedor = 0;
		ciudad_proveedor = "";
		direccion_proveedor = "";
		nombre_proveedor = "";
		telefono_proveedor = "";
		mensaje = request.getParameter("men");
		out.print("<script>alert('" + mensaje + "');</script>");//mensaje alert javascript
	}
	%>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">

		<a class="navbar-brand" href="MenuPrincipal.jsp"><img
			src="img/logo-mision.png" alt="" width="30" height="24"
			class="d-inline-block align-text-top"> Tienda Generica</a>

	</nav>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">

		<div class="container-fluid">

			<a class="navbar-brand" href="MenuPrincipal.jsp">Menu Principal</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-link " aria-current="page" href="Usuarios.jsp">Usuarios</a>
					<a class="nav-link" href="Clientes.jsp">Clientes</a> <a
						class="nav-link active" href="Proveedores.jsp">Proveedores</a><a
						class="nav-link" href="Productos.jsp">Productos</a><a
						class="nav-link" href="Ventas.jsp">Ventas</a><a class="nav-link"
						href="Reportes.jsp">Reportes</a>
				</div>
			</div>
		</div>
	</nav>


	<div>

		<section class="form-gene">

			<h4>Modulo Proveedores</h4>
			<form action="Proveedor" method="post">

				<div>
					<label class="subtitulos">Nit Proveedor: </label> <input
						class="control" type="text" name="nit" value="<%=nit_proveedor%>"
						placeholder="Nit Proveedor" required <%=estado%>> <input
						type="hidden" name="ced" value="<%=nit_proveedor%>">
				</div>


				<div>

					<label class="subtitulos">Ciudad Proveedor: </label> <input
						class="control" type="text" name="ciudad_proveedor"
						placeholder="Ciudad Proveedor" value="<%=ciudad_proveedor%>">

				</div>
				<div>
					<label class="subtitulos">Direccion Proveedor: </label> <input
						class="control" type="text" name="direccion_proveedor"
						placeholder="Direccion proveedor" value="<%=direccion_proveedor%>">
				</div>

				<div>
					<label class="subtitulos">Nombre Proveedor: </label> <input
						class="control" type="text" name="nombre_proveedor"
						placeholder="Nombre Proveedor" value="<%=nombre_proveedor%>">
				</div>

				<div>
					<label class="subtitulos">Telefono Proveedor: </label> <input
						class="control" type="text" name="telefono_proveedor"
						placeholder="Telefono Proveedor" value="<%=telefono_proveedor%>">

				</div>

				<div class="boton-cent">

					<div>
						<input class="boton" type="submit" value="Consultar"
							name="consultar_pro">
					</div>
					<div>
						<input class="boton" type="submit" value="Crear" name="crear_pro">
					</div>
					<div>
						<input class="boton" type="submit" value="Actualizar"
							name="actualizar_pro">
					</div>
					<div>
						<input class="boton" type="submit" value="Borrar" name="borrar_pro">
					</div>

				</div>



			</form>
		</section>

	</div>




</body>
</html>