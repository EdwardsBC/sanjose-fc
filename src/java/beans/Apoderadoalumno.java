/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

public class Apoderadoalumno implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idApoderadoAlumno;
    private int idAlumno;
    private int idApoderado;

    public Apoderadoalumno() {
    }

    public Apoderadoalumno(Integer idApoderadoAlumno) {
        this.idApoderadoAlumno = idApoderadoAlumno;
    }

    public Apoderadoalumno(Integer idApoderadoAlumno, int idAlumno, int idApoderado) {
        this.idApoderadoAlumno = idApoderadoAlumno;
        this.idAlumno = idAlumno;
        this.idApoderado = idApoderado;
    }

    public Integer getIdApoderadoAlumno() {
        return idApoderadoAlumno;
    }

    public void setIdApoderadoAlumno(Integer idApoderadoAlumno) {
        this.idApoderadoAlumno = idApoderadoAlumno;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdApoderado() {
        return idApoderado;
    }

    public void setIdApoderado(int idApoderado) {
        this.idApoderado = idApoderado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApoderadoAlumno != null ? idApoderadoAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apoderadoalumno)) {
            return false;
        }
        Apoderadoalumno other = (Apoderadoalumno) object;
        if ((this.idApoderadoAlumno == null && other.idApoderadoAlumno != null) || (this.idApoderadoAlumno != null && !this.idApoderadoAlumno.equals(other.idApoderadoAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Apoderadoalumno[ idApoderadoAlumno=" + idApoderadoAlumno + " ]";
    }
    
}
