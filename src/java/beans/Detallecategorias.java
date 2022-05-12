/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;


public class Detallecategorias implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idDetalleCategorias;
    private int idCategoria;
    private int idUnionCategorias;

    public Detallecategorias() {
    }

    public Detallecategorias(Integer idDetalleCategorias) {
        this.idDetalleCategorias = idDetalleCategorias;
    }

    public Detallecategorias(Integer idDetalleCategorias, int idCategoria, int idUnionCategorias) {
        this.idDetalleCategorias = idDetalleCategorias;
        this.idCategoria = idCategoria;
        this.idUnionCategorias = idUnionCategorias;
    }

    public Integer getIdDetalleCategorias() {
        return idDetalleCategorias;
    }

    public void setIdDetalleCategorias(Integer idDetalleCategorias) {
        this.idDetalleCategorias = idDetalleCategorias;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdUnionCategorias() {
        return idUnionCategorias;
    }

    public void setIdUnionCategorias(int idUnionCategorias) {
        this.idUnionCategorias = idUnionCategorias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleCategorias != null ? idDetalleCategorias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallecategorias)) {
            return false;
        }
        Detallecategorias other = (Detallecategorias) object;
        if ((this.idDetalleCategorias == null && other.idDetalleCategorias != null) || (this.idDetalleCategorias != null && !this.idDetalleCategorias.equals(other.idDetalleCategorias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Detallecategorias[ idDetalleCategorias=" + idDetalleCategorias + " ]";
    }
    
}
