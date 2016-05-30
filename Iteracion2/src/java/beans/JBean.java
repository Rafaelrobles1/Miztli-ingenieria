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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
//import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logic.HibernateUtil;
import Modelo1.Cuarto;
import org.hibernate.Session;


/**
 *
 * @author seneck
 */
@Named(value = "jSFManagedBean")
//@SessionScoped
@RequestScoped
@ManagedBean
public class JBean implements Serializable {
    
    private HibernateUtil helper;
    private Session session;
    
    private DireccionCuarto d;
    private Cuarto c;
    private int id;
    
    private int idNew;
    private List<Integer> ids;
    
    private String delegacionC;
    private String codigoPostalC;///////Cambios
    private String coloniaC;
    private String calleC;
    private String precio; //////////Cambios
    private String observacionesC;
    
    ///////////////////////////////////////
    
    
         
    
    //////////////////////////////////////
    
    public JBean() {
    }
    
  

    public List<Integer> getIds(){
        return ids;
    }

    public void setIds(List<Integer> ids){
        this.ids = ids;
    }
    
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public String getDelegacionC() {
        return delegacionC;
    }

    public void setDelegacionC(String delegacionC) {
        this.delegacionC = delegacionC;
    }

    public String getCodigoPostalC() {///////////
        return codigoPostalC;
    }

    public void setCodigoPostalC(String codigoPostalC) {//////////////7
        this.codigoPostalC = codigoPostalC;
    }

    public String getColoniaC() {
        return coloniaC;
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

    public String getPrecio() {///////////
        return precio;
    }

    public void setPrecio(String precio) {//////////
        this.precio = precio;
    }

    public String getObservacionesC() {
        return observacionesC;
    }

    public void setObservacionesC(String observacionesC) {
        this.observacionesC = observacionesC;
    }
    
    @PostConstruct
    public void initI(){
        ids = new ArrayList<>();
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        for(int i = 1; i<50;i++){
            c = (Cuarto) session.get(Cuarto.class, i);
            if(c != null){
                ids.add(i);
            }
        }
        session.getTransaction().commit();
        session.close();
    }
    
    public String CrearCuarto(){
        idNew = 1;
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        c = (Cuarto) session.get(Cuarto.class, idNew);
        while(c != null){
            idNew++;
            c = (Cuarto) session.get(Cuarto.class, idNew);
        }
        
        d = new DireccionCuarto(idNew, delegacionC, Integer.parseInt(codigoPostalC), coloniaC, calleC);
        c = new Cuarto(idNew, Integer.parseInt(precio), observacionesC);
        if(d != null && c != null){
            session.save(d);
            session.save(c);
            session.getTransaction().commit();
            session.close();
            mensaje();
            return "prestador";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Datos incorrectos", null));
            return "crearCuarto";
        }
       
    }
    
    public String selecnEliminar(){
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        d = (DireccionCuarto) session.get(DireccionCuarto.class, id);
        c = (Cuarto) session.get(Cuarto.class, id);
        if(d != null && c != null){
            this.delegacionC = d.getDelegacionC();
            this.codigoPostalC = Integer.toString(d.getCodigoPostalC());
            this.coloniaC = d.getColoniaC();
            this.calleC = d.getCalleC();
            this.precio = Integer.toString(c.getPrecio());
            this.observacionesC = c.getObservacionesC();
            return "eliminarC";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Id incorrecto", null));
        }
        return "EditarCuarto";
    }
    
    public String eliminarCuarto(){////pasa como parametro un entero y en el mensaje de error imprimero
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        d = (DireccionCuarto) session.get(DireccionCuarto.class, id);
        c = (Cuarto) session.get(Cuarto.class, id);
        //TieneDireccionC t =(TieneDireccionC) session.get(TieneDireccionC.class, id);
        if(d != null && c != null){
            //session.delete(t);
            session.delete(d);
            session.delete(c);
            
            session.getTransaction().commit();
            session.close();
            mensajeConfElim();
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar cuarto "+id, null));
            return "editarCuarto";
        }
        
        return "prestador";
    }
    
    public String selecModificar(){
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        d = (DireccionCuarto) session.get(DireccionCuarto.class, id);
        c = (Cuarto) session.get(Cuarto.class, id);
        if(d != null && c != null){
            this.delegacionC = d.getDelegacionC();
            this.codigoPostalC = Integer.toString(d.getCodigoPostalC());
            this.coloniaC = d.getColoniaC();
            this.calleC = d.getCalleC();
            this.precio = Integer.toString(c.getPrecio());
            this.observacionesC = c.getObservacionesC();
            return "modificarC";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Id incorrecto", null));
        }
        return "editarCuarto";
    }
    
    public String modifC(){
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
         d = new DireccionCuarto(id, delegacionC, Integer.parseInt(codigoPostalC), coloniaC, calleC);
        c = new Cuarto(id, Integer.parseInt(precio), observacionesC);
        if(d != null && c != null){
            session.update(d);
            session.update(c);
            session.getTransaction().commit();
            session.close();
            mensajeConfModif();
            return "prestador";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al modificar cuarto "+id, null));
            return "editarCuarto";
        }
    }
    
    public String verInfoCuarto(){
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        d = (DireccionCuarto) session.get(DireccionCuarto.class, id);
        c = (Cuarto) session.get(Cuarto.class, id);
        if(d != null && c != null){
            this.delegacionC = d.getDelegacionC();
            this.codigoPostalC = Integer.toString(d.getCodigoPostalC());
            this.coloniaC = d.getColoniaC();
            this.calleC = d.getCalleC();
            this.precio = Integer.toString(c.getPrecio());
            this.observacionesC = c.getObservacionesC();
            return "verInfCuarto";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Id incorrecto", null));
        }
        return "cuartosEstudiante";
    }
    
    public String verInfoCuartoP(){
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        d = (DireccionCuarto) session.get(DireccionCuarto.class, id);
        c = (Cuarto) session.get(Cuarto.class, id);
        if(d != null && c != null){
            this.delegacionC = d.getDelegacionC();
            this.codigoPostalC = Integer.toString(d.getCodigoPostalC());
            this.coloniaC = d.getColoniaC();
            this.calleC = d.getCalleC();
            this.precio = Integer.toString(c.getPrecio());
            this.observacionesC = c.getObservacionesC();
            return "verInfCuartoP";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Id incorrecto", null));
        }
        return "cuartosP";
    }
    
    public void mensaje() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Cuarto "+ idNew + " Creado"));
    }
    
    public void mensajeConfElim(){
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Cuarto "+id+" Eliminado"));
    }
    
    public void mensajeConfModif(){
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Cuarto "+id+ " Modificado"));
    }
    
}
