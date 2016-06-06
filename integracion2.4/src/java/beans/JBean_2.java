
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Modelo1.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logic.HibernateUtil;
import logic.MiLoginHelper;

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
    private MiLoginHelper helper1;
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
    
    private String ruta="/home/salador/Documentos/Ing s/archivo.txt";
    int IdSession=0;
    Modelo1.Prestador Upres; 
    Modelo1.DireccionUsuario Dir;
    //////////////////////////////////////
    public JBean_2() {
        carga();
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
        carga();
        this.idUsuario = idUsuario;
    }
    
     public void CargaNum(){
    String cadena=null;
        BufferedReader b=null;
        FileReader f;
            try {
                f = new FileReader(ruta); 
                b = new BufferedReader(f);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JBean_1.class.getName()).log(Level.SEVERE, null, ex);
            }
       
            try {
                cadena = b.readLine();
            } catch (IOException ex) {
                Logger.getLogger(JBean_1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                b.close();
            } catch (IOException ex) {
                Logger.getLogger(JBean_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        helper1 = new MiLoginHelper();
        IdSession=Integer.parseInt(cadena);
    
    }
    
     public void carga(){
    String cadena=null;
        BufferedReader b=null;
        FileReader f;
            try {
                f = new FileReader(ruta); 
                b = new BufferedReader(f);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JBean_1.class.getName()).log(Level.SEVERE, null, ex);
            }
       
            try {
                cadena = b.readLine();
            } catch (IOException ex) {
                Logger.getLogger(JBean_1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                b.close();
            } catch (IOException ex) {
                Logger.getLogger(JBean_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        helper1 = new MiLoginHelper();
        IdSession=Integer.parseInt(cadena);
        Upres = helper1.getLoginPorPrestador(IdSession);
        Dir=helper1.getLoginPorDireccion(IdSession);
        idUsuario=Upres.getIdUsuario();
        nombre=Upres.getNombre();
        
        apellidoPaterno=Upres.getApellidoPaterno();
        apellidoMaterno=Upres.getApellidoMaterno();
        correo=Upres.getCorreo();
        telefono=Upres.getTelefono();
        
       
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

    

    public String eliminarUsuario() {
        
        CargaNum();
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        Prestador p1 =(Prestador)session.get(Prestador.class, IdSession);
        Cuarto aux_cuarto;
        TieneCuarto aux_t_cuarto;
        TieneDireccionC aux_dir;
        DireccionCuarto aux_dir_c;
        Contrato aux_contra;
        TieneContratoU aux_t_contra;
        Calificacion aux_cali=(Calificacion) session.get(Calificacion.class, p1.getIdUsuario());
        
        if(aux_cali!=null){
            session.delete(aux_cali);
        }
        
        for(int i=1;i<100;i++){
        
          aux_t_cuarto=(TieneCuarto) session.get(TieneCuarto.class,i);
          if(aux_t_cuarto!=null){
           if(aux_t_cuarto.getPrestador()==p1.getIdUsuario()){
               aux_cuarto=(Cuarto) session.get(Cuarto.class,aux_t_cuarto.getCuarto());
               aux_dir=(TieneDireccionC) session.get(TieneDireccionC.class,aux_t_cuarto.getCuarto());
               aux_dir_c=(DireccionCuarto) session.get(DireccionCuarto.class,aux_t_cuarto.getCuarto());
               
             if(aux_dir!=null){
                   session.delete(aux_dir);
             }
               session.delete(aux_t_cuarto);
               session.delete(aux_dir_c);
               session.delete(aux_cuarto);
               
            }
           
           aux_t_contra=(TieneContratoU) session.get(TieneContratoU.class,i);
           if(aux_t_contra!=null){
               if(aux_t_contra.getPrestador()==p1.getIdUsuario()){
                   aux_contra=(Contrato) session.get(Contrato.class,aux_t_contra.getContrato());
                   
                   session.delete(aux_t_contra);
                   if(aux_contra!=null){
                       session.delete(aux_contra);
                   }
               }
           }
           
              
          }
        }
          
        if ( p1 != null) {
            
            session.delete(p1);
            
            session.getTransaction().commit();
            session.close();
            mensajeConfElim();
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar Prestador " + id, null));
            return "principal";
        }

        return "principal";
    }


    
    public String modifC() throws NoSuchAlgorithmException {
        
        CargaNum();
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        Prestador p1 =(Prestador)session.get(Prestador.class, IdSession);
        
        if (p1 != null) {
            p1.setNombre(getNombre());
            p1.setApellidoMaterno(getApellidoMaterno());
            p1.setApellidoPaterno(getApellidoPaterno());
            p1.setTelefono(getTelefono());
            p1.setCorreo(getCorreo());
            
            
         } else {
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Id incorrecto", null));
            }
        
        
        if (p1 != null) {
            session.update(p1);
            session.getTransaction().commit();
            session.close();
            mensajeConfModif();
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al modificar usuario " + id, null));
            return "prestador";
        }
        return "prestador";
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
    return "principal";
        
    }

}
