package bednarhalaj.repository.impl;

import bednarhalaj.repository.CRUDRepository;
import bednarhalaj.model.hierarchy.Team;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TeamRepository implements CRUDRepository<Team> {

    private final EntityManager entityManager;

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
    public List<Team> readAll() {
        entityManager.getTransaction().begin();
        List<Team> teams = entityManager.createQuery("SELECT t FROM Team t", Team.class).getResultList();
        entityManager.getTransaction().commit();
        return teams;
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
