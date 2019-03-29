/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SCO3
 */
public class Model {
    private static final String URL = "jdbc:mysql://localhost/cbVentas";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "";
    private Connection conexion;
    private PreparedStatement instruccion;
    
    public Model(){
        try{
            Class.forName(DRIVER);
            this.conexion = (Connection) DriverManager.getConnection(URL,USER,PASS);
        }
        catch(ClassNotFoundException ex){
            
        } 
        catch (SQLException sql) {
            
        }
    }
    protected void executarSimpleQuery(String sql,String Columns[]){
        try {
            this.instruccion = this.conexion.prepareStatement(sql, Columns);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void Close(){
        try {
            this.instruccion.close();
            this.conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
