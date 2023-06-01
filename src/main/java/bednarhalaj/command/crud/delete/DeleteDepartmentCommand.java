package bednarhalaj.command.crud.delete;

import bednarhalaj.model.EntityManagerHolder;
import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.model.hierarchy.Department;
import bednarhalaj.repository.impl.DepartmentRepository;
import bednarhalaj.repository.impl.proxy.SecuredRepository;
import jakarta.persistence.EntityManager;

public class DeleteDepartmentCommand extends DeleteCommand<Department> {
    public DeleteDepartmentCommand(Department entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        EntityManager entityManager = EntityManagerHolder.getEntityManager();
        DepartmentRepository departmentRepository = new DepartmentRepository(entityManager);
        SecuredRepository<Department> repository = new SecuredRepository<>(departmentRepository);
        try {
            repository.delete(entity);
        } catch (IllegalAccessException e) {
            System.out.println("\nAccess denied!\n");
        }
        return null;
    }
}
