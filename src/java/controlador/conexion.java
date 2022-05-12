/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author MARCOS
 */
public class conexion {
    private String USERNAME ="sanjosefc";
    private String PASSWORD ="academia";
    private String HOST="MARCOS-PC:1433";
    private String DATABASE="sanjosefc";
    private String CLASSNAME="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String URL="jdbc:sqlserver://"+HOST+";databaseName="+DATABASE;
    private Connection con;
        
    public conexion(){
       try{
                 Class.forName(CLASSNAME);
                 con= DriverManager.getConnection(URL, USERNAME, PASSWORD);
                 
           }catch(ClassNotFoundException e){
                System.err.println("ERROR"+ e);
           }catch(SQLException e){
                System.err.println("Error"+e);
             }
    }
    
    public Connection getConexion(){
      return con;
        }
    
    public static void main(String[] args){
      conexion con = new conexion();
    }
    
}
