package bednarhalaj.crud.impl;

import bednarhalaj.crud.CrudRepository;
import bednarhalaj.model.requests.job.JobRequest;
import jakarta.persistence.EntityManager;

public class JobRequestRepository implements CrudRepository<JobRequest> {

    private EntityManager entityManager;

    public JobRequestRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(JobRequest entity) {
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
    public JobRequest read(Class<JobRequest> entityClass, Integer id) {
        entityManager.getTransaction().begin();
        JobRequest jobRequest = entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        return jobRequest;
    }

    @Override
    public JobRequest update(JobRequest entity) {
        entityManager.getTransaction().begin();
        JobRequest jobRequest = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return jobRequest;
    }

    @Override
    public void delete(JobRequest entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
