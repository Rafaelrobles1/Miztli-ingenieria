
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
@Named(value = "jSFManagedBean_2")
@SessionScoped
//@RequestScoped
@ManagedBean
public class JBean_2 implements Serializable {

    private HibernateUtil helper;
    private Session session;

    private Usuario u;
    private TieneContratoU con;
    private Prestador p;
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


    //////////////////////////////////////
    public JBean_2() {
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

   
    /////////////////////////////////////////
    @PostConstruct
    public void initI() {
        ids = new ArrayList<>();
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();

        u = (Usuario) session.get(Usuario.class, idUsuario);
        p = (Prestador) session.get(Prestador.class, idUsuario);

        session.getTransaction().commit();
        session.close();
        
    }

    public String selecnEliminar() {
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        u = (Usuario) session.get(Usuario.class, idUsuario);
        p = (Prestador) session.get(Prestador.class, idUsuario);
        if (u != null && p != null) {
            this.nombre=p.getNombre();
            this.idUsuario = p.getIdUsuario();
            this.apellidoMaterno = p.getApellidoMaterno();
            this.apellidoPaterno = p.getApellidoPaterno();
            this.correo = p.getCorreo();
            this.telefono = p.getTelefono();
            
            return "Eliminar_Prestador";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Id incorrecto", null));
        }
        return "Principal";
    }

    public String eliminarUsuario() {////pasa como parametro un entero y en el mensaje de error imprimero
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        u = (Usuario) session.get(Usuario.class, idUsuario);
        p = (Prestador) session.get(Prestador.class, idUsuario);
        con=(TieneContratoU) session.get(TieneContratoU.class, 1);
        if (u != null && p != null) {
            
            session.delete(p);
            session.delete(u);
            session.delete(con);
           // session.getTransaction().commit();
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
        p = (Prestador) session.get(Prestador.class, idUsuario);
        if (u != null && p != null) {
            this.nombre=p.getNombre();
            this.idUsuario = p.getIdUsuario();
            this.apellidoMaterno = p.getApellidoMaterno();
            this.apellidoPaterno = p.getApellidoPaterno();
            this.correo = p.getCorreo();
            this.telefono = p.getTelefono();
            return "Modificar_Prestador";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Id incorrecto", null));
        }
        return "Principal";
    }

    
    public String modifC() throws NoSuchAlgorithmException {
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        p=new Prestador(idUsuario, nombre, apellidoPaterno, apellidoMaterno, correo, telefono, p.getContrasenya(), p.getCuartosDisponibles());
        //u= new Usuario(idUsuario, nombre, apellidoPaterno, apellidoMaterno, correo, telefono, contrasenya);
        if (p != null) {
            session.update(p);
           // session.update(u);
            session.getTransaction().commit();
            session.close();
            mensajeConfModif();
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al modificar usuario " + id, null));
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
