/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import beans.Alumno;
import java.util.Iterator;

/**
 *
 * @author MARCOS
 */
public class ControlAlumno extends conexion {
    String err="";
    
public ArrayList<Alumno> getAllAlumnos() {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
         
       try{
           String consulta="SELECT * FROM dbo.Alumno";
           pst= getConexion().prepareStatement(consulta);
           rs= pst.executeQuery();
            while (rs.next()) {
                Alumno al = new Alumno(rs.getInt("Id_Alumno"),
                                         rs.getInt("Id_Torneo"), 
                                         rs.getString("NombreAlumno"), 
                                         rs.getString("ApellidoAlumno"), 
                                         rs.getString("Direccion"), 
                                         rs.getDate("FechaNacimiento"), 
                                         rs.getString("Dni"), 
                                         rs.getBoolean("Vigencia"), 
                                         rs.getBoolean("VigenciaTorneos"),                  
                                         rs.getString("passwordAlumno"));                
                 alumnos.add(al);
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
          return alumnos;
   }
   
public ArrayList<Alumno> getAlumno(int idA) {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Alumno> alumno = new ArrayList<Alumno>();
         
       try{
           String consulta="SELECT * FROM dbo.Alumno where Id_Alumno=?";
           pst= getConexion().prepareStatement(consulta);
           pst.setInt(1, idA);
           rs= pst.executeQuery();
            while (rs.next()) {
                Alumno al = new Alumno(rs.getInt("Id_Alumno"),
                                         rs.getInt("Id_Torneo"), 
                                         rs.getString("NombreAlumno"), 
                                         rs.getString("ApellidoAlumno"), 
                                         rs.getString("Direccion"), 
                                         rs.getDate("FechaNacimiento"), 
                                         rs.getString("Dni"), 
                                         rs.getBoolean("Vigencia"), 
                                         rs.getBoolean("VigenciaTorneos"),                  
                                         rs.getString("passwordAlumno"));                
                 alumno.add(al);
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
          return alumno;
   }
   
   
public boolean NuevoAlumnos(int idTorneo, 
                               String nombreAlumno,
                               String apellidoAlumno,
                               String direccion,
                               String fechaNacimiento,
                               int dni,
                               int vigencia,
                               int vigenciaTorneos,
                               String clave){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="INSERT INTO dbo.Alumno (Id_Torneo ,NombreAlumno ,ApellidoAlumno ,Direccion ,FechaNacimiento ,Dni , Vigencia, VigenciaTorneos, passwordAlumno) VALUES  (?,?,?,?,?,?,?,?,?)";
           pst= getConexion().prepareStatement(consulta);
           pst.setInt(1, idTorneo);
           pst.setString(2, nombreAlumno);
           pst.setString(3, apellidoAlumno);
           pst.setString(4, direccion);
           pst.setString(5, fechaNacimiento);
           pst.setInt(6, dni);
           pst.setInt(7, vigencia);
           pst.setInt(8, vigenciaTorneos);
           pst.setString(9, clave);
      
           
           if(pst.executeUpdate()==1){
              err="registro OK";
               String usu= String.valueOf(dni);
               String dn = String.valueOf(dni);
               usu = usu.substring(usu.length()-3, usu.length());
               String[] cl = apellidoAlumno.split("(?=\\s)");
               String cla = cl[0]+usu;              
               UsuarioAlumno(dn, cla);
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
   
public boolean RemoverAlumnos(int dni){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="DELETE FROM dbo.Alumno WHERE Id_Alumno=?";
           pst= getConexion().prepareStatement(consulta);
           pst.setInt(1, dni);
      
           
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
   
public String getError(){
    return err;
   }
   
public boolean ModificarAlumnos(int idTorneo, 
                                    String nombreAlumno,
                                    String apellidoAlumno,
                                    String direccion,
                                    String fechaNacimiento,
                                    int dni,
                                    int vigencia,
                                    int vigenciaTorneos,
                                    String clave,
                                    int id){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="UPDATE dbo.Alumno SET Id_Torneo= ?,NombreAlumno= ?,ApellidoAlumno=? ,Direccion=? ,FechaNacimiento=? ,Dni=? , Vigencia=?, VigenciaTorneos=?, passwordAlumno=? WHERE Id_Alumno=?";
           pst= getConexion().prepareStatement(consulta);
           pst.setInt(1, idTorneo);
           pst.setString(2, nombreAlumno);
           pst.setString(3, apellidoAlumno);
           pst.setString(4, direccion);
           pst.setString(5, fechaNacimiento);
           pst.setInt(6, dni);
           pst.setInt(7, vigencia);
           pst.setInt(8, vigenciaTorneos);
           pst.setString(9, clave);
           pst.setInt(10, id);
           
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

public boolean BuscaAlumno(String DNI){
       PreparedStatement pst = null;  
       ResultSet rs = null;
           int rsCount=0;
       
       try{
           String consulta="select * from dbo.Alumno where dni = ?";
           pst= getConexion().prepareStatement(consulta);
           pst.setString(1, DNI);           
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
   
public boolean UsuarioAlumno(String usuario, String contraseña){
       PreparedStatement pst = null;
       
       try{
           String consulta="INSERT INTO dbo.Login(Usuario, Pazzword) VALUES (?,?)";
           pst= getConexion().prepareStatement(consulta);
           pst.setString(1, usuario);
           pst.setString(2, contraseña);
           
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
}
