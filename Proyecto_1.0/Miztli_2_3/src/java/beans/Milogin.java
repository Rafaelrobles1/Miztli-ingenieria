/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

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
@ManagedBean
@RequestScoped

public class Milogin {

     
    private String usuario; // Representa el nombre de usuario.
    private String contrasena; // Representa la contraseña. NO DEBERÍA de ser manejada como texto plano.
    private final HttpServletRequest httpServletRequest; // Obtiene información de todas las peticiones de usuario.
    private final FacesContext faceContext; // Obtiene información de la aplicación
    private FacesMessage message; // Permite el envio de mensajes entre el bean y la vista.
    private MiLoginHelper helper;
    
    
    Modelo1.Usuario correo; // este el un usuario cargado
    Modelo1.DireccionUsuario dir;
    Modelo1.Estudiante estu;
    Modelo1.Prestador pres;
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
        if(correo!= null){
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
                    return "PrincipalUsuarioEstudiante";
                  }else{
                      pres=helper.getLoginPorPrestador(correo.getIdUsuario());
                        
                      //if(daCuartos() == 0){
                         // return "PrincipalUsuarioPrestador_1";
                      //} else {
                          return "PrincipalUsuarioPrestador";
                      //}
                  }
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Milogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña inválidos", null));
            return "Principal";
        }
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrectos", null));
    return "Principal";
    }
    
    
    public String daUsuario(){
        String nom;
        nom=correo.getNombre()+ " "+correo.getApellidoPaterno()+ " " +correo.getApellidoMaterno();
        return nom;
        
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
        return correo.getIdUsuario();
    }
    public String daTelefono(){
        
        return correo.getTelefono();
        
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
       
         return "Confirnacion_usuario";
       
    }
    
     public String EliminarEstudiante( ){
       
         return "Confirnacion_usuario_eliminar";
       
    }
 
    public String EditarPrestador( ){
       
         return "Confirnacion_usuario_Prestador";
       
    }
    
    public String EliminarPrestador( ){
       
         return "Confirnacion_usuario_eliminar_Prestador";
    }
}

