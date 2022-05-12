/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;

public class Pagotorneo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idPagoTorneo;
    private int idTorneo;
    private Date fechaPago;
    private double pagoTorneo;
    private double montoPagado;
    private boolean vigencia;

    public Pagotorneo() {
    }

    public Pagotorneo(Integer idPagoTorneo) {
        this.idPagoTorneo = idPagoTorneo;
    }

    public Pagotorneo(Integer idPagoTorneo, int idTorneo, Date fechaPago, double pagoTorneo, double montoPagado, boolean vigencia) {
        this.idPagoTorneo = idPagoTorneo;
        this.idTorneo = idTorneo;
        this.fechaPago = fechaPago;
        this.pagoTorneo = pagoTorneo;
        this.montoPagado = montoPagado;
        this.vigencia = vigencia;
    }

    public Integer getIdPagoTorneo() {
        return idPagoTorneo;
    }

    public void setIdPagoTorneo(Integer idPagoTorneo) {
        this.idPagoTorneo = idPagoTorneo;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getPagoTorneo() {
        return pagoTorneo;
    }

    public void setPagoTorneo(double pagoTorneo) {
        this.pagoTorneo = pagoTorneo;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(double montoPagado) {
        this.montoPagado = montoPagado;
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
        hash += (idPagoTorneo != null ? idPagoTorneo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagotorneo)) {
            return false;
        }
        Pagotorneo other = (Pagotorneo) object;
        if ((this.idPagoTorneo == null && other.idPagoTorneo != null) || (this.idPagoTorneo != null && !this.idPagoTorneo.equals(other.idPagoTorneo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Pagotorneo[ idPagoTorneo=" + idPagoTorneo + " ]";
    }
    
}
