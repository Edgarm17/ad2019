/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.hibernate.Session;

/**
 *
 * @author vesprada
 */
public class ProfesorDAO {
    
    
    public void insertarProfesor(Profesor p){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(p);
        session.getTransaction().commit();
        session.close();
    }
    
    public Profesor getProfesor(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Profesor p2 = (Profesor) session.get(Profesor.class, id);
        session.close();
        return p2;
    }
    
    public void modificarProfesor(Profesor p){
        Session session = HibernateUtil.getSessionFactory().openSession();
        p.setNombre("Jose");
        session.update(p);
        session.getTransaction().commit();
        session.close();
    }
    
    public void eliminarProfesor(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Profesor p = (Profesor) session.get(Profesor.class, id);
        session.delete(p);
        session.getTransaction().commit();
        session.close();
    }
    
    public void buscarProfesor(String nombre){
        Session session = HibernateUtil.getSessionFactory().openSession();
    }
    
    
}
