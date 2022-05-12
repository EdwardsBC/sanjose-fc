/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.Torneo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MARCOS
 */
public class ControlTorneo extends conexion{
    String err="";
    
  public ArrayList<Torneo> getAllTorneos() {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Torneo> Torneo = new ArrayList<Torneo>();
         
       try{
           String consulta="SELECT * FROM dbo.Torneo";
           pst= getConexion().prepareStatement(consulta);
           rs= pst.executeQuery();
            while (rs.next()) {
                Torneo tr = new Torneo(rs.getInt("Id_Torneo"), 
                                         rs.getString("Nombre"), 
                                         rs.getString("Empleado"), 
                                         rs.getString("Lugar"), 
                                         rs.getDate("FechaInicio"), 
                                         rs.getDate("FechaFin"));                
                 Torneo.add(tr);
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
          return Torneo;
   }
  
  public ArrayList<Torneo> getTorneo(int id) {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Torneo> Torneo = new ArrayList<Torneo>();
         
       try{
           String consulta="SELECT * FROM dbo.Torneo where Id_Torneo=?";
           pst= getConexion().prepareStatement(consulta);
           pst.setInt(1, id);
           rs= pst.executeQuery();
            while (rs.next()) {
                 Torneo tr = new Torneo(rs.getInt("Id_Torneo"), 
                                         rs.getString("Nombre"), 
                                         rs.getString("Empleado"), 
                                         rs.getString("Lugar"), 
                                         rs.getDate("FechaInicio"), 
                                         rs.getDate("FechaFin"));                
                 Torneo.add(tr);
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
          return Torneo;
   }
     
  public String getError(){
    return err;
   }
   
  public boolean NuevoTorneo(String nombre, 
                               String empleado,
                               String lugar,
                               String fechaInicio,
                               String fechafinal){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="INSERT INTO dbo.Torneo (Nombre ,Empleado ,Lugar ,FechaInicio ,FechaFin) VALUES  (?,?,?,?,?)";
           pst= getConexion().prepareStatement(consulta);
           pst.setString(1, nombre);
           pst.setString(2, empleado);
           pst.setString(3, lugar);
           pst.setString(4, fechaInicio);
           pst.setString(5, fechafinal);
           
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
     
  public boolean BuscaTorneo(String id){
       PreparedStatement pst = null;  
       ResultSet rs = null;
           int rsCount=0;
       
       try{
           String consulta="select * from dbo.Torneo where id_Torneo = ?";
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
    
  public boolean ModificarTorneo(String nombre, 
                               String empleado,
                               String lugar,
                               String fechaInicio,
                               String fechafinal,
                               int id){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="UPDATE dbo.Torneo SET Nombre= ?,Empleado= ?,Lugar=? ,FechaInicio=? ,FechaFin=? WHERE Id_Torneo=?";
           pst= getConexion().prepareStatement(consulta);
           pst.setString(1, nombre);
           pst.setString(2, empleado);
           pst.setString(3, lugar);
           pst.setString(4, fechaInicio);
           pst.setString(5, fechafinal);
           pst.setInt(6,id);
           
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
  
public boolean RemoverTorneo(int id){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="DELETE FROM dbo.Torneo WHERE Id_Torneo=?";
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
