package Modelo1;
// Generated 13/04/2016 11:24:39 AM by Hibernate Tools 4.3.1



/**
 * Evaluacion generated by hbm2java
 */
public class Evaluacion  implements java.io.Serializable {


     private int idEvaluacion;
     private boolean cumplimientoContrato;
     private int calificacion;
     private String observacionesE;
     private boolean recomentar;
     private int idUsuario;

    public Evaluacion() {
    }

    public Evaluacion(int idEvaluacion, boolean cumplimientoContrato, int calificacion, String observacionesE, boolean recomentar, int idUsuario) {
       this.idEvaluacion = idEvaluacion;
       this.cumplimientoContrato = cumplimientoContrato;
       this.calificacion = calificacion;
       this.observacionesE = observacionesE;
       this.recomentar = recomentar;
       this.idUsuario = idUsuario;
    }
   
    public int getIdEvaluacion() {
        return this.idEvaluacion;
    }
    
    public void setIdEvaluacion(int idEvaluacion) {
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


