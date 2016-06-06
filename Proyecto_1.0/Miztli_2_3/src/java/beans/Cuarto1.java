/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import logic.CuartoHelper;
import logic.HibernateUtil;
import org.hibernate.Session;

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
@ManagedBean
@SessionScoped
public class Cuarto1 implements Serializable {
    private CuartoHelper chelper;
    private HibernateUtil helper;
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
    FacesContext faceContext;
    HttpServletRequest httpServletRequest;
    private String delegacionC;
    private int codigoPostalC;
    private String coloniaC;
    private String calleC;
    private String telP;
    private String correoP;
    private Session session;
    private String nombrePrestador;
    public Cuarto1() {
       // faceContext = FacesContext.getCurrentInstance();
       // httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
       
       // System.out.println(chelper.getCuartos());
    }

    public Cuarto1(Integer idCuarto) {
        this.idCuarto = idCuarto;
       
        
    }

    public Cuarto1(Integer idCuarto, int precio, String observacionesC) {
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
    public void setNombrePrestador(String nom){
        this.nombrePrestador = nom;
    }
    
    public String getNombrePrestador(){
       return nombrePrestador;
    }
    
    public void setCorreoPrestador(String corr){
        this.correoP = corr;
    }
    
    public String getCorreoPrestador(){
       return correoP;
    }
    
    public void setTelefonoPrestador(String tel){
        this.telP = tel;
    }
    
    public String getTelefonoPrestador(){
       return telP;
    }
    
    public String getInfo(Modelo1.Cuarto idc) {
        System.out.println(idc);
        chelper = new CuartoHelper();
        //Modelo1.Cuarto ct = chelper.getCuartoPorId(1);
        //Modelo1.TieneDireccionC tdc = chelper.getTieneDirCuarto(idc.getIdCuarto());
        Modelo1.DireccionCuarto c = chelper.getDirCuarto(idc.getIdCuarto());
        Modelo1.Prestador ps = chelper.getPrestadorPorCuarto(idc.getIdCuarto());
        this.setNombrePrestador(ps.getNombre()+" "+ps.getApellidoPaterno()+" "+ps.getApellidoMaterno());
        this.setCorreoPrestador(ps.getCorreo());
        this.setTelefonoPrestador(ps.getTelefono());
        this.setIdCuarto(idc.getIdCuarto());
        this.setPrecio(idc.getPrecio());
        this.setObservacionesC(idc.getObservacionesC());
        this.setDelegacionC(c.getDelegacionC()+"");
        this.setCodigoPostalC(c.getCodigoPostalC());
        this.setColoniaC(c.getColoniaC());
        this.setCalleC(c.getCalleC());
        return "InfoCuarto.xhtml";
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
    
     public String atras() {
        return "PrincipalUsuario.xhtm";
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
    
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public byte[] getFotoC() {
        return fotoC;
    }
    
    public String getDireccionCC(Integer id){
//        session = helper.getSessionFactory().openSession();
//        session.beginTransaction();
//        d = (DireccionCuarto) session.get(DireccionCuarto.class, id);
//        c = (Cuarto) session.get(Cuarto.class, id);
//        if(d != null && c != null){
//            this.delegacionC = d.getDelegacionC();
//            this.codigoPostalC = d.getCodigoPostalC();
//            this.coloniaC = d.getColoniaC();
//            this.calleC = d.getCalleC();
//            this.precio = c.getPrecio();
//            this.observacionesC = c.getObservacionesC();
//            return "Modificar";
//        }else{
//            FacesContext.getCurrentInstance().addMessage(null,
//            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Id incorrecto", null));
//        }
       return "EditarCuarto";
    }
    
    
      //@SuppressWarnings("empty-statement")
    public List<Modelo1.Cuarto> listaCuartos() {
      //return Arrays.asList("sup1", "sup2", "sup3");
      chelper= new CuartoHelper();
      return chelper.getCuartos();
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

//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Cuarto)) {
//            return false;
//        }
//        Cuarto other = (Cuarto) object;
//         @Override
//    public if ((this.idCuarto == null && other.idCuarto != null) || (this.idCuarto != null && !this.idCuarto.equals(other.idCuarto))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "beans.Cuarto[ idCuarto=" + idCuarto + " ]";
    }
    
    
}
