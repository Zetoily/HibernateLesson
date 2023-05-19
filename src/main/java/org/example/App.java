package org.example;

import org.example.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Actor actor = session.get(Actor.class,2);
            System.out.println(actor.getMovies());

            Movie movieToRemove = actor.getMovies().get(0);

            actor.getMovies().remove(0);
            movieToRemove.getActors().remove(actor);


//            Actor actor = session.get(Actor.class,1);
//            System.out.println(actor.getMovies());


//            Movie movie = new Movie("Resorvier Dogs",1992);
//            Actor actor = session.get(Actor.class,1);
//
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//            actor.getMovies().add(movie);
//
//            session.save(movie);

//            Movie movie= session.get(Movie.class,1);
//            System.out.println(movie.getActors());

            session.getTransaction().commit();
        }
    }
}
