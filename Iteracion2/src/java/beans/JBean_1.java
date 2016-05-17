/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Modelo1.*;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logic.HibernateUtil;

import org.hibernate.Session;

/**
 *
 * @author seneck
 */
@Named(value = "jSFManagedBean_1")
@SessionScoped
//@RequestScoped
@ManagedBean
public class JBean_1 implements Serializable {

    private HibernateUtil helper;
    private Session session;

    private Usuario u;
    private Estudiante e;
    private DireccionUsuario d;
    private TieneContratoU con;
    private int id;

    private int idNew;
    private List<Integer> ids;

    private int idUsuario;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String telefono;
    private String contrasenya;

    private String facultad;
    private String carrera;

    //////////////////////////////////////
    
    private int idDireccionU;
     private String paisU;
     private String estadoU;
     private String delegacionU;
     private int codigoPostalU;
     private String calleU;
     private String coloniaU;
    public JBean_1() {
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenya() {
        return this.contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
    ////////////////////////////////////////

    public String getFacultad() {
        return this.facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCarrera() {
        return this.carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /////////////////////////////////////////
    
    public int getIdDireccionU() {
        return this.idDireccionU;
    }
    
    public void setIdDireccionU(int idDireccionU) {
        this.idDireccionU = idDireccionU;
    }
    public String getPaisU() {
        return this.paisU;
    }
    
    public void setPaisU(String paisU) {
        this.paisU = paisU;
    }
    public String getEstadoU() {
        return this.estadoU;
    }
    
    public void setEstadoU(String estadoU) {
        this.estadoU = estadoU;
    }
    public String getDelegacionU() {
        return this.delegacionU;
    }
    
    public void setDelegacionU(String delegacionU) {
        this.delegacionU = delegacionU;
    }
    public int getCodigoPostalU() {
        return this.codigoPostalU;
    }
       public void setCodigoPostalU(int codigoPostalU) {
        this.codigoPostalU = codigoPostalU;
    }
     
    public String getCalleU() {
        return this.calleU;
    }
    
    public void setCalleU(String calleU) {
        this.calleU = calleU;
    }
    public String getColoniaU() {
        return this.coloniaU;
    }
    
    public void setColoniaU(String coloniaU) {
        this.coloniaU = coloniaU;
    }

    /////////////////////////////////////////
    @PostConstruct
    public void initI() {
        ids = new ArrayList<>();
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();

        u = (Usuario) session.get(Usuario.class, idUsuario);
        e = (Estudiante) session.get(Estudiante.class, idUsuario);
  d =(DireccionUsuario) session.get(DireccionUsuario.class, idDireccionU);
        session.getTransaction().commit();
        session.close();
        
    }

    public String selecnEliminar() {
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        u = (Usuario) session.get(Usuario.class, idUsuario);
        e = (Estudiante) session.get(Estudiante.class, idUsuario);
         d=(DireccionUsuario) session.get(DireccionUsuario.class, idUsuario);
        if (u != null && e != null) {
            this.nombre=e.getNombre();
            this.idUsuario = e.getIdUsuario();
            this.apellidoMaterno = e.getApellidoMaterno();
            this.apellidoPaterno = e.getApellidoPaterno();
            this.carrera = e.getCarrera();
            this.correo = e.getCorreo();
            this.facultad = e.getFacultad();
            this.telefono = e.getTelefono();
             this.paisU=d.getPaisU();
            this.estadoU=d.getEstadoU();
            this.delegacionU=d.getDelegacionU();
            this.codigoPostalU=d.getCodigoPostalU();
            this.calleU=d.getCalleU();
            this.coloniaU=d.getColoniaU();
            
            
            return "Eliminar_Estudiante";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Id incorrecto", null));
        }
        return "Principal";
    }

    public String eliminarUsuario() {////pasa como parametro un entero y en el mensaje de error imprimero
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
       
        e = (Estudiante) session.get(Estudiante.class, idUsuario);
         d=(DireccionUsuario) session.get(DireccionUsuario.class, idUsuario);
        if (u != null && e != null) {
            session.delete(e);
       
            session.delete(d);
            session.getTransaction().commit();
            session.close();
            mensajeConfElim();
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar cuarto " + id, null));
            return "Principal";
        }

        return "Principal";
    }

    public String selecModificar() {
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
         u = (Usuario) session.get(Usuario.class, idUsuario);
        e = (Estudiante) session.get(Estudiante.class, idUsuario);
         d=(DireccionUsuario) session.get(DireccionUsuario.class, idUsuario);
        if (u != null && e != null) {
            this.nombre=e.getNombre();
            this.idUsuario = e.getIdUsuario();
            this.apellidoMaterno = e.getApellidoMaterno();
            this.apellidoPaterno = e.getApellidoPaterno();
            this.carrera = e.getCarrera();
            this.correo = e.getCorreo();
            this.facultad = e.getFacultad();
            this.telefono = e.getTelefono();
             this.paisU=d.getPaisU();
            this.estadoU=d.getEstadoU();
            this.delegacionU=d.getDelegacionU();
            this.codigoPostalU=d.getCodigoPostalU();
            this.calleU=d.getCalleU();
            this.coloniaU=d.getColoniaU();
            return "Modificar_Estudiante";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Id incorrecto", null));
        }
        return "Principal";
    }

    public String md5(String cadena) throws NoSuchAlgorithmException{
     MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(cadena.getBytes());
                byte[] digest = md.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b & 0xff));
                }
                return sb.toString();
    
    }
    public String modifC()  {
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        e =new Estudiante(idUsuario, nombre, apellidoPaterno, apellidoMaterno, correo, telefono, e.getContrasenya(), facultad, carrera);
        
        if (e != null) {
            session.update(e);
           
            session.getTransaction().commit();
            session.close();
            mensajeConfModif();
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al modificar cuarto " + id, null));
            return "Principal";
        }
        return "Principal";
    }

    public void mensaje() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Usuario " + idNew + " Creado"));
    }

    public void mensajeConfElim() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Usuario " + idUsuario + " Eliminado"));
    }

    public void mensajeConfModif() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Usuario Modificado"));
    }
    
    public String cancela(){
    return "Principal";
        
    }

//    public String CrearCuarto(){
//        idNew = 1;
//        session = helper.getSessionFactory().openSession();
//        session.beginTransaction();
//        c = (Cuarto) session.get(Cuarto.class, idNew);
//        while(c != null){
//            idNew++;
//            c = (Cuarto) session.get(Cuarto.class, idNew);
//        }
//        d = new DireccionCuarto(idNew, delegacionC, codigoPostalC, coloniaC, calleC);
//        c = new Cuarto(idNew, precio, observacionesC);
//        if(d != null && c != null){
//            session.save(d);
//            session.save(c);
//            session.getTransaction().commit();
//            session.close();
//            mensaje();
//        }else{
//            FacesContext.getCurrentInstance().addMessage(null,
//            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Datos incorrectos", null));
//            return "CrearCuarto";
//        }
//        return "PrincipalUsuarioPrestador";
//    }
}
