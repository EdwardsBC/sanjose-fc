/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.Cargo;
import beans.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author MARCOS
 */
public class ControlEmpleado extends conexion{
    String err="";
    
public ArrayList<Empleado> getAllEmpleado() {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Empleado> emple = new ArrayList<Empleado>();
         
       try{
           String consulta="SELECT * FROM dbo.Empleado";
           pst= getConexion().prepareStatement(consulta);
           rs= pst.executeQuery();
            while (rs.next()) {
                Empleado en = new Empleado(rs.getInt("Id_Empleado"),
                                           rs.getInt("Id_Login"), 
                                           rs.getInt("Id_Cargo"),
                                           rs.getString("NombreEmpleado"), 
                                           rs.getString("ApellidoEmpleado"),
                                           rs.getString("DireccionEmpleado"), 
                                           rs.getString("Telefono"),
                                           rs.getDate("FechaNacimiento"),
                                           rs.getString("Dni"), 
                                           rs.getBoolean("Vigencia"));                
                 emple.add(en);
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
          return emple;
   }

public ArrayList<Empleado> getEmpleado(int id) {
         PreparedStatement pst = null;
         ResultSet rs = null;
         int rsCount=0;
          ArrayList<Empleado> empleados = new ArrayList<Empleado>();
         
       try{
           String consulta="SELECT * FROM dbo.Empleado where Id_Empleado=?";
           pst= getConexion().prepareStatement(consulta);
           pst.setInt(1, id);
           rs= pst.executeQuery();
            while (rs.next()) {
                   Empleado en = new Empleado(rs.getInt("Id_Empleado"),
                                           rs.getInt("Id_Login"), 
                                           rs.getInt("Id_Cargo"),
                                           rs.getString("NombreEmpleado"), 
                                           rs.getString("ApellidoEmpleado"),
                                           rs.getString("DireccionEmpleado"), 
                                           rs.getString("Telefono"),
                                           rs.getDate("FechaNacimiento"),
                                           rs.getString("Dni"), 
                                           rs.getBoolean("Vigencia"));                   
                 empleados.add(en);
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
          return empleados;
   }

public String getError(){
    return err;
   }

public boolean NuevoEmpleado(int Id_Empleado, 
                             int Id_login, 
                             int Id_Cargo, 
                             String nombre,
                             String apellido,
                             String direccion, 
                             String telefono, 
                             String fechanacimiento, 
                             String dni, 
                             boolean vigencia){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="INSERT INTO dbo.Empleado (Id_Login, Id_Cargo, NombreEmpleado, ApellidoEmpleado, DireccionEmpleado, Telefono, FechaNacimientos, Dni, Vigencia) VALUES (?,?,?,?,?, ?,?,?,?)";
           pst= getConexion().prepareStatement(consulta);
           pst.setInt(1, Id_login);
           pst.setInt(2, Id_Cargo);
           pst.setString(3, nombre);
           pst.setString(4, apellido);
           pst.setString(5, direccion);
           pst.setString(6, telefono);
           pst.setString(7, fechanacimiento);
           pst.setString(8, dni);
           pst.setBoolean(9, vigencia);
                                                               
           
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

public boolean BuscaEmpleado(String id){
       PreparedStatement pst = null;  
       ResultSet rs = null;
           int rsCount=0;
       
       try{
           String consulta="select * from dbo.Empleado where Id_Empleado = ?";
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

public boolean ModificarEmpleado(int Id_Empleado, 
                                    int Id_login, 
                                    int Id_Cargo, 
                                    String nombre,
                                    String apellido,
                                    String direccion, 
                                    String telefono, 
                                    String fechanacimiento, 
                                    String dni, 
                                    boolean vigencia,
                                    int id){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="UPDATE dbo.Empleado SET Id_Login= ?, "
                   + "                              Id_Cargo=?, "
                   + "                              NombreEmpleado=?, "
                   + "                              ApellidoEmpleado=? "
                   + "                               DireccionEmpleado=?,"
                   + "                              Telefono=?,"
                   + "                              FechaNacimiento=?,"
                   + "Dni=?, Vigencia=?      WHERE Id_Cargo=?";
           pst= getConexion().prepareStatement(consulta);
            pst.setInt(1, Id_login);
           pst.setInt(2, Id_Cargo);
           pst.setString(3, nombre);
           pst.setString(4, apellido);
           pst.setString(5, direccion);
           pst.setString(6, telefono);
           pst.setString(7, fechanacimiento);
           pst.setString(8, dni);
           pst.setBoolean(9, vigencia);
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

public boolean RemoverEmpleado(int id){
       
       PreparedStatement pst = null;
     
       
       try{
           String consulta="DELETE FROM dbo.Empleado WHERE Id_Empleado=?";
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
