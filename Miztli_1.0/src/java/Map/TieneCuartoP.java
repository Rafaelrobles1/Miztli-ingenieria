package Map;
// Generated 12-abr-2016 14:10:40 by Hibernate Tools 4.3.1



/**
 * TieneCuartoP generated by hbm2java
 */
public class TieneCuartoP  implements java.io.Serializable {


     private int cuarto;
     private int prestador;

    public TieneCuartoP() {
    }

    public TieneCuartoP(int cuarto, int prestador) {
       this.cuarto = cuarto;
       this.prestador = prestador;
    }
   
    public int getCuarto() {
        return this.cuarto;
    }
    
    public void setCuarto(int cuarto) {
        this.cuarto = cuarto;
    }
    public int getPrestador() {
        return this.prestador;
    }
    
    public void setPrestador(int prestador) {
        this.prestador = prestador;
    }




}

