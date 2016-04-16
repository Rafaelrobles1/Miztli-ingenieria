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
@Table(name = "direccion_cuarto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DireccionCuarto.findAll", query = "SELECT d FROM DireccionCuarto d"),
    @NamedQuery(name = "DireccionCuarto.findByIdDireccionC", query = "SELECT d FROM DireccionCuarto d WHERE d.idDireccionC = :idDireccionC"),
    @NamedQuery(name = "DireccionCuarto.findByDelegacionC", query = "SELECT d FROM DireccionCuarto d WHERE d.delegacionC = :delegacionC"),
    @NamedQuery(name = "DireccionCuarto.findByCodigoPostalC", query = "SELECT d FROM DireccionCuarto d WHERE d.codigoPostalC = :codigoPostalC"),
    @NamedQuery(name = "DireccionCuarto.findByColoniaC", query = "SELECT d FROM DireccionCuarto d WHERE d.coloniaC = :coloniaC"),
    @NamedQuery(name = "DireccionCuarto.findByCalleC", query = "SELECT d FROM DireccionCuarto d WHERE d.calleC = :calleC"),
    @NamedQuery(name = "DireccionCuarto.findByLinkUbicacion", query = "SELECT d FROM DireccionCuarto d WHERE d.linkUbicacion = :linkUbicacion")})
public class DireccionCuarto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_direccion_c")
    private Integer idDireccionC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "delegacion_c")
    private String delegacionC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_postal_c")
    private int codigoPostalC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "colonia_c")
    private String coloniaC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "calle_c")
    private String calleC;
    @Size(max = 2147483647)
    @Column(name = "link_ubicacion")
    private String linkUbicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "direccionC")
    private List<TieneDireccionC> tieneDireccionCList;

    public DireccionCuarto() {
    }

    public DireccionCuarto(Integer idDireccionC) {
        this.idDireccionC = idDireccionC;
    }

    public DireccionCuarto(Integer idDireccionC, String delegacionC, int codigoPostalC, String coloniaC, String calleC) {
        this.idDireccionC = idDireccionC;
        this.delegacionC = delegacionC;
        this.codigoPostalC = codigoPostalC;
        this.coloniaC = coloniaC;
        this.calleC = calleC;
    }

    public Integer getIdDireccionC() {
        return idDireccionC;
    }

    public void setIdDireccionC(Integer idDireccionC) {
        this.idDireccionC = idDireccionC;
    }

    public String getDelegacionC() {
        return delegacionC;
    }

    public void setDelegacionC(String delegacionC) {
        this.delegacionC = delegacionC;
    }

    public int getCodigoPostalC() {
        return codigoPostalC;
    }

    public void setCodigoPostalC(int codigoPostalC) {
        this.codigoPostalC = codigoPostalC;
    }

    public String getColoniaC() {
        return coloniaC;
    }

    public void setColoniaC(String coloniaC) {
        this.coloniaC = coloniaC;
    }

    public String getCalleC() {
        return calleC;
    }

    public void setCalleC(String calleC) {
        this.calleC = calleC;
    }

    public String getLinkUbicacion() {
        return linkUbicacion;
    }

    public void setLinkUbicacion(String linkUbicacion) {
        this.linkUbicacion = linkUbicacion;
    }

    @XmlTransient
    public List<TieneDireccionC> getTieneDireccionCList() {
        return tieneDireccionCList;
    }

    public void setTieneDireccionCList(List<TieneDireccionC> tieneDireccionCList) {
        this.tieneDireccionCList = tieneDireccionCList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccionC != null ? idDireccionC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionCuarto)) {
            return false;
        }
        DireccionCuarto other = (DireccionCuarto) object;
        if ((this.idDireccionC == null && other.idDireccionC != null) || (this.idDireccionC != null && !this.idDireccionC.equals(other.idDireccionC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.DireccionCuarto[ idDireccionC=" + idDireccionC + " ]";
    }
    
}
