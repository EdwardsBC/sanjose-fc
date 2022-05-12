/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.Inscripcion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public class ControlInscripcion extends conexion{
      String err="";
    
public ArrayList<Inscripcion> getAllInscripcion() {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Inscripcion> inscripcion = new ArrayList<Inscripcion>();
         
       try{
           String consulta="SELECT * FROM dbo.Inscripcion";
           pst= getConexion().prepareStatement(consulta);
           rs= pst.executeQuery();
            while (rs.next()) {
                Inscripcion cr = new Inscripcion(rs.getInt("Id_Cargo"), rs.getInt("NombreCargo"), rs.getDouble("NombreCargo"));                
                 inscripcion.add(cr);
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
          return inscripcion;
   }
    
public ArrayList<Inscripcion> getInscripcion(int id) {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Inscripcion> inscripcion = new ArrayList<Inscripcion>();
         
       try{
           String consulta="SELECT * FROM dbo.Inscripcion where Id_Inscripcion=?";
           pst= getConexion().prepareStatement(consulta);
           pst.setInt(1, id);
           rs= pst.executeQuery();
            while (rs.next()) {
                 Inscripcion cr = new Inscripcion(rs.getInt("Id_Cargo"), rs.getInt("NombreCargo"), rs.getDouble("NombreCargo"));                
                 inscripcion.add(cr);
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
          return inscripcion;
   }
     
public String getError(){
    return err;
   }
   
public boolean NuevoInscripcion(String nombre){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="INSERT INTO dbo.Inscripcion (Nombre) VALUES (?)";
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
     
public boolean BuscaInscripcion(String id){
       PreparedStatement pst = null;  
       ResultSet rs = null;
           int rsCount=0;
       
       try{
           String consulta="select * from dbo.Inscripcion where Id_Cargo = ?";
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
    
public boolean ModificarInscripcion(String nombre, int id){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="UPDATE dbo.Inscripcion SET Nombre= ? WHERE Id_Cargo=?";
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
  
public boolean RemoverInscripcion(int id){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="DELETE FROM dbo.Inscripcion WHERE Id_Cargo=?";
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
