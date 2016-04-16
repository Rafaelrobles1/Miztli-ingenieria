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
@Table(name = "tiene_direccion_u")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TieneDireccionU.findAll", query = "SELECT t FROM TieneDireccionU t"),
    @NamedQuery(name = "TieneDireccionU.findByUsuario", query = "SELECT t FROM TieneDireccionU t WHERE t.usuario = :usuario")})
public class TieneDireccionU implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario")
    private Integer usuario;
    @JoinColumn(name = "direccion", referencedColumnName = "id_direccion_u")
    @ManyToOne(optional = false)
    private DireccionUsuario direccion;

    public TieneDireccionU() {
    }

    public TieneDireccionU(Integer usuario) {
        this.usuario = usuario;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public DireccionUsuario getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionUsuario direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TieneDireccionU)) {
            return false;
        }
        TieneDireccionU other = (TieneDireccionU) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.TieneDireccionU[ usuario=" + usuario + " ]";
    }
    
}
