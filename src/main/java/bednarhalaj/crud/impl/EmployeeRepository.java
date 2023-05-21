package bednarhalaj.crud.impl;

import bednarhalaj.crud.CrudRepository;
import bednarhalaj.model.hierarchy.Employee;
import jakarta.persistence.EntityManager;

public class EmployeeRepository implements CrudRepository<Employee> {

    private EntityManager entityManager;

    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Employee entity) {
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
    public Employee read(Class<Employee> entityClass, Integer id) {
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        return employee;
    }

    @Override
    public Employee update(Employee entity) {
        entityManager.getTransaction().begin();
        Employee employee = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return employee;
    }

    @Override
    public void delete(Employee entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
