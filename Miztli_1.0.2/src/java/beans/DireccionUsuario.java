/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author salador
 */
@Entity
@Table(name = "direccion_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DireccionUsuario.findAll", query = "SELECT d FROM DireccionUsuario d"),
    @NamedQuery(name = "DireccionUsuario.findByIdDireccionU", query = "SELECT d FROM DireccionUsuario d WHERE d.idDireccionU = :idDireccionU"),
    @NamedQuery(name = "DireccionUsuario.findByPaisU", query = "SELECT d FROM DireccionUsuario d WHERE d.paisU = :paisU"),
    @NamedQuery(name = "DireccionUsuario.findByEstadoU", query = "SELECT d FROM DireccionUsuario d WHERE d.estadoU = :estadoU"),
    @NamedQuery(name = "DireccionUsuario.findByDelegacionU", query = "SELECT d FROM DireccionUsuario d WHERE d.delegacionU = :delegacionU"),
    @NamedQuery(name = "DireccionUsuario.findByCodigoPostalU", query = "SELECT d FROM DireccionUsuario d WHERE d.codigoPostalU = :codigoPostalU"),
    @NamedQuery(name = "DireccionUsuario.findByCalleU", query = "SELECT d FROM DireccionUsuario d WHERE d.calleU = :calleU"),
    @NamedQuery(name = "DireccionUsuario.findByColoniaU", query = "SELECT d FROM DireccionUsuario d WHERE d.coloniaU = :coloniaU")})
public class DireccionUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_direccion_u")
    private Integer idDireccionU;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pais_u")
    private String paisU;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado_u")
    private String estadoU;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "delegacion_u")
    private String delegacionU;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_postal_u")
    private int codigoPostalU;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "calle_u")
    private String calleU;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "colonia_u")
    private String coloniaU;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "direccion")
    private List<TieneDireccionU> tieneDireccionUList;

    public DireccionUsuario() {
    }

    public DireccionUsuario(Integer idDireccionU) {
        this.idDireccionU = idDireccionU;
    }

    public DireccionUsuario(Integer idDireccionU, String paisU, String estadoU, String delegacionU, int codigoPostalU, String calleU, String coloniaU) {
        this.idDireccionU = idDireccionU;
        this.paisU = paisU;
        this.estadoU = estadoU;
        this.delegacionU = delegacionU;
        this.codigoPostalU = codigoPostalU;
        this.calleU = calleU;
        this.coloniaU = coloniaU;
    }

    public Integer getIdDireccionU() {
        return idDireccionU;
    }

    public void setIdDireccionU(Integer idDireccionU) {
        this.idDireccionU = idDireccionU;
    }

    public String getPaisU() {
        return paisU;
    }

    public void setPaisU(String paisU) {
        this.paisU = paisU;
    }

    public String getEstadoU() {
        return estadoU;
    }

    public void setEstadoU(String estadoU) {
        this.estadoU = estadoU;
    }

    public String getDelegacionU() {
        return delegacionU;
    }

    public void setDelegacionU(String delegacionU) {
        this.delegacionU = delegacionU;
    }

    public int getCodigoPostalU() {
        return codigoPostalU;
    }

    public void setCodigoPostalU(int codigoPostalU) {
        this.codigoPostalU = codigoPostalU;
    }

    public String getCalleU() {
        return calleU;
    }

    public void setCalleU(String calleU) {
        this.calleU = calleU;
    }

    public String getColoniaU() {
        return coloniaU;
    }

    public void setColoniaU(String coloniaU) {
        this.coloniaU = coloniaU;
    }

    @XmlTransient
    public List<TieneDireccionU> getTieneDireccionUList() {
        return tieneDireccionUList;
    }

    public void setTieneDireccionUList(List<TieneDireccionU> tieneDireccionUList) {
        this.tieneDireccionUList = tieneDireccionUList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccionU != null ? idDireccionU.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionUsuario)) {
            return false;
        }
        DireccionUsuario other = (DireccionUsuario) object;
        if ((this.idDireccionU == null && other.idDireccionU != null) || (this.idDireccionU != null && !this.idDireccionU.equals(other.idDireccionU))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.DireccionUsuario[ idDireccionU=" + idDireccionU + " ]";
    }
    
}
