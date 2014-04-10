package servlets;

import clases.ConexionMySQL;
import clases.Validador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Giovani
 */
public class ServletLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        HttpSession user = request.getSession();
        
        Validador v = new Validador();
        ConexionMySQL d = new ConexionMySQL();
        
        if(email.isEmpty() || password.isEmpty()){
            user.setAttribute("error", "Hay campos vacios");
            response.sendRedirect("login.jsp");
        } else{
            //email valido
            if(!v.isEmailValid(email)){
                user.setAttribute("error", "Email incorrecto");
                response.sendRedirect("login.jsp");
            } else{
                if(v.isPasswordValid(password)){
                    try {
                        d.conexion();
                        if(d.existeUsuario(email, password)){
                            user.setAttribute("userEmail", email);
                            response.sendRedirect("proyectos.jsp");
                        } else{
                            user.setAttribute("error", "No estas registrado");
                            response.sendRedirect("login.jsp");
                        }
                        d.cierraConexion();
                    } catch (Exception e) {         
                        user.setAttribute("error", "No DB");
                        response.sendRedirect("login.jsp");
                    }
                } else{
                    user.setAttribute("error", "Contraseña no valida");
                    response.sendRedirect("login.jsp");
                }
            }
        }                                        
    }
}
