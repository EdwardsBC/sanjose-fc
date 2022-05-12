/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.Pagomensual;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public class ControlPagomensual extends conexion{
              String err="";
    
public ArrayList<Pagomensual> getAllPagomensual() {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Pagomensual> pagomensual = new ArrayList<Pagomensual>();
         
       try{
           String consulta="SELECT * FROM dbo.Pagomensual";
           pst= getConexion().prepareStatement(consulta);
           rs= pst.executeQuery();
            while (rs.next()) {
                Pagomensual cr = new Pagomensual(rs.getInt("Id_Cargo"),
                                             rs.getInt("Id_Cargo"), 
                                             rs.getBigDecimal("Id_Cargo"), 
                                             rs.getBigDecimal("Id_Cargo"), 
                                             rs.getDate("Id_Cargo"), 
                                             rs.getDate("NombreCargo"), 
                                             rs.getBoolean("NombreCargo"));                
                 pagomensual.add(cr);
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
          return pagomensual;
   }
    
public ArrayList<Pagomensual> getPagomensual(int id) {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Pagomensual> pagomensual = new ArrayList<Pagomensual>();
         
       try{
           String consulta="SELECT * FROM dbo.Pagomensual where Id_Cargo=?";
           pst= getConexion().prepareStatement(consulta);
           pst.setInt(1, id);
           rs= pst.executeQuery();
            while (rs.next()) {
                 Pagomensual cr = new Pagomensual(rs.getInt("Id_Cargo"),
                                             rs.getInt("Id_Cargo"), 
                                             rs.getBigDecimal("Id_Cargo"), 
                                             rs.getBigDecimal("Id_Cargo"), 
                                             rs.getDate("Id_Cargo"), 
                                             rs.getDate("NombreCargo"), 
                                             rs.getBoolean("NombreCargo"));                
                 pagomensual.add(cr);
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
          return pagomensual;
   }
     
public String getError(){
    return err;
   }
   
public boolean NuevoPagomensual(String nombre){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="INSERT INTO dbo.Pagomensual (Nombre) VALUES (?)";
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
     
public boolean BuscaPagomensual(String id){
       PreparedStatement pst = null;  
       ResultSet rs = null;
           int rsCount=0;
       
       try{
           String consulta="select * from dbo.Pagomensual where Id_Cargo = ?";
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
    
public boolean ModificarPagomensual(String nombre, int id){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="UPDATE dbo.Pagomensual SET Nombre= ? WHERE Id_Cargo=?";
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
  
public boolean RemoverPagomensual(int id){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="DELETE FROM dbo.Pagomensual WHERE Id_Cargo=?";
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
