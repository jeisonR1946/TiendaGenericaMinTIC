<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda Generica</title>
<link rel="stylesheet" href="css/master.css">
</head>
<body>
	<div class="login">
		<img alt="Logo de f" class="avatar" src="img/q.png">
		<h1>Tienda Genérica</h1>
		<form action="LoginTienda" method="post">
			<!-- USER NAME -->
			<label for="user_name">Usuario: </label> <input type="text"
				placeholder="Ingrese el usuario" name="usu"> <label
				for="user_pass">Contraseña: </label> <input type="password"
				placeholder="Ingrese contraseña" name="contra"> <input
				type="submit" name="iniciar" value="Aceptar"> <input
				type="reset">
			<!-- <a href="#">Recuperar su contraseña</a> <br>
				<a href="#">Crear un usuario</a> -->
		</form>
	</div>
</body>
</html>