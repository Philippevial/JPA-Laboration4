package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


public class ArtistDaoImpl implements ArtistDao {

    EntityManagerFactory emf;
    EntityManager em;

    public ArtistDaoImpl() {
      emf = Persistence.createEntityManagerFactory("Laboration4");
      em = emf.createEntityManager();
    }

    @Override
    public void createArtist(Artist artist) {
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
    }

    @Override
    public void deleteArtist(Artist artist) {
        em.getTransaction().begin();
        em.remove(artist);
        em.getTransaction().commit();
    }

    @Override
    public Artist selectByID(int id) {
        return em.find(Artist.class, id);
    }

    @Override
    public void updateArtist(Artist artist) {
        em.getTransaction().begin();
        em.merge(artist);
        em.getTransaction().commit();
    }

    @Override
    public List<Artist> selectAll() {
        return em.createQuery("SELECT artist FROM Artist artist", Artist.class).getResultList();
    }

    @Override
    public List<Artist> selectAllByGenre(String genre) {
        TypedQuery<Artist> query = em.createQuery("SELECT a FROM Artist a WHERE a.genre = :genre", Artist.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }

    @Override
    public List<Artist> selectAllByAge(int from, int to) {
        TypedQuery<Artist> query = em.createQuery("SELECT a FROM Artist a WHERE a.age BETWEEN :from AND :to", Artist.class);
        query.setParameter("from", from);
        query.setParameter("to", to);
        return query.getResultList();
    }

    @Override
    public List<Artist> selectAllByGender(Gender gender) {
        TypedQuery<Artist> query = em.createQuery("SELECT a FROM Artist a WHERE a.gender = :gender", Artist.class);
        query.setParameter("gender", gender);
        return query.getResultList();
    }
}
