/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicahibernate;


import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author vesprada
 */
public class PracticaHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        Profesor p1 = new Profesor(1, "Edgar", "Garcia", "Morant");
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        //OPERACIONS DE INSERTAR, MODIFICAR I ELIMINAR
        
        //INSERTAR 
//        session.save(p1);
//        session.getTransaction().commit();
        
        //ELIMINAR
//        session.delete(p1);
//        session.getTransaction().commit();

        //ACTUALIZAR
//        p1.setNombre("Jose");
//        session.update(p1);
//        session.getTransaction().commit();
        
        //LLEGIR
//        Profesor p2 = (Profesor) session.get(Profesor.class, 1001);
//        System.out.println("Profesor: "+p2.getNombre());

        Query query = session.createQuery("SELECT count(*) FROM profesor");
        
        List<Profesor> profesores = query.list();
        
        for(Profesor p: profesores){
            System.out.println("NOMBRE: "+p.getNombre());
        }
        
        
        session.close();
    }
    
    
}
