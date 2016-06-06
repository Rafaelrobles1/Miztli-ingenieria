
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
@Named(value = "jSFManagedBean_3")
@SessionScoped
//@RequestScoped
@ManagedBean
public class JBean_3 implements Serializable {

    private HibernateUtil helper;
    private MiLoginHelper helper1;
    private Session session;

    private Usuario u;
    private TieneContratoU con;
    private Prestador p;
    private int id;
 private Cuarto c1;
    
    private int idUsuario;
   
    private int idEvaluacion;
    private boolean cumplimientoContrato;
    private int calificacion;
    private String observacionesE;
    private boolean recomentar;
    
    private int cEvaluar;
    
    Calificacion cali=null;
    TieneCuarto Tcuarto;

    public int getcEvaluar() {
        return cEvaluar;
    }

    public void setcEvaluar(int cEvaluar) {
        this.cEvaluar = cEvaluar;
    }
    

    private String ruta ="/home/salador/Documentos/Ing s/archivo.txt";
    int IdSession=0;
   
    Evaluacion eval;
    //////////////////////////////////////
    public JBean_3() {
        carga();
    }
    public boolean isRecomentar() {
        return recomentar;
    }

    public void setRecomentar(boolean recomentar) {
        this.recomentar = recomentar;
    }

    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public boolean isCumplimientoContrato() {
        return cumplimientoContrato;
    }

    public void setCumplimientoContrato(boolean cumplimientoContrato) {
        this.cumplimientoContrato = cumplimientoContrato;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservacionesE() {
        return observacionesE;
    }

    public void setObservacionesE(String observacionesE) {
        this.observacionesE = observacionesE;
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
        
        
       
    }

    
    ////////////////////////////////////////

   
    /////////////////////////////////////////
    @PostConstruct
    public void initI() {
        
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();

        eval=(Evaluacion) session.get(Evaluacion.class, idUsuario);
        session.getTransaction().commit();
        session.close();
        
    }

    

    
    public String modifEval() throws NoSuchAlgorithmException {
     
        Evaluacion c;
        int idNew=1;
        CargaNum();
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        
        c = (Evaluacion) session.get(Evaluacion.class, idNew);
        int caso=0;
        while(c != null){
            idNew++;
            c = (Evaluacion) session.get(Evaluacion.class, idNew);
        }
        if(recomentar){
        c1.setRecomendaciones(c1.getRecomendaciones()+1);
        }
       
        Tcuarto=(TieneCuarto) session.get(TieneCuarto.class,c1.getIdCuarto());
        cali= (Calificacion) session.get(Calificacion.class,Tcuarto.getPrestador());
        if(cali ==null){
            caso=1;
        cali=new Calificacion(Tcuarto.getPrestador(), 0, 0);
        }
        
        if(cali.getTotal()==0){
            cali.setTotal(1);
            cali.setSumParcial(calificacion);
        }else{ 
            cali.setTotal(cali.getTotal()+1);
            cali.setSumParcial(cali.getSumParcial()+calificacion);
        }
        Evaluacion ev =new Evaluacion(idNew,cumplimientoContrato,calificacion,observacionesE,recomentar,IdSession);
        
        if (ev != null) {
            if(caso==1){
                session.save(cali);
            }
            session.update(cali);
            session.update(c1);
            session.save(ev);
            session.getTransaction().commit();
            session.close();
            mensajeConfModif();
            pEvaluar="Evaluaste el cuarto correctamente";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al modificar usuario " + id, null));
            return "principal";
        }
        return "estudiante";
    }
    
    private Contrato cont;
    private String pEvaluar = "";

    public String getpEvaluar() {
        return pEvaluar;
    }

    public void setpEvaluar(String pEvaluar) {
        this.pEvaluar = pEvaluar;
    }
    
   
    
    public String evaluar(){
       TieneContratoU u = null;
      
        CargaNum();
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        for(int i=1; i<=50;i++){
            u = (TieneContratoU) session.get(TieneContratoU.class, i);
            
            if(u != null && u.getEstudiante()==IdSession){
            break;
            }else{
            u=null;
            }
        }
        
        if(u != null){
           cont = (Contrato) session.get(Contrato.class,u.getContrato());
              
             c1 = (Cuarto) session.get(Cuarto.class,cont.getIdCuarto());
      
         cEvaluar = c1.getIdCuarto();
         return "evalE";
    
        }else{
            pEvaluar = "No tienes cuartos disponibles";
            return "estudiante";
        }
    }

    public void mensaje() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(" Evaluacion  Completada"));
    }

   

    public void mensajeConfModif() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Evaluacion  Completada"));
    }

     public String cancela(){
    return "principal";
        
    }

}
