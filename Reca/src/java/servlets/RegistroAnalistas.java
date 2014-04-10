/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;
import clases.ConexionMySQL;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo
 */
@WebServlet(name = "RegistroAnalistas", urlPatterns = {"/RegistroAnalistas"})
public class RegistroAnalistas extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String nombre = request.getParameter("nombre");
        String apPaterno = request.getParameter("apPaterno");
        String apMtaerno = request.getParameter("apMaterno");
        String correo = (String) request.getParameter("email");
        String genero = (String) request.getParameter("genero");
        int edad =  Integer.parseInt(request.getParameter("edad"));
        System.out.println(edad);
        String password = request.getParameter("passwd");
        ConexionMySQL con = new ConexionMySQL();
        
        try {
            con.conexion();
            if(con.altaAnalista(nombre, apPaterno, apPaterno, edad, correo, genero, password, 1))
            {
                response.sendRedirect("analistas.jsp");
            }
        } catch (Exception e){
            e.printStackTrace();
            response.sendError(500, "No se pudo registrar");
        }
               
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
