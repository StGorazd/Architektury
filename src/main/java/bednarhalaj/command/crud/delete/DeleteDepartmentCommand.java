package bednarhalaj.command.crud.delete;

import bednarhalaj.model.EntityManagerHolder;
import bednarhalaj.model.hierarchy.Department;
import bednarhalaj.repository.impl.DepartmentRepository;
import jakarta.persistence.EntityManager;

public class DeleteDepartmentCommand extends DeleteCommand<Department> {
    public DeleteDepartmentCommand(Department entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        EntityManager entityManager = EntityManagerHolder.getEntityManager();
        DepartmentRepository departmentRepository = new DepartmentRepository(entityManager);
        departmentRepository.delete(entity);
        return null;
    }
}
