/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author MARCOS
 */
public class Consultas extends conexion {
    
    public boolean autenticacion(String usuario, String pass){
           PreparedStatement pst = null;
           ResultSet rs = null;
           int rsCount=0;
           
           try{ 
             String consulta = "select * from Login where Usuario =? and Pazzword=?";   
             pst= getConexion().prepareStatement(consulta);
             pst.setString(1, usuario);
             pst.setString(2, pass);
             rs= pst.executeQuery();
             
            while (rs.next()) {
                  rsCount++;
                }
            
            if(rsCount>0){
                 return true;
            }else{
                 return false;
            }
    
           }catch(Exception e){
           System.err.print("Error"+e);
           }finally{
               try{
                if(getConexion()!= null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
               
               }catch(Exception e){
                System.err.print("Error"+e);
               }
           }
           
           
           
           return false;
    }
    
   public boolean registrar(String usuario, String contraseña){
       PreparedStatement pst = null;
       
       try{
           String consulta="INSERT INTO dbo.Login(Usuario, Pazzword) VALUES (?,?)";
           pst= getConexion().prepareStatement(consulta);
           pst.setString(1, usuario);
           pst.setString(2, contraseña);
           
           if(pst.executeUpdate()==1){
             return true;
           }
       }catch(Exception ex){
            System.err.printf("Error" + ex);
       }finally{
            try{
                    if(getConexion()!=null) getConexion().close();
                    if(pst != null) pst.close();
            }catch (Exception e){
            System.err.printf("Error" + e);
            }
       
       }
    return false;
   } 
   
   
    
}


