/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import Modelo1.Cuarto;
import Modelo1.DireccionCuarto;
import Modelo1.TieneDireccionC;
import Modelo1.Usuario;
import Modelo1.TieneCuarto;
import Modelo1.Prestador;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author salador
 */
public class CuartoHelper {
    private Session session;

    public CuartoHelper() {
    }
    
    public List<Modelo1.Cuarto> getCuartos(){
             session = HibernateUtil.getSessionFactory().openSession();
             session.beginTransaction();
              Query  q = session.getNamedQuery("todosCuartos");
              List<Modelo1.Cuarto> l = (List<Modelo1.Cuarto>) q.list();
               session.getTransaction().commit();
               session.close();
          return l;    
    }
    public Cuarto getCuartoPorID(Integer idc){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        // System.out.println("--::::"+idc);
         Query  q = session.getNamedQuery("getId").setInteger("id", 1);;
        Cuarto c = (Modelo1.Cuarto) q.uniqueResult();
        // System.out.println(c+"::::"+idc);
        session.getTransaction().commit();
        session.close();
        return c;          
    }
    
     public DireccionCuarto getDirCuarto(Integer idc){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        System.out.println(session+"ssss");
        Query  q = session.getNamedQuery("getDirCuartoPorId").setInteger("id", idc);
        System.out.println(q.uniqueResult()+"#####");
        Modelo1.DireccionCuarto ew = (Modelo1.DireccionCuarto)q.uniqueResult(); 
        session.getTransaction().commit();
        session.close();
       return ew;  
  
    }
     public TieneDireccionC getTieneDirCuarto(Integer idc){
          session = HibernateUtil.getSessionFactory().openSession();
          session.beginTransaction();
          Query  q = session.getNamedQuery("getTieneDirCuartoPorId").setInteger("id", idc);
          session.getTransaction().commit();
          session.close();
          return (TieneDireccionC) q.uniqueResult();
    }
     
     public Modelo1.Prestador getPrestadorPorCuarto(Integer idc){
          session = HibernateUtil.getSessionFactory().openSession();
          session.beginTransaction();
          Query  q = session.getNamedQuery("getTieneCuartoPorId").setInteger("id", idc);
          TieneCuarto tdc = (TieneCuarto) q.uniqueResult();
          q = session.getNamedQuery("getPrestadorPorIdC").setInteger("id",tdc.getPrestador());
          Modelo1.Prestador prest = (Modelo1.Prestador) q.uniqueResult();
          session.getTransaction().commit();
          session.close();
          return prest;
    } 
     
    public  List<Cuarto> getCuartoPorCPrestador(String usuario) {
       session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
            List<Cuarto> q = session.getNamedQuery("BuscaCuartoPorCPrestador").setString("idc", usuario).list();
       session.getTransaction().commit();
       session.close();
            return q;
    }
    
    public Cuarto getCuartoPorId(Integer idc){
       session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
            Query q = session.getNamedQuery("CuartoPorId").setInteger("id", idc);
             session.getTransaction().commit();
             session.close();
            return (Cuarto) q.uniqueResult();
    }
    public DireccionCuarto getDireccionCPorId(Integer idc){
       session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
        Query q = session.getNamedQuery("DirCuartoPorId").setInteger("id", idc);
        session.getTransaction().commit();
        session.close();
        return (DireccionCuarto) q.uniqueResult();
    }
    
    public Usuario getLoginPorCorreo(String usuario) {
        session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
            Query q = session.getNamedQuery("BuscaPorCorreo").setString("correo1", usuario );
              session.getTransaction().commit();
        session.close();
            return (Usuario) q.uniqueResult();
       
    }    
}
