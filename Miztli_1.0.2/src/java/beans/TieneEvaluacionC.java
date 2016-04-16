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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author salador
 */
@Entity
@Table(name = "tiene_evaluacion_c")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TieneEvaluacionC.findAll", query = "SELECT t FROM TieneEvaluacionC t"),
    @NamedQuery(name = "TieneEvaluacionC.findByEvaluacion", query = "SELECT t FROM TieneEvaluacionC t WHERE t.evaluacion = :evaluacion")})
public class TieneEvaluacionC implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluacion")
    private Integer evaluacion;
    @JoinColumn(name = "contrato", referencedColumnName = "id_contrato")
    @ManyToOne(optional = false)
    private Contrato contrato;

    public TieneEvaluacionC() {
    }

    public TieneEvaluacionC(Integer evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Integer getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Integer evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluacion != null ? evaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TieneEvaluacionC)) {
            return false;
        }
        TieneEvaluacionC other = (TieneEvaluacionC) object;
        if ((this.evaluacion == null && other.evaluacion != null) || (this.evaluacion != null && !this.evaluacion.equals(other.evaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.TieneEvaluacionC[ evaluacion=" + evaluacion + " ]";
    }
    
}
