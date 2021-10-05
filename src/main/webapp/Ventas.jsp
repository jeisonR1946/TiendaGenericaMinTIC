<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/master.css">
</head>
<body>


	<%!String mensaje = "";
	String estado = "";
	int cedula = 0, cedula_cli = 0, cod_pro1 = 0, valor_total = 0;
	String nombre_producto = "";%>

	<%
	if (request.getParameter("cedula") != null) {

		cedula = Integer.parseInt(request.getParameter("cedula"));

		estado = "disabled";
	}
	%>


	<%
	if (request.getParameter("cedula_cli") != null) {

		cedula_cli = Integer.parseInt(request.getParameter("cedula_cli"));

		estado = "disabled";
	}
	%>

	<%
	if (request.getParameter("nombre_producto") != null) {

		nombre_producto = request.getParameter("nombre_producto");

		estado = "disabled";
	}
	%>

	<%
	if (request.getParameter("valor_total") != null) {

		valor_total = Integer.parseInt(request.getParameter("valor_total"));

		estado = "disabled";
	}
	%>





	<%
	if (request.getParameter("men") != null) {
		cedula = 0;
		cedula_cli = 0;
		nombre_producto = "";
		valor_total = 0;

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
						class="nav-link" href="Proveedores.jsp">Proveedores</a><a
						class="nav-link" href="Productos.jsp">Productos</a><a
						class="nav-link active" href="Ventas.jsp">Ventas</a><a
						class="nav-link" href="Reportes.jsp">Reportes</a>
				</div>
			</div>
		</div>
	</nav>

	<div>



		<section class="form-gene">

			<h4>Modulo Usuario</h4>
			<form action="Venta" method="post">

				<div>
					<label class="subtitulos">Cedula Usuario: </label> <input
						class="control" type="text" name="cedula" value="<%=cedula%>"
						placeholder="cedula" required <%=estado%>> <input
						type="hidden" name="ced" value="<%=cedula%>"> <label
						class="subtitulos"> cedula traia usu: </label> <input
						class="control" type="text" name="correo" placeholder="correo"
						value="<%=cedula%>">
				</div>

				<div>
					<label class="subtitulos">Cedula Cliente: </label> <input
						class="control" type="text" name="cedula_cli"
						value="<%=cedula_cli%>" placeholder="Cedula Cliente" required
						<%=estado%>> <input type="hidden" name="ced_cli"
						value="<%=cedula_cli%>"> <label class="subtitulos">cedula
						traia cli: </label> <input class="control" type="text"
						name="direccion_cliente" placeholder="Direccion Cliente"
						value="<%=cedula_cli%>">
				</div>
				<div class="boton-cent">

					<div>
						<input class="boton" type="submit" value="Consultar Usuario"
							name="consultarUsu">
					</div>


				</div>

				<label class="subtitulos">Cod pdoructo --</label> <label
					class="subtitulos">boton: --</label> <label class="subtitulos">nombre
					producto: --</label> <label class="subtitulos">Cantidad: --</label> <label
					class="subtitulos">Valor total: --</label>

				<div>
					<div>

						<input class="control" type="text" name="cod_pro1"
							value="<%=cod_pro1%>" placeholder="Codigo"> <input
							type="hidden" name="cod_producto" value="<%=cod_pro1%>">
							
						<input class="boton" type="submit" value="Consultar producto"
							name="consultarPro"
							
							
							> <input class="control" type="text"
							name="nombre_producto" placeholder="nombre producto"
							value="<%=nombre_producto%>"> <input class="control"
							type="text" name="cantidad" placeholder="Cantidad"> <input
							class="control" type="text" name="valor_total"
							value="<%=valor_total%>" placeholder="Valor total"> <input
							type="hidden" name="valor_total_hidden" value="<%=valor_total%>">


					</div>



				</div>

				<div>
					<input class="boton" type="submit" value="Confirmar"
						name="confirmar">

				</div>







			</form>
		</section>


	</div>



</body>
</html>