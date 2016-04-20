package beans;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import logic.LoginHelper;


@ManagedBean
@RequestScoped
public class Login {
    
    private String usuario; // Representa el nombre de usuario.
    private String contrasena; // Representa la contraseña. NO DEBERÍA de ser manejada como texto plano.
      
    
    private final HttpServletRequest httpServletRequest; // Obtiene información de todas las peticiones de usuario.
    private final FacesContext faceContext; // Obtiene información de la aplicación
    private FacesMessage message; // Permite el envio de mensajes entre el bean y la vista.
    private final LoginHelper helper;
    
    model.Usuario contra;
    model.DireccionUsuario direc;
    
   
     
     public Login() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        helper = new LoginHelper();
    }
    
     
     public String login() {
         contra= helper.getLoginPorNombre(usuario);
         
         direc = helper.getLoginPorDireccion(contra.getIdUsuario());
         
        if (contra != null) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(contrasena.getBytes());
                byte[] digest = md.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b & 0xff));
                }
                if (sb.toString().equals(contra.getContrasenya())) {
                    httpServletRequest.getSession().setAttribute("sessionUsuario", usuario);
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto", null);
                    faceContext.addMessage(null, message);
                    return "PrincipalUsuario";
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrecto", null);
            faceContext.addMessage(null, message);
            return "Principal";
        }
        return "Principal";
    }
     
     
    public int daId(){
    return contra.getIdUsuario();
    } 
    
    public int algo(){
    if(direc!=null){
    return direc.getIdDireccionU();
    }
    return 0 ;
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
