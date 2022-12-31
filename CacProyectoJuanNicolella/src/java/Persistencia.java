
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSetMetaData;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author usuario
 */
public class Persistencia {
    
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    
    public String servidor, baseDeDatos, usuario, clave, ejecutar;
    
    
    public Connection conectarse(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
        
            servidor = "localhost:3306/";
            baseDeDatos = "cacproyectojn";
            usuario = "root";
            clave = "";

            cn = (Connection) DriverManager.getConnection("jdbc:mysql://" +servidor +
                    baseDeDatos+"?autoReconnect=true&useSSL=false", usuario, clave );

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cn;
        
    }
    
    
    //****************************************************************************************************
    
    public ResultSet consultaSQL(String busqueda){
        
        
        try {
            ps = conectarse().prepareStatement(busqueda);
            
            rs = (ResultSet) ps.executeQuery();
        
            rsm = rs.getMetaData();
        
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
                
    }
    
    
    
    
}
