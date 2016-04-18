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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import logic.MiLoginHelper;

/**   
 *
 * @author salador
 */
@ManagedBean
@SessionScoped
public class Milogin {

     
    private String usuario; // Representa el nombre de usuario.
    private String contrasena; // Representa la contraseña. NO DEBERÍA de ser manejada como texto plano.
    private final HttpServletRequest httpServletRequest; // Obtiene información de todas las peticiones de usuario.
    private final FacesContext faceContext; // Obtiene información de la aplicación
    private FacesMessage message; // Permite el envio de mensajes entre el bean y la vista.
    private MiLoginHelper helper;
    private Modelo1.Usuario correo; // este el un usuario cargado
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
                  
                    return "PrincipalUsuario";
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Milogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
        
            return "Principal";
        }
    return "Principal";
    }
    
    
    public String daUsuario(){
        String nom;
        nom=correo.getNombre()+ " "+correo.getApellidoPaterno()+ " " +correo.getApellidoMaterno();
        return nom;
        
    }
    
    public String daTelefono(){
        
        return correo.getTelefono();
        
    }
    public String daDireccion(){
        
        int miId=correo.getIdUsuario();
        Modelo1.DireccionUsuario dir=helper.getLoginPorDireccion(miId);
        String res=dir.getCalleU();
        return res;
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

}

