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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
//import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logic.HibernateUtil;
import logic.MiLoginHelper;
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
    private Prestador p;
    private TieneCuarto tc;
    private int id;
    private TieneContratoU tcu;
    private Contrato contrato;
    private int idprest;
    private int estu1;
    private TieneCuarto t;
    private Estudiante estuCU;
    private int idNew;
    private List<Integer > ids;
    private List<Integer> idCuartos;
    private int calif;
    private String duenoC;
    private String delegacionC;
    private String codigoPostalC;///////Cambios
    private String coloniaC;
    private String calleC;
    private String precio; //////////Cambios
    private String observacionesC;
    private String yaCalif;
    private CalificacionEstudiante ce;
    private String estado;
     private String evalE;

    public int getIdprest() {
        return idprest;
    }

    public void setIdprest(int idprest) {
        this.idprest = idprest;
    }

    public int getCalif() {
        return calif;
    }

    public void setCalif(int calif) {
        this.calif = calif;
    }

    public String getYaCalif() {
        return yaCalif;
    }

    public void setYaCalif(String yaCalif) {
        this.yaCalif = yaCalif;
    }

    public int getEstu1() {
        return estu1;
    }

    public void setEstu1(int estu1) {
        this.estu1 = estu1;
    }

    public String getEvalE() {
        return evalE;
    }

    public void setEvalE(String evalE) {
        this.evalE = evalE;
    }
    private int recomendaciones;

    public int getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(int recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    ///////////////////////////////////////
    
    private String ruta="/home/salador/Documentos/Ing s/archivo.txt";
    private MiLoginHelper helper1;
    int IdSession=0;
    
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
    
    
    
    public void misCuartos(){
        CargaNum();
        idCuartos = new ArrayList<>();
         session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        for(int i = 1; i<50;i++){
            t = (TieneCuarto) session.get(TieneCuarto.class, i);
            if(t != null && t.getPrestador() == IdSession){
                idCuartos.add(t.getCuarto());
            }
        }
        session.getTransaction().commit();
        session.close();
    } 
         
    
    //////////////////////////////////////
    
    public JBean() {
    }

    public List<Integer> getIdCuartos() {
        return idCuartos;
    }

    public void setIdCuartos(List<Integer> idCuartos) {
        this.idCuartos = idCuartos;
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

     public void setDuenoC(String d){
         
        this.duenoC = d;
    }

    public String getDuenoC() {
        return duenoC;
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
        misCuartos();
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
        tc = new TieneCuarto(idNew,IdSession);
        if(d != null && c != null){
            session.save(d);
            session.save(c);
            session.save(tc);
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
    
    public String nombreCU(){
      idprest=estuCU.getIdUsuario();  
      return "  "+ estuCU.getNombre()+" "+estuCU.getApellidoMaterno()+" "+estuCU.getApellidoMaterno();
    }
    
    public String correoCU(){
       return estuCU.getCorreo()+"";
    }
    
     public int idCU(){
       
       return  estuCU.getIdUsuario();
    }
  
    public String califE(){
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        Contrato c1;
        TieneContratoU c2;
        for(int k=0;k<70;k++){
           c1 = (Contrato) session.get(Contrato.class,k);
           if(c1 !=null){
               if(c1.getIdCuarto()==id){
                 c2 = (TieneContratoU)session.get(TieneContratoU.class,c1.getIdContrato());
                 estu1 =c2.getEstudiante();
                 estuCU = (Estudiante) session.get(Estudiante.class,estu1);
                 return "calEst";
               }
           }     
        }
        session.getTransaction().commit();
        session.close();
        evalE="Esté cuarto no esta siendo rentado para poder evaluar";
        return "calificarEstudiante";
    
    }
    
      public String guardaCalif(){
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        TieneContratoU aux_tc=null;
        int i=1;
        while(i<100){
            aux_tc=(TieneContratoU)session.get(TieneContratoU.class,i);
            if(aux_tc!=null){
                if(aux_tc.getPrestador()==IdSession){
                    i=100;
                }
            }
            i++;
        }
       
        ce = (CalificacionEstudiante) session.get(CalificacionEstudiante.class, 
                aux_tc.getEstudiante());
        if(ce==null){
            ce = new CalificacionEstudiante(aux_tc.getEstudiante(),aux_tc.getEstudiante(),calif,1);
            session.save(ce);
        }else{
            ce.setSumP(ce.getSumP()+calif);
            ce.setNumE(ce.getNumE()+1);
            session.update(ce);
        }
           
        session.getTransaction().commit();
        session.close();
        evalE="Calificaste a este estudiante";
        return "calificarEstudiante";
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
        TieneCuarto t =(TieneCuarto) session.get(TieneCuarto.class, c.getIdCuarto());
        if(d != null && c != null){
            session.delete(t);
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
    
    private double califP;

    public double getCalifP() {
        
        return califP;
    }

    public void setCalifP(double califP) {
        this.califP = califP;
    }
    
    public String verInfoCuarto(){
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        d = (DireccionCuarto) session.get(DireccionCuarto.class, id);
        c = (Cuarto) session.get(Cuarto.class, id);
        tc = (TieneCuarto) session.get(TieneCuarto.class,id);
        p = (Prestador) session.get(Prestador.class, tc.getPrestador());
        Calificacion aux_cali= (Calificacion) session.get(Calificacion.class, p.getIdUsuario());
        
        idprest= p.getIdUsuario();
        contrato = (Contrato) session.get(Contrato.class, id);
        if(contrato !=null){
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Este cuarto ya esta ocupado", null));
        }
        if(d != null && c != null){
            if(aux_cali==null){                
                    this.califP =0;
            }else{
                this.califP = aux_cali.getSumParcial()/aux_cali.getTotal();
            }
            
            this.recomendaciones = c.getRecomendaciones();
            this.duenoC = p.getNombre()+" "+p.getApellidoPaterno()+" "+p.getApellidoMaterno();
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
            this.recomendaciones = c.getRecomendaciones();
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
    
    public String rentarCuarto(int idUsuario) {
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        Contrato c1;
        TieneContratoU c2;
        TieneContratoU auxtc;
        c1 = (Contrato) session.get(Contrato.class,id);
        if(c1!=null){
             c2 = (TieneContratoU) session.get(TieneContratoU.class,c1.getIdContrato());
            if(c2.getEstudiante()==idUsuario){
               estado="Ya estas rentando este cuarto";
            }else{
               estado ="Este cuarto ya esta ocupado por alguien más";
            }
            return "verInfCuarto";
        }else{
          idNew = 1;
          int idnewc =1;
          TieneCuarto tc1 = (TieneCuarto) session.get(TieneCuarto.class,id);
          p = (Prestador) session.get(Prestador.class, tc1.getPrestador());
          contrato = (Contrato) session.get(Contrato.class, idnewc);
          while(contrato != null){
              idnewc++;
             contrato = (Contrato) session.get(Contrato.class, idnewc);
          }
          contrato = new Contrato(idnewc,id);
          tcu = new TieneContratoU(idnewc, idUsuario, p.getIdUsuario());
            
          for(int i=0;i<100;i++){
              auxtc= (TieneContratoU) session.get(TieneContratoU.class,i);
             if(auxtc!=null){
              if(idUsuario==auxtc.getEstudiante()){
                estado="Estas rentando otro cuarto";
                return "verInfCuarto";
                }
             }
          }
          if(contrato != null && tcu != null){
              
              session.save(contrato);
              session.save(tcu);
              session.getTransaction().commit();
              session.close();
              estado="Acabas de rentar éste cuarto por un més";
            return "verInfCuarto";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo hacer el contrato", null));
            return "verInfCuarto";
        }
        }
    }
    
    public void mensaje() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Cuarto "+ idNew + " Creado"));
    }
    public void mensajeCont() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Has hecho un contrato"));
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
