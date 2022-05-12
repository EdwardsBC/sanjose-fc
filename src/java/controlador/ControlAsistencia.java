/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.Asistencia;
import beans.Cargo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author MARCOS
 */
public class ControlAsistencia extends conexion {
     String err="";
     
public ArrayList<Asistencia> getAllAsistencia() {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Asistencia> asistencia = new ArrayList<Asistencia>();
         
       try{
           String consulta="SELECT * FROM dbo.Asistencia";
           pst= getConexion().prepareStatement(consulta);
           rs= pst.executeQuery();
            while (rs.next()) {
                Asistencia as = new Asistencia(rs.getInt("Id_Asistencia"),
                                               rs.getInt("Id_Alumno"),
                                               rs.getDate("fecha"), 
                                               rs.getBoolean("Asistió"));                
                 asistencia.add(as);
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
          return asistencia;
   }
     
public ArrayList<Asistencia> getAsistencia(int id) {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Asistencia> asistencia = new ArrayList<Asistencia>();
         
       try{
           String consulta="SELECT * FROM dbo.Asistencia where Id_Asistencia=?";
           pst= getConexion().prepareStatement(consulta);
           pst.setInt(1, id);
           rs= pst.executeQuery();
            while (rs.next()) {
                 Asistencia as = new Asistencia(rs.getInt("Id_Asistencia"),     
                                                rs.getInt("Id_Alumno"),
                                                rs.getDate("fecha"),     
                                                rs.getBoolean("Asistió"));                
                 asistencia.add(as);
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
          return asistencia;
   }

public String getError(){
    return err;
   }

public boolean NuevoAsistencia(int idAlumno, Date fecha, boolean asistió){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="INSERT INTO dbo.Asistencia (Id_Alumno, fecha, Asistió) VALUES (?,?,?)";
           pst= getConexion().prepareStatement(consulta); 
           pst.setInt(1, idAlumno);
           pst.setDate(1, (java.sql.Date) fecha);
           pst.setBoolean(1, asistió);
           
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

public boolean BuscaAsistencia(String id){
       PreparedStatement pst = null;  
       ResultSet rs = null;
           int rsCount=0;
       
       try{
           String consulta="select * from dbo.Asistencia where Id_Asistencia = ?";
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

public boolean ModificarAsistencia(int idAlumno, Date fecha, boolean asistió){       
       PreparedStatement pst = null;       
       try{
           String consulta="UPDATE dbo.Asistencia SET Id_Alumno= ?,fecha=?, Asistió=?  WHERE Id_Asistencia=?";
           pst= getConexion().prepareStatement(consulta);
           pst.setInt(1, idAlumno);
           pst.setDate(2, (java.sql.Date) fecha);
           pst.setBoolean(3,asistió);
           
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

public boolean RemoverAsistencia(int id){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="DELETE FROM dbo.Asistencia WHERE Id_Asistencia=?";
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
