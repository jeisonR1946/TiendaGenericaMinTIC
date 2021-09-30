<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<%!String mensaje = "";
	String nombre = "", correo = "", usuario = "", contrasena = "", estado = "";
	int cedula = 0;%>
	<%
	if (request.getParameter("cedula") != null) {

		cedula = Integer.parseInt(request.getParameter("cedula"));
		nombre = request.getParameter("nombre");
		correo = request.getParameter("correo");
		usuario = request.getParameter("usuario");
		contrasena = request.getParameter("contrasena");
		estado = "disabled";
	}
	%>
	<%
	if (request.getParameter("men") != null) {
		cedula = 0;
		nombre = "";
		correo = "";
		usuario = "";
		contrasena = "";
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
					<a class="nav-link active" aria-current="page" href="Usuarios.jsp">Usuarios</a>
					<a class="nav-link" href="Clientes.jsp">Clientes</a> <a
						class="nav-link" href="Proveedores.jsp">Proveedores</a><a
						class="nav-link" href="Productos.jsp">Productos</a><a
						class="nav-link" href="Ventas.jsp">Ventas</a><a class="nav-link"
						href="Reportes.jsp">Reportes</a>
				</div>
			</div>
		</div>
	</nav>




	<div>

		<section class="form-gene">

			<h4>Modulo Usuario</h4>
			<form action="Usuario" method="post">

				<div>
					<input class="control" type="text" name="cedula" value="<%=cedula%>"
						placeholder="cedula" required <%=estado%> >
					<input type="hidden" name="cod" value="<%=cedula%>">
				</div>
				<div>
					<input class="control" type="text" name="nombre"
						placeholder="nombre" value="<%=nombre%>">
				</div>

				<div>

					<input class="control" type="email" name="correo"
						placeholder="correo" value="<%=correo%>">

				</div>

				<div>
					<input class="control" type="text" name="usuario"
						placeholder="usuario" value="<%=usuario%>">
				</div>

				<div>

					<input class="control" type="password" name="contrasena"
						placeholder="contrasena" value="<%=contrasena%>">

				</div>

				<div></div>

				<input class="boton" type="submit" value="Consultar"
					name="consultar"> <input class="boton" type="submit"
					value="Crear"> <input class="boton" type="submit"
					value="Actualizar"> <input class="boton" type="submit"
					value="Borrar">
			</form>
		</section>

	</div>



</body>
</html>