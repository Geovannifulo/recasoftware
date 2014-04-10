/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import clases.ConexionMySQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Isaac
 */
public class ServletRegistrarLiderAnalista extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        ConexionMySQL BaseDeDatos = new ConexionMySQL();
        
        String nombre = request.getParameter("Nombre");
        String apellidoPaterno = request.getParameter("Apellido_Paterno");
        String apellidoMaterno = request.getParameter("Apellido_Materno");
        String genero = request.getParameter("Genero");
        int edad = Integer.parseInt(request.getParameter("Edad"));
        String email = request.getParameter("Email");
        String password = request.getParameter("password");
        
        if(BaseDeDatos.altaLiderAnalista(nombre,apellidoPaterno,apellidoMaterno,edad,email,genero,password)){
            response.sendRedirect("login.jsp");
        }
        else{
            response.sendError(112, "Ocurrio un error al intentar registrarlo. Por favor intentelo de nuevo");
            
        }
    
    }

}
