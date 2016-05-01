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
@ManagedBean
@SessionScoped
public class Prestador1 implements Serializable {
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
    private List<TieneCuarto1> tieneCuartoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prestador")
    private List<TieneContratoU1> tieneContratoUList;
    private String contrasenyav;
    private Session session;
     private String paisU;
     private String estadoU;
     private String delegacionU;
     private String CodigoPostalU;
     private String coloniaU;
     private String calleU;

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

    public Prestador1() {
    }

    public Prestador1(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Prestador1(Integer idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String telefono,String contrasenya, int cuartosDisponibles) {
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
    
    public String getContrasenyav() {
        return contrasenyav;
    }
    
     public void setContrasenyav(String a) {
        this.contrasenyav = a;
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
    public List<TieneCuarto1> getTieneCuartoList() {
        return tieneCuartoList;
    }

    public void setTieneCuartoList(List<TieneCuarto1> tieneCuartoList) {
        this.tieneCuartoList = tieneCuartoList;
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
        if (!(object instanceof Prestador1)) {
            return false;
        }
        Prestador1 other = (Prestador1) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

     public String registrar() {
        int idNew =100;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Modelo1.Prestador c = (Modelo1.Prestador) session.get(Modelo1.Prestador.class, idNew);
        while(c != null){
            idNew++;
            c = (Modelo1.Prestador) session.get(Modelo1.Prestador.class, idNew);
        }
        this.idUsuario =idNew;
         Modelo1.Prestador e = new Modelo1.Prestador(this.idUsuario,this.nombre,this.apellidoPaterno,this.apellidoMaterno, this.correo,this.telefono,cryptMD5(this.contrasenya),0);
        if(e != null){
            session.save(e);
            session.getTransaction().commit();
            session.close();
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Datos incorrectos", null));
            return "RegistroPrestador";
        }
    
        return "RegistroDireccionP.xhtml";
    }
    @Override
    public String toString() {
        return "beans.Prestador[ idUsuario=" + idUsuario + " ]";
    }
    
}
