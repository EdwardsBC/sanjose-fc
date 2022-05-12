/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;

public class Matricula implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idMatricula;
    private int idApoderadoAlumno;
    private int idEmpleado;
    private int idUnionCategorias;
    private Date fechaMatricula;
    private boolean temporada;
    private boolean estado;
    private double pagoMatricula;
    private double fechaPago;

    public Matricula() {
    }

    public Matricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Matricula(Integer idMatricula, int idApoderadoAlumno, int idEmpleado, int idUnionCategorias, Date fechaMatricula, boolean temporada, boolean estado, double pagoMatricula, double fechaPago) {
        this.idMatricula = idMatricula;
        this.idApoderadoAlumno = idApoderadoAlumno;
        this.idEmpleado = idEmpleado;
        this.idUnionCategorias = idUnionCategorias;
        this.fechaMatricula = fechaMatricula;
        this.temporada = temporada;
        this.estado = estado;
        this.pagoMatricula = pagoMatricula;
        this.fechaPago = fechaPago;
    }

    public Integer getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public int getIdApoderadoAlumno() {
        return idApoderadoAlumno;
    }

    public void setIdApoderadoAlumno(int idApoderadoAlumno) {
        this.idApoderadoAlumno = idApoderadoAlumno;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdUnionCategorias() {
        return idUnionCategorias;
    }

    public void setIdUnionCategorias(int idUnionCategorias) {
        this.idUnionCategorias = idUnionCategorias;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public boolean getTemporada() {
        return temporada;
    }

    public void setTemporada(boolean temporada) {
        this.temporada = temporada;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getPagoMatricula() {
        return pagoMatricula;
    }

    public void setPagoMatricula(double pagoMatricula) {
        this.pagoMatricula = pagoMatricula;
    }

    public double getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(double fechaPago) {
        this.fechaPago = fechaPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatricula != null ? idMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.idMatricula == null && other.idMatricula != null) || (this.idMatricula != null && !this.idMatricula.equals(other.idMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Matricula[ idMatricula=" + idMatricula + " ]";
    }
    
}
