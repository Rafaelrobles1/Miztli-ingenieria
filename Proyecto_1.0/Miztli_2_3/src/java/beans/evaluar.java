/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import javax.inject.Named;
;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;

import logic.HibernateUtil;
import Modelo1.Evaluacion;
import beans.Milogin;

@ManagedBean
@RequestScoped
public class evaluar implements java.io.Serializable{
    
    private HibernateUtil helper;
    private Session session;
    
    private Evaluacion E;    
    private int idEvaluacion;
    private boolean cumplimientoContrato;
    private int calificacion;
    private String observacionesE;
    private boolean recomentar;
    private int idUsuario;
    
    
    /**
     * Creates a new instance of evaluar
     */
    //Metodo que redirecciona a la pagina donde esta el formulario para evaluar
    public String evaluarUsuario(){
//        httpServletRequest.getSession().removeAttribute("sessionUsuario");
//        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "LLENA TODOS LOS CAMPOS", null);
//        faceContext.addMessage(null, message);
        return "Evaluar";
    }
    
    
    private Boolean valorContrato; //valor de cumplio contrato
    private Boolean valorRecomienda; //valor de cumplio contrato
  
    public boolean regresaValorContrato() {
        if (valorContrato)
          return true;
        else 
          return false;        
    }
    public boolean regresaValorRecomienda() {
        if (valorRecomienda) 
          return true;
        else 
          return false;
    }    
    
    
    public String guardarEvaluacion(int idUser){
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        E = new Evaluacion( cumplimientoContrato, calificacion, observacionesE, recomentar, idUser );
        session.save(E);
        session.getTransaction().commit();
        session.close();
        mensajeEvaluacion();        
        return "Pincipal";
    }
    
    public void mensajeEvaluacion(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evaluacion Completada"));
    }
    public evaluar() {
       this.cumplimientoContrato = true;
       this.calificacion = 5;
       this.observacionesE = "null";
       this.recomentar = true;
       this.idUsuario = 1;        
    }
    
    public evaluar(boolean cumplimientoContrato, int calificacion, String observacionesE, boolean recomentar, int idUsuario) {
       this.cumplimientoContrato = cumplimientoContrato;
       this.calificacion = calificacion;
       this.observacionesE = observacionesE;
       this.recomentar = recomentar;
       this.idUsuario = idUsuario;
    }
   
    public int getIdEvaluar() {
        return this.idEvaluacion;
    }
    
    public void setIdEvaluar(int idEvaluar) {
        this.idEvaluacion = idEvaluacion;
    }
    public boolean isCumplimientoContrato() {
        return this.cumplimientoContrato;
    }
    
    public void setCumplimientoContrato(boolean cumplimientoContrato) {
        this.cumplimientoContrato = cumplimientoContrato;
    }
    public int getCalificacion() {
        return this.calificacion;
    }
    
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    public String getObservacionesE() {
        return this.observacionesE;
    }
    
    public void setObservacionesE(String observacionesE) {
        this.observacionesE = observacionesE;
    }
    public boolean isRecomentar() {
        return this.recomentar;
    }
    
    public void setRecomentar(boolean recomentar) {
        this.recomentar = recomentar;
    }
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    

    
}
 