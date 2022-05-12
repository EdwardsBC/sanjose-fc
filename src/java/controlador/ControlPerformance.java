/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.Performance;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public class ControlPerformance extends conexion{
        String err="";
    
public ArrayList<Performance> getAllPerformance() {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Performance> performance = new ArrayList<Performance>();
         
       try{
           String consulta="SELECT * FROM dbo.Performance";
           pst= getConexion().prepareStatement(consulta);
           rs= pst.executeQuery();
            while (rs.next()) {
                Performance cr = new Performance(rs.getInt("Id_Cargo"), 
                                                 rs.getInt("Id_Cargo"), 
                                                 rs.getBigDecimal("NombreCargo"),
                                                 rs.getString("Id_Cargo"), 
                                                 rs.getString("Id_Cargo"), 
                                                 rs.getString("NombreCargo"),
                                                 rs.getDate("NombreCargo"));                
                 performance.add(cr);
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
          return performance;
   }
    
public ArrayList<Performance> getPerformance(int id) {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Performance> performance = new ArrayList<Performance>();
         
       try{
           String consulta="SELECT * FROM dbo.Cargo where Id_Cargo=?";
           pst= getConexion().prepareStatement(consulta);
           pst.setInt(1, id);
           rs= pst.executeQuery();
            while (rs.next()) {
                 Performance cr = new Performance(rs.getInt("Id_Cargo"), 
                                                 rs.getInt("Id_Cargo"), 
                                                 rs.getBigDecimal("NombreCargo"),
                                                 rs.getString("Id_Cargo"), 
                                                 rs.getString("Id_Cargo"), 
                                                 rs.getString("NombreCargo"),
                                                 rs.getDate("NombreCargo"));                
                 performance.add(cr);
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
          return performance;
   }
     
public String getError(){
    return err;
   }
   
public boolean NuevoPerformance(String nombre){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="INSERT INTO dbo.Performance (Nombre) VALUES (?)";
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
     
public boolean BuscaPerformance(String id){
       PreparedStatement pst = null;  
       ResultSet rs = null;
           int rsCount=0;
       
       try{
           String consulta="select * from dbo.Performance where Id_Cargo = ?";
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
    
public boolean ModificarPerformance(String nombre, int id){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="UPDATE dbo.Performance SET Nombre= ? WHERE Id_Cargo=?";
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
  
public boolean RemoverPerformance(int id){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="DELETE FROM dbo.Performance WHERE Id_Cargo=?";
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
