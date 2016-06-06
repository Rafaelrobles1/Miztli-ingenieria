/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Modelo1.CalificacionEstudiante;
import Modelo1.Estudiante;
import Modelo1.Prestador;
import Modelo1.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import logic.MiLoginHelper;

/**   
 *
 * @author salador
 */
@SessionScoped
@ManagedBean
@RequestScoped

public class Milogin {
     
    private String usuario; // Representa el nombre de usuario.
    private String contrasena; // Representa la contraseña. NO DEBERÍA de ser manejada como texto plano.
    private int id;
    
    private final HttpServletRequest httpServletRequest; // Obtiene información de todas las peticiones de usuario.
    private final FacesContext faceContext; // Obtiene información de la aplicación
    private FacesMessage message; // Permite el envio de mensajes entre el bean y la vista.
    private MiLoginHelper helper;
    
    
    Modelo1.Usuario correo; // este el un usuario cargado
    Modelo1.DireccionUsuario dir;
    Modelo1.Estudiante estu;
    Modelo1.Prestador pres;
    private MiLoginHelper helper1;
    int IdSession=0;
    
    Prestador aux1;
    Estudiante aux;
    

    /**
     * Creates a new instance of NewJSFManagedBean1
     */
    public Milogin() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        helper = new MiLoginHelper();
    }
    
 /**
     * Método encargado de validar el inicio de sesión.
     *
     * @return El nombre de la vista que va a responder.
     */
  
    
    public String login1() {
               correo = helper.getLoginPorCorreo(usuario);
       if(correo!= null && contrasena != null){
            /*-------------------------------------------*/
        try{    
           String ruta = "/home/salador/Documentos/Ing s/archivo.txt";
           File archivo = new File(ruta);
           BufferedWriter bw;
           if(archivo.exists()) {
              bw = new BufferedWriter(new FileWriter(archivo));
              bw.write(new Integer(correo.getIdUsuario()).toString());
           } else {
              bw = new BufferedWriter(new FileWriter(archivo));
              bw.write(new Integer(correo.getIdUsuario()).toString());
           }
           bw.close();
           }catch(Exception e){
           }    
            /*-------------------------------------------*/
             try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(contrasena.getBytes());
                byte[] digest = md.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b & 0xff));
                }
                if (sb.toString().equals(correo.getContrasenya())) {
                  estu=helper.getLoginPorEstudiante(correo.getIdUsuario());
                  if(estu!=null){
                    return "estudiante";
                  }else{
                      pres=helper.getLoginPorPrestador(correo.getIdUsuario());
                      
                          return "prestador";
                     
                  }
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Milogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña inválidos", null));
            return "principal";
        }
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrectos", null));
    return "principal";
    }
    
    public void carga(){
    String cadena=null;
        BufferedReader b=null;
        FileReader f;
            try {
                f = new FileReader("/home/salador/Documentos/Ing s/archivo.txt"); 
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
        
            correo=helper1.getLoginPorUsuarioN(IdSession);
            estu=helper1.getLoginPorEstudiante(IdSession); 
            pres=helper1.getLoginPorPrestador(IdSession);
     }
    
    public String daUsuario(){
        carga();
        String nom;
        nom=correo.getNombre()+ " "+correo.getApellidoPaterno()+ " " +correo.getApellidoMaterno();
        return nom;
        
    }
    
    public int daIdU(){
          carga();
          return correo.getIdUsuario();
    }
    
    public String daNombre(){
            return correo.getNombre();
    }
    
    public String daApP(){
            return correo.getApellidoPaterno();
    }
    public String daApM(){
            return correo.getApellidoMaterno();
    }
    
    public int daIdUsuario(){
        carga();
        return correo.getIdUsuario();
    }
    
    public int getId(){
        return correo.getIdUsuario();
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String daTelefono(){
        
        return correo.getTelefono();
        
    }
    
    public String daCorreo1(){
        return correo.getCorreo();
    }
    public String daCalle(){
        String res=null;
        int miId=correo.getIdUsuario();
        dir=helper.getLoginPorDireccion(miId);
        if(dir!=null){
        res=dir.getCalleU();
        }else{
        res=""+miId;
        }
        return res;
    }
    
    
    public String daColonia(){
    return dir.getColoniaU();
    }
    
    public String daDelegacion(){
    return dir.getDelegacionU();
    }
    
    public String daEstado(){
    return dir.getEstadoU();
    }
    
    public String daPais(){
    return dir.getPaisU();
    }
    
    public String daCarrera(){
        return estu.getCarrera();
    }
    
    public String daFacultad(){
        return estu.getFacultad();
    }
    
    public String daCorreo(){
        return estu.getCorreo();
    }
    
    public String daTel(){
        return estu.getTelefono();
    }
    
    public String daCorreoP(){
        return pres.getCorreo();
    }
    
    public String daTelP(){
        return pres.getTelefono();
    }
    
    public int daCuartos(){
        return pres.getCuartosDisponibles();
    }
    /**
     * Obtiene el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getUsuario() {
             return usuario;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param usuario El nombre de usuario a establecer.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Regresa la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContrasena() {
            return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasena La contraseña del usuario a establecer.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
    public String CrearCuarto(){
        return "CrearCuarto";
    
    }
    
    
    public String EditarCuarto(){
        return "EditarCuarto";
    
    }
    
    
    public String EliminarCuarto(){
        return "EditarCuarto";
    
    }
    
    public String EditarEstudiante( ){
       
         return "modificarEstudiante";
       
    }
    
     public String EliminarEstudiante( ){
       
         return "eliminarEstudiante";
       
    }
 
    public String EditarPrestador( ){
       
         return "modificarPrestador";
       
    }
    
    public String EliminarPrestador( ){
       
         return "eliminarPrestador";
    }
    
    
}

