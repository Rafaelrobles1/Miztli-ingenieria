/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
import logic.HibernateUtil;
import org.hibernate.Session;

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
@ManagedBean
@SessionScoped
public class Estudiante1 implements Serializable {
    private static final long serialVersionUID = 1L;
    Session session;
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
    private List<TieneContratoU1> tieneContratoUList;
    String contrasenyav;
    String paisU;
    String estadoU;
    String delegacionU;
    String CodigoPostalU;
    String coloniaU;
    String calleU;

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

    public String getCodigoPostalU() {
        return CodigoPostalU;
    }

    public void setCodigoPostalU(String CodigoPostalU) {
        this.CodigoPostalU = CodigoPostalU;
    }

    public String getColoniaU() {
        return coloniaU;
    }

    public void setColoniaU(String coloniaU) {
        this.coloniaU = coloniaU;
    }

    public String getCalleU() {
        return calleU;
    }

    public void setCalleU(String calleU) {
        this.calleU = calleU;
    }
    public Estudiante1() {
    }

    public Estudiante1(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Estudiante1(Integer idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String telefono, String contrasenya, String facultad, String carrera) {
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
    
     public String regPrestador() {
        return "RegistroPrestador.xhtml";
    }
     
    public String getContrasenyav() {
        return contrasenyav;
    }
    
     public void setContrasenyav(String a) {
        this.contrasenyav = a;
    }

    public String regEstudiante() {
        return "RegistroEstudiante.xhtml";
    }
    
    public  String cryptMD5(String textoPlano){
     char[] HEXADECIMALES = { '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f' };
     try{
    
       MessageDigest msgdgt = MessageDigest.getInstance("MD5");
       byte[] bytes = msgdgt.digest(textoPlano.getBytes());
       StringBuilder strCryptMD5 = new StringBuilder(2 * bytes.length);
       for (int i = 0; i < bytes.length; i++)
       {
           int low = (int)(bytes[i] & 0x0f);
           int high = (int)((bytes[i] & 0xf0) >> 4);
           strCryptMD5.append(HEXADECIMALES[high]);
           strCryptMD5.append(HEXADECIMALES[low]);
       }
          return strCryptMD5.toString();
    } catch (NoSuchAlgorithmException e) {
       return null;
    }
  }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @XmlTransient
    public List<TieneContratoU1> getTieneContratoUList() {
        return tieneContratoUList;
    }

    public void setTieneContratoUList(List<TieneContratoU1> tieneContratoUList) {
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
        if (!(object instanceof Estudiante1)) {
            return false;
        }
        Estudiante1 other = (Estudiante1) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Estudiante[ idUsuario=" + idUsuario + " ]";
    }
    
    public String registrar() {
        int idNew =200;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Modelo1.Estudiante c = (Modelo1.Estudiante) session.get(Modelo1.Estudiante.class, idNew);
        while(c != null){
            idNew++;
            c = (Modelo1.Estudiante) session.get(Modelo1.Estudiante.class, idNew);
        }
        this.idUsuario =idNew;
         Modelo1.Estudiante e = new Modelo1.Estudiante(this.idUsuario,this.nombre,this.apellidoPaterno,this.apellidoMaterno, this.correo,this.telefono,null,cryptMD5(this.contrasenya),this.facultad,this.carrera,null);
        if(e != null){
            session.save(e);
            session.getTransaction().commit();
            session.close();
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Datos incorrectos", null));
            return "RegistroEstudiante";
        }
    
        return "RegistroDireccion.xhtml";
    }
    public String registrarD() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Modelo1.DireccionUsuario e = new Modelo1.DireccionUsuario(this.idUsuario, this.paisU,this.estadoU,this.delegacionU,Integer.parseInt(this.CodigoPostalU),this.calleU,this.coloniaU);
        if(e != null){
            session.save(e);
            session.getTransaction().commit();
            session.close();
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Datos incorrectos", null));
            return "RegistroEstudiante";
        }
    
        return "Principal.xhtml";
    }
}
