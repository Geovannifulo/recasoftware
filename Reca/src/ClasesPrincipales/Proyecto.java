package ClasesPrincipales;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Giovani
 */
public class Proyecto {
    private String id;
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private int costo;        
    private String objetivo;
    private String descripcion;
    private String cliente;
    private float porcentaje;
    private int idJefe;
    private ConectaBD baseDeDatos;
    
    public Proyecto(String id, String nombre, String fechaInicio, String fechaFin, int costo, 
            String objetivo, String descripcion, String cliente, float porcentaje, int idJefe){
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        this.objetivo = objetivo;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.porcentaje = porcentaje;
        this.idJefe = idJefe;
    }
    
    public int CrearProyecto(String id, String nombre, String fechaInicio, String fechaFin, int costo, 
            String objetivo, String descripcion, String cliente, float porcentaje, int idJefe){
        baseDeDatos.conectarDB();
        baseDeDatos.cargarDB();
        String query = "INSERT INTO Proyecto (idProyecto, nombre, fechaInicio, fechaFin, costo, objetivo, descripcion, cliente, porcentaje, idJefe) VALUES (idProyecto, "
                + "'" + nombre + "', '" + fechaInicio + "', '" + fechaFin + "', " + costo + ", '" + objetivo + "', '" + descripcion 
                + "', '" + cliente + "', " + porcentaje + ", " + idJefe + ");";
        baseDeDatos.alta(query);
        return 0;
    }
    
    public int EditarProyecto(){
        baseDeDatos.conectarDB();
        baseDeDatos.cargarDB();
        String query = "UPDATE Proyecto SET" + "nombre='" + nombre + "', fechaInicio='" + fechaInicio + "', fechaFin='" + fechaFin 
                + "', costo=" + costo + ", objetivo='" + objetivo + "', descripcion='" + descripcion + "', cliente='" + cliente
                + "', porcentaje=" + porcentaje + ", idJefe=" + idJefe + "WHERE idProyecto =" + id + ";";
        baseDeDatos.cambio(query);
        return 0;
    }
    
    public int EliminarProyecto(){
        baseDeDatos.conectarDB();
        baseDeDatos.cargarDB();
        String query = "DELETE FROM Proyecto WHERE idProyecto=" + id + ";";
        baseDeDatos.baja(query);
        return 0;
    }
    
    public int ConsultarProyecto(){
        baseDeDatos.conectarDB();
        baseDeDatos.cargarDB();
        String query = "SELECT * FROM Proyecto WHERE idProyecto=" + id + ";";
        baseDeDatos.consulta(query);
        return 0;
    }
    
}


