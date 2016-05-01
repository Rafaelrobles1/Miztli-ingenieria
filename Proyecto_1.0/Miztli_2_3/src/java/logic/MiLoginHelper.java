/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;


import Modelo1.Usuario;
import Modelo1.DireccionUsuario;
import Modelo1.Estudiante;
import Modelo1.Prestador;
import Modelo1.TieneCuarto;
import java.util.List;
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
        }finally{
           session.close();
       }
        return null;
    }

    public DireccionUsuario getLoginPorDireccion(int IdUsuario) {
        try {
             session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            Query q = session.getNamedQuery("BuscaPorDireccion").setInteger("Id1", IdUsuario );
            return (DireccionUsuario) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
           session.close();
       }
        return null;
    }
    
    
    public Estudiante getLoginPorEstudiante(int IdUsuario) {
        try {
             session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            Query q = session.getNamedQuery("BuscaPorEstudiante").setInteger("Id1", IdUsuario );
            return (Estudiante) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
           session.close();
       }
        return null;
    }
    
    public Prestador getLoginPorPrestador(int IdUsuario) {
        try {
             session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            Query q = session.getNamedQuery("BuscaPorPrestador").setInteger("Id1", IdUsuario );
            return (Prestador) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
           session.close();
       }
        return null;
    }
    
    
        public List<Modelo1.TieneCuarto> getLoginPorListCuartos(int IdUsuario) {
        try {
             session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            Query q = session.getNamedQuery("BuscaPorListCuarto").setInteger("Id1", IdUsuario );
            return (List<TieneCuarto>) (TieneCuarto) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
           session.close();
       }
        return null;
    }
        
     public void GuardarPorCorreo1(int id,String nombre) {
      
         String query = "UPDATE estudiante SET nombre = '"+ nombre +"' WHERE Username = "+ id + "";
         try {
              session = HibernateUtil.getSessionFactory().openSession();
              Transaction tx = session.beginTransaction();
             
              session.createSQLQuery(query).executeUpdate();
                session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
           session.close();
       }
        
    }
    
}
