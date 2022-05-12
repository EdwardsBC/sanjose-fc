/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Pagomensual implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idPagoMensual;
    private int idMatricula;
    private BigDecimal montoPagado;
    private BigDecimal montoPagar;
    private Date fechaPagada;
    private Date fechaPagar;
    private boolean vigencia;

    public Pagomensual() {
    }

    public Pagomensual(Integer idPagoMensual) {
        this.idPagoMensual = idPagoMensual;
    }

    public Pagomensual(Integer idPagoMensual, int idMatricula, BigDecimal montoPagado, BigDecimal montoPagar, Date fechaPagada, Date fechaPagar, boolean vigencia) {
        this.idPagoMensual = idPagoMensual;
        this.idMatricula = idMatricula;
        this.montoPagado = montoPagado;
        this.montoPagar = montoPagar;
        this.fechaPagada = fechaPagada;
        this.fechaPagar = fechaPagar;
        this.vigencia = vigencia;
    }

    public Integer getIdPagoMensual() {
        return idPagoMensual;
    }

    public void setIdPagoMensual(Integer idPagoMensual) {
        this.idPagoMensual = idPagoMensual;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public BigDecimal getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(BigDecimal montoPagado) {
        this.montoPagado = montoPagado;
    }

    public BigDecimal getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(BigDecimal montoPagar) {
        this.montoPagar = montoPagar;
    }

    public Date getFechaPagada() {
        return fechaPagada;
    }

    public void setFechaPagada(Date fechaPagada) {
        this.fechaPagada = fechaPagada;
    }

    public Date getFechaPagar() {
        return fechaPagar;
    }

    public void setFechaPagar(Date fechaPagar) {
        this.fechaPagar = fechaPagar;
    }

    public boolean getVigencia() {
        return vigencia;
    }

    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagoMensual != null ? idPagoMensual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagomensual)) {
            return false;
        }
        Pagomensual other = (Pagomensual) object;
        if ((this.idPagoMensual == null && other.idPagoMensual != null) || (this.idPagoMensual != null && !this.idPagoMensual.equals(other.idPagoMensual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Pagomensual[ idPagoMensual=" + idPagoMensual + " ]";
    }
    
}
