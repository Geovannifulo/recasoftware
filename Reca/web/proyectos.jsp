<%-- 
    Document   : proyectos
    Created on : 09-abr-2014, 20:19:30
    Author     : Geovanni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta description="registro de usuarios">
	<link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="css/principal2.css">
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
	<title>RECA | Proyectos</title>
</head>
<body>
        
	<header>
		<h1>RECA</h1>
	</header>

	<nav>
		<ul>
			<li><a href="proyectos.html">Proyectos</a></li>
			<li><a href="iteraciones.html">Iteraciones</a></li>
			<li><a href="requerimientos.html">Requerimientos</a></li>
			<li><a href="analistas.html">Analistas</a></li>
		</ul>
	</nav>

	<section id="tproyecto">

		<div>
			<p>Proyectos</p>
			<div>
				<a class="boton" href="#">Agregar Proyecto</a>
			</div>
		</div>
		<table class="table">
	      <thead>
	        <tr>
	          <th>#</th>
                  <th>${sessionScope['userEmail']}</th>
	          <th>Last Name</th>
	          <th>Username</th>
	        </tr>
	      </thead>
	      <tbody>
	        <tr>
	          <td>1</td>
	          <td>Mark</td>
	          <td>Otto</td>
	          <td>@mdo</td>
	        </tr>
	        <tr>
	          <td>2</td>
	          <td>Jacob</td>
	          <td>Thornton</td>
	          <td>@fat</td>
	        </tr>
	        <tr>
	          <td>3</td>
	          <td>Larry</td>
	          <td>the Bird</td>
	          <td>@twitter</td>
	        </tr>
	      </tbody>
		</table>
		</div>
	</section>
	

</body>
</html>

