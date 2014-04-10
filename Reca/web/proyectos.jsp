<%-- 
    Document   : proyectos
    Created on : 09-abr-2014, 20:19:30
    Author     : Geovanni
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="clases.ConexionMySQL"%>
<%@page import="java.sql.*" %>
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
			<li><a href="analistas.jsp">Analistas</a></li>
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
                    
      <%
          try{
            ConexionMySQL con = new ConexionMySQL();          
            HttpSession user = request.getSession();

            con.conexion();
            String email = (String)user.getAttribute("userEmail");
            String id = con.getIdJefe(email);
            ResultSet rsProyectos = con.consultaProyectos(id);          
      %>
	      <thead>
	        <tr>
	          <th>#</th>
                  <th>Nombre</th>
	          <th>Fecha de Inicio</th>
	          <th>Fecha de Fin</th>
                  <th>Costo</th>
                  <th>Objetivo</th>
                  <th>Descripción</th>
                  <th>Cliente</th>
                  <th>Porcentaje</th>
	        </tr>
	      </thead>
	      <tbody>
                  
       <%
            while(rsProyectos.next()){
                String nom = (String)rsProyectos.getString(2);
                String fechaInicio = (String)rsProyectos.getString(3);
                String fechaFin = (String)rsProyectos.getString(4);
                String costo = (String)rsProyectos.getString(5);
                String obj = (String)rsProyectos.getString(6);
                String descripcion = (String)rsProyectos.getString(7);
                String cliente = (String)rsProyectos.getString(8);
                String porcentaje = (String)rsProyectos.getString(9);

                out.println("<tr>");
                out.println("<td>" + nom + "</td>");
                out.println("<td>" + fechaInicio + "</td>");
                out.println("<td>" + fechaFin + "</td>");
                out.println("<td>" + costo + "</td>");
                out.println("<td>" + obj + "</td>");
                out.println("<td>" + descripcion + "</td>");
                out.println("<td>" + cliente + "</td>");
                out.println("<td>" + porcentaje + "</td>");
                out.println("</tr>");
            }
            rsProyectos.close();
            con.cierraConexion();
          } catch(Exception e){
              
          }
       %>
	        <!-- <tr>
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
	        </tr>-->
	      </tbody>
		</table>
		</div>
	</section>
	

</body>
</html>

