import javax.persistence.*;

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

    // Fermer un EM et defaire la transaction si necessaire
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
}
