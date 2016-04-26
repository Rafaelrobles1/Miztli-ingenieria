package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import logic.MiLoginHelper;

/**
 * Managed Bean para manejar el cierre de sesión de la aplicación.
 */
@ManagedBean // LEER LA DOCUMENTACIÖN DE ESTA ANOTACIÓN: Permite dar de alta al bean en la aplicación
@RequestScoped // Sólo está disponible a partir de peticiones al bean
public class Mylogout {

    private String usuario; // Representa el nombre de usuario.
    private final HttpServletRequest httpServletRequest; // Obtiene información de todas las peticiones de usuario.
    private final FacesContext faceContext; // Obtiene información de la aplicación
    private FacesMessage message; // Permite el envio de mensajes entre el bean y la vista.
    private Session session;

    /**
     * Constructor para inicializar los valores de faceContext y
     * httpServletRequest, además de la sesión de usuario.
     */
    public Mylogout() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        if (httpServletRequest.getSession().getAttribute("sessionUsuario") != null) {
            usuario = httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
        }
    }

    /**
     * Método encargado de cerrar la sesión de la aplicación.
     *
     * @return El nombre de la vista que va a responder.
     */
    
    public String cerrarSession() {
        httpServletRequest.getSession().removeAttribute("sessionUsuario");
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "A T E N C I Ó N", null);
        faceContext.addMessage(null, message);
        return "ValidarSalida";
    }
    public String salir() {
        httpServletRequest.getSession().removeAttribute("sessionUsuario");
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Vuelva pronto", null);
        faceContext.addMessage(null, message);
        httpServletRequest.getSession().invalidate();
        return "salir";
    }
    public String cancelarCerrarSession() {
        httpServletRequest.getSession().removeAttribute("sessionUsuario");
        return "PrincipalUsuario";
    }

    
    /**
     * Regresa el nombre de usuario.
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

}