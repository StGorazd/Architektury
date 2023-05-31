package bednarhalaj.repository.impl;

import bednarhalaj.model.users.db.DBUser;
import bednarhalaj.repository.CrudRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DBUserRepository implements CrudRepository<DBUser> {
    private final EntityManager entityManager;

    public DBUserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(DBUser entity) {
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
    public DBUser read(Class<DBUser> entityClass, Integer id) {
        entityManager.getTransaction().begin();
        DBUser user = entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public List<DBUser> readAll() {
        entityManager.getTransaction().begin();
        List<DBUser> users = entityManager.createQuery("SELECT u FROM DBUser u", DBUser.class).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    @Override
    public DBUser update(DBUser entity) {
        entityManager.getTransaction().begin();
        DBUser user = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public void delete(DBUser entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}