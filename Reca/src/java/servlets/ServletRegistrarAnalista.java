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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Isaac
 */
public class ServletRegistrarAnalista extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession user = request.getSession();
        String idJefe = (String) user.getAttribute("idLiderAnalista");
        
        ConexionMySQL BaseDeDatos = new ConexionMySQL();
        
        String nombre = request.getParameter("Nombre");
        String apellidoPaterno = request.getParameter("Apellido_Paterno");
        String apellidoMaterno = request.getParameter("Apellido_Materno");
        String genero = request.getParameter("Genero");
        int edad = Integer.parseInt(request.getParameter("Edad"));
        String email = request.getParameter("Email");
        String password = request.getParameter("password");
        
        if(BaseDeDatos.altaAnalista(nombre,apellidoPaterno,apellidoMaterno,edad,email,genero,idJefe,password)){
            response.sendRedirect("proyectos.jsp");
        }
        else{
            response.sendError(111, "Ocurrio un error al intentar registrar al analista. Por favor intentelo de nuevo");
            
        }
    
    }

}
