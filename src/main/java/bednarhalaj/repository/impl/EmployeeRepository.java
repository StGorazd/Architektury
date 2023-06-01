package bednarhalaj.repository.impl;

import bednarhalaj.repository.CRUDRepository;
import bednarhalaj.model.hierarchy.Employee;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EmployeeRepository implements CRUDRepository<Employee> {

    private final EntityManager entityManager;

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
                e.printStackTrace();
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
    public List<Employee> readAll() {
        entityManager.getTransaction().begin();
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e" , Employee.class).getResultList();
        entityManager.getTransaction().commit();
        return employees;
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
