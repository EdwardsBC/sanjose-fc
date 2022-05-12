/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;

public class Apoderado implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idApoderado;
    private String nombreApoderado;
    private String apellidoApoderado;
    private String detalleApoderado;
    private String direccion;
    private Date fechaNacimiento;
    private String dni;
    private String telefono;

    public Apoderado() {
    }

    public Apoderado(Integer idApoderado) {
        this.idApoderado = idApoderado;
    }

    public Apoderado(Integer idApoderado, String nombreApoderado, String apellidoApoderado, String detalleApoderado, String direccion, Date fechaNacimiento, String dni, String telefono) {
        this.idApoderado = idApoderado;
        this.nombreApoderado = nombreApoderado;
        this.apellidoApoderado = apellidoApoderado;
        this.detalleApoderado = detalleApoderado;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.telefono = telefono;
    }

    public Integer getIdApoderado() {
        return idApoderado;
    }

    public void setIdApoderado(Integer idApoderado) {
        this.idApoderado = idApoderado;
    }

    public String getNombreApoderado() {
        return nombreApoderado;
    }

    public void setNombreApoderado(String nombreApoderado) {
        this.nombreApoderado = nombreApoderado;
    }

    public String getApellidoApoderado() {
        return apellidoApoderado;
    }

    public void setApellidoApoderado(String apellidoApoderado) {
        this.apellidoApoderado = apellidoApoderado;
    }

    public String getDetalleApoderado() {
        return detalleApoderado;
    }

    public void setDetalleApoderado(String detalleApoderado) {
        this.detalleApoderado = detalleApoderado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApoderado != null ? idApoderado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apoderado)) {
            return false;
        }
        Apoderado other = (Apoderado) object;
        if ((this.idApoderado == null && other.idApoderado != null) || (this.idApoderado != null && !this.idApoderado.equals(other.idApoderado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Apoderado[ idApoderado=" + idApoderado + " ]";
    }
    
}
