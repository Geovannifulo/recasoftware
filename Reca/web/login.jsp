<%-- 
    Document   : login
    Created on : 09-abr-2014, 20:27:59
    Author     : Geovanni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta description="login de la pagina">
		<link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" type="text/css" href="normalize.css">
		<link rel="stylesheet" type="text/css" href="css/principal.css">
		<title>RECA | Inicio Sesion</title>
	</head>
        
	<body>
		<header>
			<h1>RECA</h1>
		</header>                
		<section class="cuadro">
                    <form action="ServletLogin" method="POST">
				<p>Inicio de Sesión</p>
                                <p style="color: #ff0000">${sessionScope['error']}</p>
				<div><input type="email" name="email" placeholder="email:"></div>
				<div><input type="password" name="password" placeholder="password:"></div>
				<div><input id="entrar" type="submit" value="Entrar"></div>
				<div id="registro">
					<a href="registro.html">Registrarse</a>
				</div>
			</form>
		</section>
	</body>
</html>