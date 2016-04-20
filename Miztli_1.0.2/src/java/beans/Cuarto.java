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
import javax.persistence.Lob;
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
@Table(name = "cuarto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuarto.findAll", query = "SELECT c FROM Cuarto c"),
    @NamedQuery(name = "Cuarto.findByIdCuarto", query = "SELECT c FROM Cuarto c WHERE c.idCuarto = :idCuarto"),
    @NamedQuery(name = "Cuarto.findByPrecio", query = "SELECT c FROM Cuarto c WHERE c.precio = :precio"),
    @NamedQuery(name = "Cuarto.findByObservacionesC", query = "SELECT c FROM Cuarto c WHERE c.observacionesC = :observacionesC")})
public class Cuarto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuarto")
    private Integer idCuarto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @Lob
    @Column(name = "foto_c")
    private byte[] fotoC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "observaciones_c")
    private String observacionesC;

    public Cuarto() {
    }

    public Cuarto(Integer idCuarto) {
        this.idCuarto = idCuarto;
    }

    public Cuarto(Integer idCuarto, int precio, String observacionesC) {
        this.idCuarto = idCuarto;
        this.precio = precio;
        this.observacionesC = observacionesC;
    }

    public Integer getIdCuarto() {
        return idCuarto;
    }

    public void setIdCuarto(Integer idCuarto) {
        this.idCuarto = idCuarto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public byte[] getFotoC() {
        return fotoC;
    }

    public void setFotoC(byte[] fotoC) {
        this.fotoC = fotoC;
    }

    public String getObservacionesC() {
        return observacionesC;
    }

    public void setObservacionesC(String observacionesC) {
        this.observacionesC = observacionesC;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuarto != null ? idCuarto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuarto)) {
            return false;
        }
        Cuarto other = (Cuarto) object;
        if ((this.idCuarto == null && other.idCuarto != null) || (this.idCuarto != null && !this.idCuarto.equals(other.idCuarto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Cuarto[ idCuarto=" + idCuarto + " ]";
    }
    
}
