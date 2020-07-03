package Homework3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddDeleteStore {
    public static void main(String[] args) {
        PrepareStoreApp.forcePrepareData();

        SessionFactory factory = new Configuration()
                .configure("configs/store/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;
        try {
            System.out.println("Delete Product");
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("DELETE FROM Product p WHERE p.id = 1").executeUpdate();
            session.getTransaction().commit();
            System.out.println();

            System.out.println("Delete Client");
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println(session.createQuery("DELETE FROM Client c WHERE c.name = 'Willis B.'").executeUpdate());
            session.getTransaction().commit();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
