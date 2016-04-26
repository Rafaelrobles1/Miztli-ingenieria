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
@Table(name = "tiene_direccion_c")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TieneDireccionC.findAll", query = "SELECT t FROM TieneDireccionC t"),
    @NamedQuery(name = "TieneDireccionC.findByCuarto", query = "SELECT t FROM TieneDireccionC t WHERE t.cuarto = :cuarto")})
public class TieneDireccionC1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuarto")
    private Integer cuarto;
    @JoinColumn(name = "direccion_c", referencedColumnName = "id_direccion_c")
    @ManyToOne(optional = false)
    private DireccionCuarto1 direccionC;

    public TieneDireccionC1() {
    }

    public TieneDireccionC1(Integer cuarto) {
        this.cuarto = cuarto;
    }

    public Integer getCuarto() {
        return cuarto;
    }

    public void setCuarto(Integer cuarto) {
        this.cuarto = cuarto;
    }

    public DireccionCuarto1 getDireccionC() {
        return direccionC;
    }

    public void setDireccionC(DireccionCuarto1 direccionC) {
        this.direccionC = direccionC;
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
        if (!(object instanceof TieneDireccionC1)) {
            return false;
        }
        TieneDireccionC1 other = (TieneDireccionC1) object;
        if ((this.cuarto == null && other.cuarto != null) || (this.cuarto != null && !this.cuarto.equals(other.cuarto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.TieneDireccionC[ cuarto=" + cuarto + " ]";
    }
    
}
