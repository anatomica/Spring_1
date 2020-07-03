package Homework3;

import Homework2.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class BuyersStore {
    public static void main(String[] args) {
        PrepareStoreApp.forcePrepareData();

        SessionFactory factory = new Configuration()
                .configure("configs/store/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Client> clients = session.createQuery("SELECT c FROM Client c ORDER BY size(c.products) DESC").getResultList();
            System.out.println(clients);
            // Client client = session.get(Client.class, 1L);
            for (Client client : clients) {
                System.out.println(client);
                System.out.println("Товары: ");
                for (Product product : client.getProducts()) {
                    System.out.println(product.getTitle());
                }
            }
            session.getTransaction().commit();
            System.out.println();

            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Product> products = session.createQuery("SELECT p FROM Product p").getResultList();
            System.out.println(products);
            for (Product product: products) {
                System.out.println(product);
                System.out.println("Покупатели: ");
                for (Client client : product.getClients()) {
                    System.out.println(client.getName());
                }
            }
            session.getTransaction().commit();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
