/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

public class Unioncategorias implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idUnionCategorias;
    private String detalleCategorias;

    public Unioncategorias() {
    }

    public Unioncategorias(Integer idUnionCategorias) {
        this.idUnionCategorias = idUnionCategorias;
    }

    public Unioncategorias(Integer idUnionCategorias, String detalleCategorias) {
        this.idUnionCategorias = idUnionCategorias;
        this.detalleCategorias = detalleCategorias;
    }

    public Integer getIdUnionCategorias() {
        return idUnionCategorias;
    }

    public void setIdUnionCategorias(Integer idUnionCategorias) {
        this.idUnionCategorias = idUnionCategorias;
    }

    public String getDetalleCategorias() {
        return detalleCategorias;
    }

    public void setDetalleCategorias(String detalleCategorias) {
        this.detalleCategorias = detalleCategorias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnionCategorias != null ? idUnionCategorias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unioncategorias)) {
            return false;
        }
        Unioncategorias other = (Unioncategorias) object;
        if ((this.idUnionCategorias == null && other.idUnionCategorias != null) || (this.idUnionCategorias != null && !this.idUnionCategorias.equals(other.idUnionCategorias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Unioncategorias[ idUnionCategorias=" + idUnionCategorias + " ]";
    }
    
}
