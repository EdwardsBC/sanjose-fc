/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;

public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idCategoria;
    private String nombreAnioCategoria;
    private Date turno;

    public Categoria() {
    }

    public Categoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria(Integer idCategoria, String nombreAnioCategoria, Date turno) {
        this.idCategoria = idCategoria;
        this.nombreAnioCategoria = nombreAnioCategoria;
        this.turno = turno;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreAnioCategoria() {
        return nombreAnioCategoria;
    }

    public void setNombreAnioCategoria(String nombreAnioCategoria) {
        this.nombreAnioCategoria = nombreAnioCategoria;
    }

    public Date getTurno() {
        return turno;
    }

    public void setTurno(Date turno) {
        this.turno = turno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Categoria[ idCategoria=" + idCategoria + " ]";
    }
    
}
