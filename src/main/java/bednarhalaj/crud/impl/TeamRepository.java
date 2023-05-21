package bednarhalaj.crud.impl;

import bednarhalaj.crud.CrudRepository;
import bednarhalaj.model.hierarchy.Team;
import jakarta.persistence.EntityManager;

public class TeamRepository implements CrudRepository<Team> {

    private EntityManager entityManager;

    public TeamRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Team entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public Team read(Class<Team> entityClass, Integer id) {
        entityManager.getTransaction().begin();
        Team team = entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        return team;
    }

    @Override
    public Team update(Team entity) {
        entityManager.getTransaction().begin();
        Team team = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return team;
    }

    @Override
    public void delete(Team entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
