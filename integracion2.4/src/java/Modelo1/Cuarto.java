package Modelo1;
// Generated 13/04/2016 11:24:39 AM by Hibernate Tools 4.3.1



/**
 * Cuarto generated by hbm2java
 */
public class Cuarto  implements java.io.Serializable {


     private int idCuarto;
     private int precio;
     private byte[] fotoC;
     private String observacionesC;
     private int recomendaciones;

    public Cuarto() {
    }

    public int getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(int recomendaciones) {
        this.recomendaciones = recomendaciones;
    }
	
    public Cuarto(int idCuarto, int precio, String observacionesC) {
        this.idCuarto = idCuarto;
        this.precio = precio;
        this.observacionesC = observacionesC;
    }
    public Cuarto(int idCuarto, int precio, byte[] fotoC, String observacionesC) {
       this.idCuarto = idCuarto;
       this.precio = precio;
       this.fotoC = fotoC;
       this.observacionesC = observacionesC;
    }
   
    public int getIdCuarto() {
        return this.idCuarto;
    }
    
    public void setIdCuarto(int idCuarto) {
        this.idCuarto = idCuarto;
    }
    public int getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public byte[] getFotoC() {
        return this.fotoC;
    }
    
    public void setFotoC(byte[] fotoC) {
        this.fotoC = fotoC;
    }
    public String getObservacionesC() {
        return this.observacionesC;
    }
    
    public void setObservacionesC(String observacionesC) {
        this.observacionesC = observacionesC;
    }




}

