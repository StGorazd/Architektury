package bednarhalaj.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerHolder {
    private static EntityManager entityManager;

    private EntityManagerHolder() {
    }

    public static EntityManager getInstance() {
        if (entityManager == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bednarhalaj.jpa");
            entityManager = entityManagerFactory.createEntityManager();

        }
        return entityManager;
    }
}
