package bednarhalaj.repository.impl;

import bednarhalaj.repository.CRUDRepository;
import bednarhalaj.model.hierarchy.Department;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DepartmentRepository implements CRUDRepository<Department> {

    private final EntityManager entityManager;

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
    public List<Department> readAll() {
        entityManager.getTransaction().begin();
        List<Department> departments = entityManager.createQuery("SELECT d FROM Department d ", Department.class).getResultList();
        entityManager.getTransaction().commit();
        return departments;
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
