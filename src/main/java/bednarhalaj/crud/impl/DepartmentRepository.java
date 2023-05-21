package bednarhalaj.crud.impl;

import bednarhalaj.crud.CrudRepository;
import bednarhalaj.model.hierarchy.Department;
import jakarta.persistence.EntityManager;

public class DepartmentRepository implements CrudRepository<Department> {

    private EntityManager entityManager;

    public DepartmentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Department entity) {
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
    public Department read(Class<Department> entityClass, Integer id) {
        entityManager.getTransaction().begin();
        Department department = entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        return department;
    }

    @Override
    public Department update(Department entity) {
        entityManager.getTransaction().begin();
        Department department = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return department;
    }

    @Override
    public void delete(Department entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
