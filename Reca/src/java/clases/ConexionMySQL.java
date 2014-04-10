package clases;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionMySQL {

    public String db = "mydb";
    public String user = "root";
    public String pass = "";

    private Statement  st;
    private Connection con;
    private ResultSet resultadosQuery;

    public ConexionMySQL(){
        
    }
    
    public ConexionMySQL(String db, String user, String pass)
    {
           this.db = db;
           this.user = user;
           this.pass = pass;    
    }
    
    public Connection conexion()
    {
        String url = "jdbc:mysql://localhost/"+db+ "?user=" + user + "&password=" + pass;

    	try
		{
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Class.forName("com.mysql.jdbc.Driver");
                        //Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection(url);
		}
		catch (Exception ex)
		{
			System.out.println(ex.toString());
		}
                        return con;
    }

 // -------------------------------------------------------------------------------------------------
    
    public ResultSet ejecutaQuery(String cols, String tables, String cond){
        try {
                st  = con.createStatement();
                st.executeQuery("select " + cols + " from " + tables + " where " + cond);
                resultadosQuery = st.getResultSet();
        }
		catch (Exception ex)
		{
			System.out.println(ex.toString());
		}
                return resultadosQuery;
    }

    public boolean actualiza(String tabla, String campo, String dato, String condicion){

        String sSQL = "UPDATE ? SET ? = ? WHERE ?";
        int n = 0;

        try
        {
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setString(1, tabla);
            pst.setString(2, campo);
            pst.setString(3, dato);
            pst.setString(4, condicion);
            n = pst.executeUpdate();
        }
        catch (SQLException ex)
        {
			System.out.println(ex.toString());
        }
        if (n > 0) return true;
        else return false;
    }

    public ResultSet consultaProyectos(){
        try {
                st  = con.createStatement();
                st.executeQuery("select * from Proyecto");
                resultadosQuery = st.getResultSet();
        }
		catch (Exception ex)
		{
			System.out.println(ex.toString());
		}
                return resultadosQuery;
    }
    
    public ResultSet consultaProyectos(String id){
        try {
                st  = con.createStatement();
                st.executeQuery("select * from Proyecto where idJefe = " + id);
                resultadosQuery = st.getResultSet();
        }
	catch (Exception ex)
	{
            System.out.println(ex.toString());
	}
        return resultadosQuery;
    }

    public ResultSet consultaAnalistas(){
        try {
                st  = con.createStatement();
                st.executeQuery("select * from Analistas");
                resultadosQuery = st.getResultSet();
        }
		catch (Exception ex)
		{
			System.out.println(ex.toString());
		}
                return resultadosQuery;
    }

    public ResultSet consultaJefeAnalistas(){
        try {
                st  = con.createStatement();
                st.executeQuery("select * from JefeAnalistas");
                resultadosQuery = st.getResultSet();
        }
		catch (Exception ex)
		{
			System.out.println(ex.toString());
		}
                return resultadosQuery;
    }
        
    public ResultSet consultaEstados(){
        try {
                st  = con.createStatement();
                st.executeQuery("select * from Estados");
                resultadosQuery = st.getResultSet();
        }
		catch (Exception ex)
		{
			System.out.println(ex.toString());
		}
                return resultadosQuery;
    }

    public ResultSet consultaObservacion(){
        try {
                st  = con.createStatement();
                st.executeQuery("select * from Observacion");
                resultadosQuery = st.getResultSet();
        }
		catch (Exception ex)
		{
			System.out.println(ex.toString());
		}
                return resultadosQuery;
    }

    public ResultSet consultaRequerimientos(){
        try {
                st  = con.createStatement();
                st.executeQuery("select * from Requerimientos");
                resultadosQuery = st.getResultSet();
        }
		catch (Exception ex)
		{
			System.out.println(ex.toString());
		}
                return resultadosQuery;
    }

    public ResultSet consultaIteracion(){
        try {
                st  = con.createStatement();
                st.executeQuery("select * from Iteracion");
                resultadosQuery = st.getResultSet();
        }
		catch (Exception ex)
		{
			System.out.println(ex.toString());
		}
                return resultadosQuery;
    }
    
    public boolean altaProyecto(String nombre,
                                String fechaInicio, // Formato "AAAA-MM-DD"
                                String fechaFin,    // Formato "AAAA-MM-DD"
                                String costo, 
                                String objetivo, 
                                String descripcion, 
                                String cliente, 
                                String porcentaje,
                                String idJefe){

        String sSQL = "insert into  Proyecto " +
                "(nombre, fechaInicio, fechaFin, costo, objetivo, descripcion, cliente, porcentaje, idJefe)"
                + "values ('?','?','?','?','?','?','?','?','?')";
        int n = 0;

        try
        {
            Date fInicio = Date.valueOf(fechaInicio);
            Date fFin = Date.valueOf(fechaFin);
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setString(1, nombre);
            pst.setDate(2, fInicio);
            pst.setDate(3, fFin);
            pst.setString(4, costo);
            pst.setString(5, objetivo);
            pst.setString(6, descripcion);
            pst.setString(7, cliente);
            pst.setString(8, porcentaje);
            pst.setString(9, idJefe);
            n = pst.executeUpdate();
        }
        catch (SQLException ex)
        {
			System.out.println(ex.toString());
        }
        if (n > 0) return true;
        else return false;
    }

    
    public boolean altaAnalista(String nombre,
                                String apPaterno, 
                                String apMaterno, 
                                int edad, 
                                String correo, 

                                String genero,
                                String password,
                                int idJefe){

        String sSQL = "insert into Analistas " +
                "(nombre, apPaterno, apMaterno, edad, correo, genero, contrasena, idJefe)"
                + "values (?,?,?,?,?,?,?,?)";
        int n = 0;

        System.out.println(sSQL);
     
        
        
        
        try
        {
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setString(1, nombre);
            pst.setString(2, apPaterno);
            pst.setString(3, apMaterno);
            pst.setInt(4, edad);
            pst.setString(5, correo);
            pst.setString(6, genero);
            pst.setString(7, password);
            pst.setInt(8, idJefe);
            n = pst.executeUpdate();
        }
        catch (SQLException ex)
        {
			System.out.println(ex.toString());
        }
        if (n > 0) return true;
        else return false;
    }
    
    public boolean altaIteracion(String identificador,
                                String fechaInicio,     //Formato "AAAA-MM-DD"
                                String fechaFin,        //Formato "AAAA-MM-DD"
                                String idProyecto){

        String sSQL = "insert into Iteracion " +
                "(identificador, fechaInicio, fechaFin, idProyecto)"
                + "values ('?','?','?','?')";
        int n = 0;

        try
        {
            Date fInicio = Date.valueOf(fechaInicio);
            Date fFin = Date.valueOf(fechaFin);
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setString(1, identificador);
            pst.setDate(2, fInicio);
            pst.setDate(3, fFin);
            pst.setString(4, idProyecto);
            
            n = pst.executeUpdate();
        }
        catch (SQLException ex)
        {
			System.out.println(ex.toString());
        }
        if (n > 0) return true;
        else return false;
    }
    
    public boolean altaLiderAnalista(String nombre,
                                String apPaterno, 
                                String apMaterno, 
                                int edad, 
                                String correo, 
                                String genero, String password){

        String sSQL = "insert into JefeAnalistas " +
                "(nombre, apPaterno, apMaterno, edad, correo, genero,password)"
                + "values ('?','?','?','?','?','?','?')";
        int n = 0;

        try
        {
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setString(1, nombre);
            pst.setString(2, apPaterno);
            pst.setString(3, apMaterno);
            pst.setInt(4, edad);
            pst.setString(5, correo);
            pst.setString(6, genero);
            pst.setString(7, password);
            n = pst.executeUpdate();
        }
        catch (SQLException ex)
        {
			System.out.println(ex.toString());
        }
        if (n > 0) return true;
        else return false;
    }
    
    public boolean altaRequerimientos(String identificador,
                                String descripcion, 
                                String Requerimientoscol,
                                String observaciones,
                                String tipo,
                                String fechaInicio,     //Formato "AAAA-MM-DD"
                                String fechaFin,        //Formato "AAAA-MM-DD"
                                String idIteracion,
                                String idAnalista,
                                String idEstados, 
                                String madurez,
                                String volatilidad,
                                String complejidad){

        String sSQL = "insert into Requerimientos " +
                "(identificador, descripcion, Requerimientoscol, observaciones, tipo, fechaInicio, fechaFin, idIteracion, idAnalista, idEstados, madurez, volatilidad, complejidad)"
                + "values ('?','?','?','?','?','?','?','?','?','?','?','?','?')";
        int n = 0;

        try
        {
            Date fInicio = Date.valueOf(fechaInicio);
            Date fFin = Date.valueOf(fechaFin);
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setString(1, identificador);
            pst.setString(2, descripcion);
            pst.setString(3, Requerimientoscol);
            pst.setString(4, observaciones);
            pst.setString(5, tipo);
            pst.setDate(6, fInicio);
            pst.setDate(7, fFin);
            pst.setString(8, idIteracion);
            pst.setString(9, idAnalista);
            pst.setString(10, idEstados);
            pst.setString(11, madurez);
            pst.setString(12, volatilidad);
            pst.setString(13, complejidad);
            
            n = pst.executeUpdate();
        }
        catch (SQLException ex)
        {
			System.out.println(ex.toString());
        }
        if (n > 0) return true;
        else return false;
    }

    
    public boolean altaEstados(String nombre){

        String sSQL = "insert into JefeAnalistas " +
                "(nombre) values ('?')";
        int n = 0;

        try
        {
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setString(1, nombre);
            n = pst.executeUpdate();
        }
        catch (SQLException ex)
        {
			System.out.println(ex.toString());
        }
        if (n > 0) return true;
        else return false;
    }
    
    public boolean altaObservacion(String descripcion,
                                String idRequerimiento){

        String sSQL = "insert into JefeAnalistas " +
                "(descripcion, idRequerimiento) values ('?','?')";
        int n = 0;

        try
        {
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setString(1, descripcion);
            pst.setString(2, idRequerimiento);
            n = pst.executeUpdate();
        }
        catch (SQLException ex)
        {
			System.out.println(ex.toString());
        }
        if (n > 0) return true;
        else return false;
    }

public boolean EliminarAnalistas(int idAnalista){
        int idA;
        String SQL1="",mensaje="Se Elimino Correctamente el Registro";        
        
        idA = idAnalista;
        int n=0;
        
        SQL1="DELETE from analistas WHERE idAnalistas="+idA;        
        
        try {
            Statement s1=con.createStatement();
            
            int a = s1.executeUpdate(SQL1);
           
            JOptionPane.showMessageDialog(null, mensaje);

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }       
        if (n > 0) return true;
        else return false;
}
    public void cierraConexion() throws SQLException{
        con.close();
    }
    
    public boolean existeUsuario(String email, String password) throws SQLException{
        String sql = "SELECT * FROM jefeanalistas WHERE correo='"+email+"' AND contrasena='"+password+"';";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();        
        if(rs.next()) return true;
        else return false;
    }
    
    public String getIdJefe(String email) throws SQLException{
        String sql = "SELECT idJefeAnalistas FROM jefeanalistas WHERE correo='"+email+"';";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();        
        return rs.getString(1);        
    }
}
