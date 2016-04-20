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
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByIdUsuario", query = "SELECT e FROM Estudiante e WHERE e.idUsuario = :idUsuario"),
    @NamedQuery(name = "Estudiante.findByNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estudiante.findByApellidoPaterno", query = "SELECT e FROM Estudiante e WHERE e.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Estudiante.findByApellidoMaterno", query = "SELECT e FROM Estudiante e WHERE e.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Estudiante.findByCorreo", query = "SELECT e FROM Estudiante e WHERE e.correo = :correo"),
    @NamedQuery(name = "Estudiante.findByTelefono", query = "SELECT e FROM Estudiante e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Estudiante.findByContrasenya", query = "SELECT e FROM Estudiante e WHERE e.contrasenya = :contrasenya"),
    @NamedQuery(name = "Estudiante.findByFacultad", query = "SELECT e FROM Estudiante e WHERE e.facultad = :facultad"),
    @NamedQuery(name = "Estudiante.findByCarrera", query = "SELECT e FROM Estudiante e WHERE e.carrera = :carrera")})
public class Estudiante implements Serializable {
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
    @Size(min = 1, max = 50)
    @Column(name = "facultad")
    private String facultad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "carrera")
    private String carrera;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private List<TieneContratoU> tieneContratoUList;

    public Estudiante() {
    }

    public Estudiante(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Estudiante(Integer idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String telefono, String contrasenya, String facultad, String carrera) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasenya = contrasenya;
        this.facultad = facultad;
        this.carrera = carrera;
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

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
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
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Estudiante[ idUsuario=" + idUsuario + " ]";
    }
    
}
