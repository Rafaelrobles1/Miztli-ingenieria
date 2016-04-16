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
import javax.persistence.Lob;
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
@Table(name = "prestador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestador.findAll", query = "SELECT p FROM Prestador p"),
    @NamedQuery(name = "Prestador.findByIdUsuario", query = "SELECT p FROM Prestador p WHERE p.idUsuario = :idUsuario"),
    @NamedQuery(name = "Prestador.findByNombre", query = "SELECT p FROM Prestador p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Prestador.findByApellidoPaterno", query = "SELECT p FROM Prestador p WHERE p.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Prestador.findByApellidoMaterno", query = "SELECT p FROM Prestador p WHERE p.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Prestador.findByCorreo", query = "SELECT p FROM Prestador p WHERE p.correo = :correo"),
    @NamedQuery(name = "Prestador.findByTelefono", query = "SELECT p FROM Prestador p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Prestador.findByContrasenya", query = "SELECT p FROM Prestador p WHERE p.contrasenya = :contrasenya"),
    @NamedQuery(name = "Prestador.findByCuartosDisponibles", query = "SELECT p FROM Prestador p WHERE p.cuartosDisponibles = :cuartosDisponibles")})
public class Prestador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefono")
    private String telefono;
    @Lob
    @Column(name = "foto_u")
    private byte[] fotoU;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "contrasenya")
    private String contrasenya;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuartos_disponibles")
    private int cuartosDisponibles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prestador")
    private List<TieneCuarto> tieneCuartoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prestador")
    private List<TieneContratoU> tieneContratoUList;

    public Prestador() {
    }

    public Prestador(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Prestador(Integer idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String telefono, String contrasenya, int cuartosDisponibles) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasenya = contrasenya;
        this.cuartosDisponibles = cuartosDisponibles;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public byte[] getFotoU() {
        return fotoU;
    }

    public void setFotoU(byte[] fotoU) {
        this.fotoU = fotoU;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public int getCuartosDisponibles() {
        return cuartosDisponibles;
    }

    public void setCuartosDisponibles(int cuartosDisponibles) {
        this.cuartosDisponibles = cuartosDisponibles;
    }

    @XmlTransient
    public List<TieneCuarto> getTieneCuartoList() {
        return tieneCuartoList;
    }

    public void setTieneCuartoList(List<TieneCuarto> tieneCuartoList) {
        this.tieneCuartoList = tieneCuartoList;
    }

    @XmlTransient
    public List<TieneContratoU> getTieneContratoUList() {
        return tieneContratoUList;
    }

    public void setTieneContratoUList(List<TieneContratoU> tieneContratoUList) {
        this.tieneContratoUList = tieneContratoUList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestador)) {
            return false;
        }
        Prestador other = (Prestador) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Prestador[ idUsuario=" + idUsuario + " ]";
    }
    
}
