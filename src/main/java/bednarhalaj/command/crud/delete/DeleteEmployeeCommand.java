package bednarhalaj.command.crud.delete;

import bednarhalaj.model.EntityManagerHolder;
import bednarhalaj.model.hierarchy.Employee;
import bednarhalaj.repository.impl.EmployeeRepository;
import jakarta.persistence.EntityManager;

public class DeleteEmployeeCommand extends DeleteCommand<Employee> {
    public DeleteEmployeeCommand(Employee entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        EntityManager entityManager = EntityManagerHolder.getEntityManager();
        EmployeeRepository employeeRepository = new EmployeeRepository(entityManager);
        employeeRepository.delete(entity);
        return null;
    }
}
