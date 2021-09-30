<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<%!String mensaje = "";
	String direccion_cliente = "", correo_cliente = "", nombre_cliente = "", telefono_cliente = "", estado = "";
	int cedula_cli = 0;%>
	<%
	if (request.getParameter("cedula_cli") != null) {

		cedula_cli = Integer.parseInt(request.getParameter("cedula_cli"));
		direccion_cliente = request.getParameter("nombre_cliente");
		correo_cliente = request.getParameter("correo_cliente");
		nombre_cliente = request.getParameter("nombre_cliente");
		telefono_cliente = request.getParameter("telefono_cliente");
		estado = "disabled";
	}
	%>
	<%
	if (request.getParameter("men") != null) {
		cedula_cli = 0;
		direccion_cliente = "";
		correo_cliente = "";
		nombre_cliente = "";
		telefono_cliente = "";
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
					<a class="nav-link active" href="Clientes.jsp">Clientes</a> <a
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

			<h4>Modulo Clientes</h4>
			<form action="Cliente" method="post">

				<div>
					<label class="subtitulos">Cedula: </label> <input class="control"
						type="text" name="cedula_cli" value="<%=cedula_cli%>"
						placeholder="Cedula Cliente" required <%=estado%>> <input
						type="hidden" name="ced_cli" value="<%=cedula_cli%>">
				</div>


				<div>
					<label class="subtitulos">Direccion Completo: </label> <input
						class="control" type="text" name="direccion_cliente"
						placeholder="Direccion Cliente" value="<%=direccion_cliente%>">
				</div>
				<div>
					<label class="subtitulos">Correo Cliente: </label> <input
						class="control" type="email" name="correo_cliente"
						placeholder="Correo Cliente" value="<%=correo_cliente%>">
				</div>

				<div>
					<label class="subtitulos">Nombre Cliente: </label> <input
						class="control" type="text" name="nombre_cliente"
						placeholder="Nombre Cliente" value="<%=nombre_cliente%>">
				</div>

				<div>
					<label class="subtitulos">Telefono Cliente: </label> <input
						class="control" type="text" name="telefono_cliente"
						placeholder="Telefono Cliente" value="<%=telefono_cliente%>">

				</div>

				<div class="boton-cent">

					<div>
						<input class="boton" type="submit" value="Consultar"
							name="consultar_cli">
					</div>
					<div>
						<input class="boton" type="submit" value="Crear" name="crear_cli">
					</div>
					<div>
						<input class="boton" type="submit" value="Actualizar"
							name="actualizar_cli">
					</div>
					<div>
						<input class="boton" type="submit" value="Borrar" name="borrar_cli">
					</div>

				</div>



			</form>
		</section>

	</div>



</body>
</html>