/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;


import Modelo1.Usuario;
import Modelo1.DireccionUsuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author salador
 */
public class MiLoginHelper {
    private Session session;

    public MiLoginHelper() {
        try{        
             session = HibernateUtil.getSessionFactory().openSession();

        }
        catch(Exception EX){
            session = HibernateUtil.getSessionFactory().getCurrentSession();

        }
    }

    public Usuario getLoginPorNombre(String usuario) {

         
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.getNamedQuery("BuscaPorNombre").setString("nombre", usuario);
            return (Usuario) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Usuario getLoginPorCorreo(String usuario) {
       try {
            Transaction tx = session.beginTransaction();
            Query q = session.getNamedQuery("BuscaPorCorreo").setString("correo1", usuario );
            return (Usuario) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public DireccionUsuario getLoginPorDireccion(String usuario) {
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.getNamedQuery("BuscaPorDireccion").setString("correo1", usuario );
            return (DireccionUsuario) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
