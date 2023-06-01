package bednarhalaj.repository.impl;

import bednarhalaj.repository.CRUDRepository;
import bednarhalaj.model.Position;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PositionRepository implements CRUDRepository<Position> {

    private final EntityManager entityManager;

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
    public List<Position> readAll() {
        entityManager.getTransaction().begin();
        List<Position> positions = entityManager.createQuery("SELECT p FROM Position p", Position.class).getResultList();
        entityManager.getTransaction().commit();
        return positions;
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
