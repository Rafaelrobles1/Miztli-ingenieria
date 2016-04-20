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
@Table(name = "tiene_cuarto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TieneCuarto.findAll", query = "SELECT t FROM TieneCuarto t"),
    @NamedQuery(name = "TieneCuarto.findByCuarto", query = "SELECT t FROM TieneCuarto t WHERE t.cuarto = :cuarto")})
public class TieneCuarto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuarto")
    private Integer cuarto;
    @JoinColumn(name = "prestador", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Prestador prestador;

    public TieneCuarto() {
    }

    public TieneCuarto(Integer cuarto) {
        this.cuarto = cuarto;
    }

    public Integer getCuarto() {
        return cuarto;
    }

    public void setCuarto(Integer cuarto) {
        this.cuarto = cuarto;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuarto != null ? cuarto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TieneCuarto)) {
            return false;
        }
        TieneCuarto other = (TieneCuarto) object;
        if ((this.cuarto == null && other.cuarto != null) || (this.cuarto != null && !this.cuarto.equals(other.cuarto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.TieneCuarto[ cuarto=" + cuarto + " ]";
    }
    
}
