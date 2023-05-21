package bednarhalaj.crud.impl;

import bednarhalaj.crud.CrudRepository;
import bednarhalaj.model.Position;
import bednarhalaj.model.hierarchy.Team;
import jakarta.persistence.EntityManager;

public class PositionRepository implements CrudRepository<Position> {

    private EntityManager entityManager;

    public PositionRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Position entity) {
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
    public Position read(Class<Position> entityClass, Integer id) {
        entityManager.getTransaction().begin();
        Position position = entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        return position;
    }

    @Override
    public Position update(Position entity) {
        entityManager.getTransaction().begin();
        Position position = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return position;
    }

    @Override
    public void delete(Position entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
