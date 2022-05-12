/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.Apoderadoalumno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Marcos
 */
public class ControlApoderadoalumno extends conexion{
            String err="";
    
public ArrayList<Apoderadoalumno> getAllEmpleado() {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Apoderadoalumno> apoderado = new ArrayList<Apoderadoalumno>();
         
       try{
           String consulta="SELECT * FROM dbo.Apoderadoalumno";
           pst= getConexion().prepareStatement(consulta);
           rs= pst.executeQuery();
            while (rs.next()) {
                Apoderadoalumno ap = new Apoderadoalumno(rs.getInt("Id_Apoderado"),
                                           rs.getInt("NombreApoderado"), 
                                           rs.getInt("ApellidoApoderado"));                
                 apoderado.add(ap);
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
          return apoderado;
   }

public ArrayList<Apoderadoalumno> getEmpleado(int id) {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Apoderadoalumno> apoderado = new ArrayList<Apoderadoalumno>();
         
       try{
           String consulta="SELECT * FROM dbo.Apoderado where Id_Apoderado=?";
           pst= getConexion().prepareStatement(consulta);
           pst.setInt(1, id);
           rs= pst.executeQuery();
            while (rs.next()) {
                   Apoderadoalumno ap = new Apoderadoalumno(rs.getInt("Id_Apoderado"),
                                           rs.getInt("NombreApoderado"), 
                                           rs.getInt("ApellidoApoderado"));                   
                 apoderado.add(ap);
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
          return apoderado;
   }

public String getError(){
    return err;
   }

public boolean NuevoApoderado(String nombreApoderado, 
                              String apellidoApoderado, 
                              String detalleApoderado, 
                              String direccion, 
                              Date fechaNacimiento, 
                              String dni, 
                              String telefono){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="INSERT INTO dbo.Apoderado (NombreApoderado, ApellidoApoderado, DetalleApoderado, Direccion, FechaNacimiento, Dni, Telefono) VALUES (?,?,?,?,?,?,?)";
           pst= getConexion().prepareStatement(consulta);
           pst.setString(1, nombreApoderado);
           pst.setString(2, apellidoApoderado);
           pst.setString(3, detalleApoderado);
           pst.setString(4, direccion);
           pst.setDate(5, (java.sql.Date) fechaNacimiento);
           pst.setString(6, dni);
           pst.setString(7, telefono);
                                                               
           
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

public boolean BuscaApoderado(String id){
       PreparedStatement pst = null;  
       ResultSet rs = null;
           int rsCount=0;
       
       try{
           String consulta="select * from dbo.Apoderado where Id_Apoderado = ?";
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

public boolean ModificarApoderado(String nombreApoderado, 
                                  String apellidoApoderado, 
                                  String detalleApoderado, 
                                  String direccion, 
                                  Date fechaNacimiento, 
                                  String dni, 
                                  String telefono,
                                  int id){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="UPDATE dbo.Apoderado SET NombreApoderado= ?, "
                   + "                              ApellidoApoderado=?, "
                   + "                              DetalleApoderado=?, "
                   + "                              Direccion=? "
                   + "                              FechaNacimiento=?,"
                   + "                              Dni=?,"
                   + "                              Telefono=?"
                   + "     WHERE Id_Apoderado=?";
           pst= getConexion().prepareStatement(consulta);
           pst.setString(1, nombreApoderado);
           pst.setString(2, apellidoApoderado);
           pst.setString(3, detalleApoderado);
           pst.setString(4, direccion);
           pst.setDate(5, (java.sql.Date) fechaNacimiento);
           pst.setString(6, dni);
           pst.setString(7, telefono);
           pst.setInt(8, id);
           
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

public boolean RemoverApoderado(int id){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="DELETE FROM dbo.Apoderado WHERE Id_Apoderado=?";
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
