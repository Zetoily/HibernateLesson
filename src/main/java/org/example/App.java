package org.example;

import org.example.model.Passport;
import org.example.model.Person;
import org.example.model.Principal;
import org.example.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(School.class)
                .addAnnotatedClass(Principal.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            School school = session.get(School.class,4);
            Principal principal = new Principal("Eblan",20);
            school.setPrincipal(principal);

            session.save(school);
            session.save(principal);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
