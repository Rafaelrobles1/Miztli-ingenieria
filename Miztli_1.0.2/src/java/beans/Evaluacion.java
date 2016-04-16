/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author salador
 */
@Entity
@Table(name = "evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e"),
    @NamedQuery(name = "Evaluacion.findByIdEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.idEvaluacion = :idEvaluacion"),
    @NamedQuery(name = "Evaluacion.findByCumplimientoContrato", query = "SELECT e FROM Evaluacion e WHERE e.cumplimientoContrato = :cumplimientoContrato"),
    @NamedQuery(name = "Evaluacion.findByCalificacion", query = "SELECT e FROM Evaluacion e WHERE e.calificacion = :calificacion"),
    @NamedQuery(name = "Evaluacion.findByObservacionesE", query = "SELECT e FROM Evaluacion e WHERE e.observacionesE = :observacionesE"),
    @NamedQuery(name = "Evaluacion.findByRecomentar", query = "SELECT e FROM Evaluacion e WHERE e.recomentar = :recomentar"),
    @NamedQuery(name = "Evaluacion.findByIdUsuario", query = "SELECT e FROM Evaluacion e WHERE e.idUsuario = :idUsuario")})
public class Evaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_evaluacion")
    private Integer idEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cumplimiento_contrato")
    private boolean cumplimientoContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calificacion")
    private int calificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "observaciones_e")
    private String observacionesE;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recomentar")
    private boolean recomentar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;

    public Evaluacion() {
    }

    public Evaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public Evaluacion(Integer idEvaluacion, boolean cumplimientoContrato, int calificacion, String observacionesE, boolean recomentar, int idUsuario) {
        this.idEvaluacion = idEvaluacion;
        this.cumplimientoContrato = cumplimientoContrato;
        this.calificacion = calificacion;
        this.observacionesE = observacionesE;
        this.recomentar = recomentar;
        this.idUsuario = idUsuario;
    }

    public Integer getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public boolean getCumplimientoContrato() {
        return cumplimientoContrato;
    }

    public void setCumplimientoContrato(boolean cumplimientoContrato) {
        this.cumplimientoContrato = cumplimientoContrato;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservacionesE() {
        return observacionesE;
    }

    public void setObservacionesE(String observacionesE) {
        this.observacionesE = observacionesE;
    }

    public boolean getRecomentar() {
        return recomentar;
    }

    public void setRecomentar(boolean recomentar) {
        this.recomentar = recomentar;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Evaluacion)) {
            return false;
        }
        Evaluacion other = (Evaluacion) object;
        if ((this.idEvaluacion == null && other.idEvaluacion != null) || (this.idEvaluacion != null && !this.idEvaluacion.equals(other.idEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Evaluacion[ idEvaluacion=" + idEvaluacion + " ]";
    }
    
}
