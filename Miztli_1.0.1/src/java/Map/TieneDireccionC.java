package Map;
// Generated 12-abr-2016 23:56:00 by Hibernate Tools 4.3.1



/**
 * TieneDireccionC generated by hbm2java
 */
public class TieneDireccionC  implements java.io.Serializable {


     private int cuarto;
     private DireccionCuarto direccionCuarto;

    public TieneDireccionC() {
    }

    public TieneDireccionC(int cuarto, DireccionCuarto direccionCuarto) {
       this.cuarto = cuarto;
       this.direccionCuarto = direccionCuarto;
    }
   
    public int getCuarto() {
        return this.cuarto;
    }
    
    public void setCuarto(int cuarto) {
        this.cuarto = cuarto;
    }
    public DireccionCuarto getDireccionCuarto() {
        return this.direccionCuarto;
    }
    
    public void setDireccionCuarto(DireccionCuarto direccionCuarto) {
        this.direccionCuarto = direccionCuarto;
    }




}

