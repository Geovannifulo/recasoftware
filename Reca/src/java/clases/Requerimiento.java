package ClasesPrincipales;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Isaac
 */
public class Requerimiento {
   private int idRequerimiento;
   private String Identficador;
   private String NombreRequerimiento;
   private String Descripcion;
   private String EstadoRequerimiento;
   private String Tipo;
   private String PrioridadRequerimiento;
   private String Observaciones;
   
   String UsuarioBD = "";
   String Contrasenia = "";
   String url = "jdbc:mysql://localhost/...";
   Connection conexion;
   Statement consultaBD;
   
   void cargarDriverDB(){
    try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
    }
    catch(Exception ex){
        JOptionPane.showMessageDialog(null, "Error al cargar driver de BD");
    }
   }//fin cargarDriver
   
   void conectarDB(){
       try{
          conexion = DriverManager.getConnection(url, UsuarioBD, Contrasenia);
       }
       catch(Exception ex){
           JOptionPane.showMessageDialog(null, "Error al conectar con BD");
       }
   }//conectarBD
   
   void Requerimiento(int idRequerimiento,String Identficador,String NombreRequerimiento,String Descripcion,String EstadoRequerimiento,String Tipo,String PrioridadRequerimiento,String Observaciones){
    this.idRequerimiento=idRequerimiento;
    this.Identficador=Identficador;
    this.NombreRequerimiento=NombreRequerimiento;
    this.Descripcion=Descripcion;
    this.EstadoRequerimiento=EstadoRequerimiento;
    this.Tipo=Tipo;
    this.PrioridadRequerimiento=PrioridadRequerimiento;
    this.Observaciones=Observaciones;
   }
   
   int NuevoRequerimiento(){
       try {
           consultaBD.executeUpdate("INSERT INTO Requerimiento (idRequerimiento,Identficador,NombreRequerimiento,Descripcion,EstadoRequerimiento,Tipo,PrioridadRequerimiento,Observaciones) VALUES ('idRequerimiento','"+Identficador+"','"+NombreRequerimiento+"','"+Descripcion+"','"+EstadoRequerimiento+"','"+Tipo+"','"+PrioridadRequerimiento+"','"+Observaciones+"')");
           return 0;
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error al ejecutar consulta en BD");
          return 1;
       }
   }//NuevoRequerimiento
   
   int EditarRequerimiento(){
       try {       
        // ejemplo consulta: String q = "UPDATE tabla SET " +"NOMBRE='" + nombre +"', EDAD='" + edad +"' WHERE clave=" + clave1;
        String ConsultaEdita = "UPDATE Requerimiento SET "+ "Identficador='"+Identficador+"', NombreRequerimiento='"+NombreRequerimiento+"', Descripcion='"+Descripcion+"' , EstadoRequerimiento='"+EstadoRequerimiento+"', Tipo='"+Tipo+"', PrioridadRequerimiento='"+PrioridadRequerimiento+"' , Observaciones='"+Observaciones+"' WHERE id='"+idRequerimiento;
        consultaBD.executeUpdate(ConsultaEdita);
             return 0;
       } catch (SQLException ex) {
           Logger.getLogger(Requerimiento.class.getName()).log(Level.SEVERE, null, ex);
             return 1;
       }
     
   }//EditarRequerimiento
   
   int EliminarRequerimiento(){
       String eliminar = "DELETE FROM Registration " +
                   "WHERE id =" + idRequerimiento;
       try {
           consultaBD.executeUpdate(eliminar);
           return 0;
       } catch (SQLException ex) {
           Logger.getLogger(Requerimiento.class.getName()).log(Level.SEVERE, null, ex);
       }
       return 1;
   }
   
  int cosultarRequerimiento(){
  String consultarReq = "SELECT * FROM Requerimiento where idRequerimiento="+idRequerimiento;
       try {
           ResultSet resultset = consultaBD.executeQuery(consultarReq);
           return 0;
       } catch (SQLException ex) {
           Logger.getLogger(Requerimiento.class.getName()).log(Level.SEVERE, null, ex);
           return 1;
       }
  
  }

  int cosultarTodosRequerimientos(){
  String consultarReqs = "SELECT * FROM Requerimiento";
       try {
           ResultSet resultset = consultaBD.executeQuery(consultarReqs);
           return 0;
       } catch (SQLException ex) {
           Logger.getLogger(Requerimiento.class.getName()).log(Level.SEVERE, null, ex);
           return 1;
       }
  
  }
}//clase
