/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.*;
/**
 *
 * @author salador
 */
public class LoginHelper {
    
    private Session session;
    
    public LoginHelper() {
        try{
        
            session = HibernateUtil.getSessionFactory().openSession();
        }
        catch(Exception EX){
                session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
    }
    
     public Usuario getLoginPorNombre(String nombre) {
       
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.getNamedQuery("BuscaPorCorreo").setString("correo1", nombre);
            
            return (Usuario) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

      public DireccionUsuario getLoginPorDireccion(int nombre) {
       
        try {
            Transaction tx = session.beginTransaction();
            int idD=1;
            Query q = session.getNamedQuery("BuscaPorDireccion").setInteger(idD, nombre);
            
            return (DireccionUsuario) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
