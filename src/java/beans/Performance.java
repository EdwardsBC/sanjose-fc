/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Performance implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idEvaluacion;
    private int idAlumno;
    private BigDecimal talla;
    private String condicionFisica;
    private String dominioBalon;
    private String tipoJugador;
    private Date fecha;

    public Performance() {
    }

    public Performance(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public Performance(Integer idEvaluacion, int idAlumno, BigDecimal talla, String condicionFisica, String dominioBalon, String tipoJugador, Date fecha) {
        this.idEvaluacion = idEvaluacion;
        this.idAlumno = idAlumno;
        this.talla = talla;
        this.condicionFisica = condicionFisica;
        this.dominioBalon = dominioBalon;
        this.tipoJugador = tipoJugador;
        this.fecha = fecha;
    }

    public Integer getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public BigDecimal getTalla() {
        return talla;
    }

    public void setTalla(BigDecimal talla) {
        this.talla = talla;
    }

    public String getCondicionFisica() {
        return condicionFisica;
    }

    public void setCondicionFisica(String condicionFisica) {
        this.condicionFisica = condicionFisica;
    }

    public String getDominioBalon() {
        return dominioBalon;
    }

    public void setDominioBalon(String dominioBalon) {
        this.dominioBalon = dominioBalon;
    }

    public String getTipoJugador() {
        return tipoJugador;
    }

    public void setTipoJugador(String tipoJugador) {
        this.tipoJugador = tipoJugador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvaluacion != null ? idEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Performance)) {
            return false;
        }
        Performance other = (Performance) object;
        if ((this.idEvaluacion == null && other.idEvaluacion != null) || (this.idEvaluacion != null && !this.idEvaluacion.equals(other.idEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Performance[ idEvaluacion=" + idEvaluacion + " ]";
    }
    
}
