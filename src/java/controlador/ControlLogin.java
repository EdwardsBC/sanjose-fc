/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public class ControlLogin extends conexion{
      String err="";
    
public ArrayList<Login> getAllLogin() {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Login> login = new ArrayList<Login>();
         
       try{
           String consulta="SELECT * FROM dbo.Cargos";
           pst= getConexion().prepareStatement(consulta);
           rs= pst.executeQuery();
            while (rs.next()) {
                Login cr = new Login(rs.getInt("Id_Cargo"), rs.getString("NombreCargo"), rs.getString("NombreCargo"));                
                 login.add(cr);
                }
         
       }catch(Exception ex){
            System.err.printf("Error" + ex);
            err="Error" + ex;
       }finally{
            try{
                    if(getConexion()!=null) getConexion().close();
                    if(pst != null) pst.close();
            }catch (Exception e){
            System.err.printf("Error" + e);
            err="Error" + e;
            }
       
       }
        err="Consulta OK";
          return login;
   }
    
public ArrayList<Login> getLogin(int id) {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Login> login = new ArrayList<Login>();
         
       try{
           String consulta="SELECT * FROM dbo.Cargo where Id_Cargo=?";
           pst= getConexion().prepareStatement(consulta);
           pst.setInt(1, id);
           rs= pst.executeQuery();
            while (rs.next()) {
                 Login cr = new Login(rs.getInt("Id_Cargo"), rs.getString("NombreCargo"), rs.getString("NombreCargo"));                
                 login.add(cr);
                }
         
       }catch(Exception ex){
            System.err.printf("Error" + ex);
            err="Error" + ex;
       }finally{
            try{
                    if(getConexion()!=null) getConexion().close();
                    if(pst != null) pst.close();
            }catch (Exception e){
            System.err.printf("Error" + e);
            err="Error" + e;
            }
       
       }
        err="Busqueda OK";
          return login;
   }
     
public String getError(){
    return err;
   }
   
public boolean NuevoLogin(String nombre){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="INSERT INTO dbo.Login (Nombre) VALUES (?)";
           pst= getConexion().prepareStatement(consulta);
           pst.setString(1, nombre);
           
           if(pst.executeUpdate()==1){
              err="registro OK";
             return true;
           }
       }catch(Exception ex){
            System.err.printf("Error" + ex);
            err="Error" + ex;
       }finally{
            try{
                    if(getConexion()!=null) getConexion().close();
                    if(pst != null) pst.close();
            }catch (Exception e){
            System.err.printf("Error" + e);
            err="Error" + e;
            }
       
       }
    return false;
   } 
     
public boolean BuscaLogin(String id){
       PreparedStatement pst = null;  
       ResultSet rs = null;
           int rsCount=0;
       
       try{
           String consulta="select * from dbo.Login where Id_Cargo = ?";
           pst= getConexion().prepareStatement(consulta);
           pst.setString(1, id);           
           rs= pst.executeQuery();
           
             
            while (rs.next()) {
                  rsCount++;
                }
            
            if(rsCount>0){
                 err="Consulta OK";
                 return true;
            }else{
                err="Consulta sin registros";
                 return false;
            }
            
       }catch(Exception ex){
            System.err.printf("Error" + ex);
            err="Error" + ex;
       }finally{
            try{
                    if(getConexion()!=null) getConexion().close();
                    if(pst != null) pst.close();
            }catch (Exception e){
            System.err.printf("Error" + e);
            err="Error" + e;
            }
       
       }
    return false;
   } 
    
public boolean ModificarLogin(String nombre, int id){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="UPDATE dbo.Login SET Nombre= ? WHERE Id_Cargo=?";
           pst= getConexion().prepareStatement(consulta);
           pst.setString(1, nombre);
           pst.setInt(2,id);
           
           if(pst.executeUpdate()==1){
                err="Modificacion OK";
             return true;
           }
       }catch(Exception ex){
            System.err.printf("Error" + ex);
            err="Error" + ex;
       }finally{
            try{
                    if(getConexion()!=null) getConexion().close();
                    if(pst != null) pst.close();
            }catch (Exception e){
            System.err.printf("Error" + e);
            err="Error" + e;
            }
       
       }
    return false;
   } 
  
public boolean RemoverLogin(int id){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="DELETE FROM dbo.Login WHERE Id_Cargo=?";
           pst= getConexion().prepareStatement(consulta);
           pst.setInt(1, id);
      
           
           if(pst.executeUpdate()==1){
                err="remover OK";
             return true;
           }
       }catch(Exception ex){
            System.err.printf("Error" + ex);
            err="Error" + ex;
       }finally{
            try{
                    if(getConexion()!=null) getConexion().close();
                    if(pst != null) pst.close();
            }catch (Exception e){
            System.err.printf("Error" + e);
            err="Error" + e;
            }
       
       }
    return false;
   } 
}
