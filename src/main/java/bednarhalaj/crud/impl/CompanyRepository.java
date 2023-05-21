package bednarhalaj.crud.impl;

import bednarhalaj.crud.CrudRepository;
import bednarhalaj.model.hierarchy.Company;
import jakarta.persistence.EntityManager;

public class CompanyRepository implements CrudRepository<Company> {

    private EntityManager entityManager;

    public CompanyRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Company entity) {
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
    public Company read(Class<Company> entityClass, Integer id) {
        entityManager.getTransaction().begin();
        Company company = entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        return company;
    }

    @Override
    public Company update(Company entity) {
        entityManager.getTransaction().begin();
        Company company = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return company;
    }

    @Override
    public void delete(Company entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
