/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idAlumno;
    private int idTorneo;
    private String nombreAlumno;
    private String apellidoAlumno;
    private String direccion;
    private Date fechaNacimiento;
    private String dni;
    private boolean vigencia;
    private boolean vigenciaTorneos;
    private String passwordAlumno;    
    private ArrayList<Alumno> listAlumno;
    

    public Alumno() {
    }

    public Alumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Alumno(Integer idAlumno, int idTorneo, String nombreAlumno, String apellidoAlumno, String direccion, Date fechaNacimiento, String dni, boolean vigencia, boolean vigenciaTorneos, String passwordAlumno) {
        this.idAlumno = idAlumno;
        this.idTorneo = idTorneo;
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.vigencia = vigencia;
        this.vigenciaTorneos = vigenciaTorneos;
        this.passwordAlumno = passwordAlumno;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
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

    public boolean getVigencia() {
        return vigencia;
    }

    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }

    public boolean getVigenciaTorneos() {
        return vigenciaTorneos;
    }

    public void setVigenciaTorneos(boolean vigenciaTorneos) {
        this.vigenciaTorneos = vigenciaTorneos;
    }

    public String getPasswordAlumno() {
        return passwordAlumno;
    }

    public void setPasswordAlumno(String passwordAlumno) {
        this.passwordAlumno = passwordAlumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlumno != null ? idAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.idAlumno == null && other.idAlumno != null) || (this.idAlumno != null && !this.idAlumno.equals(other.idAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Alumno[ idAlumno=" + idAlumno + " ]";
    }
    
     public ArrayList<Alumno> getDetalles() {
        return listAlumno;
    }

    public void setDetalles(ArrayList<Alumno> listAlumno) {
        this.listAlumno = listAlumno;
    }
    
}
