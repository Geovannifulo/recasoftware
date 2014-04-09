package clasesproyectoingenieriadesoftware;


import BaseDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodrigo
 */
public class Analista {
    
public void EditarAnalistas(int idAnalistas, String nombre, String apPaterno, String apMaterno, int edad, String correo, String genero, int idJefe, int idAOriginal){
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();

        String nomb,apeP,apeM, corr, gen;
        int idA,ed,idJ,idAO;        
        String SQL1="",mensaje="Se Edito Correctamente el Registro";        

        idAO = idAOriginal;
        idA = idAnalistas;
        nomb = nombre;
        apeP = apPaterno;
        apeM = apMaterno;
        ed = edad;
        corr = correo;
        gen = genero;
        idJ = idJefe;        
        
        if(idA!=0){
            SQL1="UPDATE analistas set idAnalistas = " + idA + " , nombre = ' " + nomb + " ' where idAnalistas = " + idAO;
        }
        
        try {
            Statement s1=cn.createStatement();
            
            int a = s1.executeUpdate(SQL1);
           
            JOptionPane.showMessageDialog(null, mensaje);

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }      
}

public void EliminarAnalistas(int idAnalista){
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();

        int idA;
        String SQL1="",mensaje="Se Elimino Correctamente el Registro";        
        
        idA = idAnalista;
        
        SQL1="DELETE from analistas WHERE idAnalistas="+idA;        
        
        try {
            Statement s1=cn.createStatement();
            
            int a = s1.executeUpdate(SQL1);
           
            JOptionPane.showMessageDialog(null, mensaje);

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }       
}

public void InsertarAnalista(int idAnalistas, String nombre, String apPaterno, String apMaterno, int edad, String correo, String genero, int idJefe){
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();        
        
        String nomb,apeP,apeM, corr, gen;
        int idA,ed,idJ;
        String SQL1 = "", mensaje="Se Inserto Correctamente el Registro";
        
        idA = idAnalistas;
        nomb = nombre;
        apeP = apPaterno;
        apeM = apMaterno;
        ed = edad;
        corr = correo;
        gen = genero;
        idJ = idJefe;

                
        SQL1="INSERT INTO analistas(idAnalistas,nombre,apPaterno,apMaterno,edad,correo,genero,idJefe)" + "VALUES(?,?,?,?,?,?,?,?)";
        
        if(idA!=0 || ed!=0 || idJ!=0){
            try{
                PreparedStatement pst1 = cn.prepareStatement(SQL1);
                
                pst1.setInt(1, idA);
                pst1.setString(2, nomb);
                pst1.setString(3, apeP);
                pst1.setString(4, apeM);
                pst1.setInt(5, edad);
                pst1.setString(6, correo);
                pst1.setString(7, genero);
                pst1.setInt(8, idJ);
                
                
                int n = pst1.executeUpdate();
                
                if(n > 0){
                    JOptionPane.showMessageDialog(null, mensaje);
                }
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }      
        }else 
            JOptionPane.showMessageDialog(null, "Id Analistas debe ser mayor a 0");
    }

}
