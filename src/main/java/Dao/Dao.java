package main.java.Dao;

import main.java.models.Emprunt;
import main.java.models.Livre;

import javax.persistence.*;
import java.util.List;

public class Dao {

    private EntityManagerFactory factory = null;
    public void init() {
        factory = Persistence.createEntityManagerFactory("jpa_01");
    }
    public void close() {
        if (factory != null) {
            factory.close();
        }
    }
    private EntityManager newEntityManager() {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        return (em);
    }
    // Fermer un EM et défaire la transaction si néecessaire
    private void closeEntityManager(EntityManager em) {
        if (em != null) {
            if (em.isOpen()) {
                EntityTransaction t = em.getTransaction();
                if (t.isActive()) {
                    try {
                        t.rollback();
                    } catch (PersistenceException e) {
                        e.printStackTrace();

                    }
                }
                em.close();
            }
        }
    }


    public Livre findLivre(int id) {
        EntityManager em = null;
        try {
            em = newEntityManager();
            // utilisation de l'EntityManager
            Livre p = em.find(Livre.class, id);
            return p;
        } finally {
            closeEntityManager(em);
        }
    }
    public Livre addLivre(Livre l) {
        EntityManager em = null;
        try {
            em = newEntityManager();
            // utilisation de l'EntityManager
            em.persist(l);
            em.getTransaction().commit();
            System.err.println("addLivre witdh id=" + l.getId());
            return (l);
        } finally {
            closeEntityManager(em);
        }
    }
    public void updateLivre(Livre l) {
        EntityManager em = null;
        try {
            em = newEntityManager();
            em.merge(l);
            em.getTransaction().commit();
        } 		catch(Exception e) {
            e.printStackTrace();
        }		finally {
            closeEntityManager(em);
        }
    }
    public void removeLivre(int id) {
        EntityManager em = null;
        try {
            em = newEntityManager();
            em.remove(id);
            em.getTransaction().commit();
        } 		catch(Exception e) {
            e.printStackTrace();
        }		finally {
            closeEntityManager(em);
        }
    }
    public List<Livre> findAllLivres() {
        EntityManager em = null;
        try {
            em = newEntityManager();
            String query = "SELECT l FROM Livre l";
            TypedQuery<Livre> q = em.createQuery(query, Livre.class);
            return q.getResultList();
        } finally {
            closeEntityManager(em);
        }
    }
    public List<Livre> findLivresByFirstName(String pattern) {
        EntityManager em = null;
        try {
            em = newEntityManager();
            String query = "SELECT l FROM Livre l where l.title like :param1";
            TypedQuery<Livre> q = em.createQuery(query, Livre.class);
            q.setParameter("param1", pattern);
            return q.getResultList();
        } finally {
            closeEntityManager(em);
        }
    }

    public Emprunt finEmpruntLivres(int id_emp) {
        EntityManager em = null;
        try {
            em = newEntityManager();
            String query = "SELECT id_liv FROM Compo c where c.id_emp like :param1";
            TypedQuery<Emprunt> q = em.createQuery(query, Emprunt.class);
            q.setParameter("param1", id_emp);
            return (Emprunt) q.getResultList();
        } finally {
            closeEntityManager(em);
        }
    }
    public Emprunt AllEmpruntClient(int client) {
        EntityManager em = null;
        try {
            em = newEntityManager();
            String query = "SELECT id_client FROM Emprunt e where e.id_client like :param1";
            TypedQuery<Emprunt> q = em.createQuery(query, Emprunt.class);
            q.setParameter("param1", client);
            return (Emprunt) q.getResultList();
        } finally {
            closeEntityManager(em);
        }
    }
}
