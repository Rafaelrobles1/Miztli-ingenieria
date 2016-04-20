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
import logic.MiLoginHelper;
 
/**
 *
 * @author salador
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellidoPaterno", query = "SELECT u FROM Usuario u WHERE u.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Usuario.findByApellidoMaterno", query = "SELECT u FROM Usuario u WHERE u.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuario.findByContrasenya", query = "SELECT u FROM Usuario u WHERE u.contrasenya = :contrasenya")})
public class Usuario implements Serializable {
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

    private MiLoginHelper helper;
    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String telefono, String contrasenya) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasenya = contrasenya;
    }

    public String login1() {
                Modelo1.Usuario co = helper.getLoginPorCorreo(correo);
        if(co!=null){
            return "PrincipalUsuario";
        }
    return "Principal";
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
