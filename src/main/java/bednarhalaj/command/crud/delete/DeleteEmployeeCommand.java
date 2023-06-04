package bednarhalaj.command.crud.delete;

import bednarhalaj.model.EntityManagerHolder;
import bednarhalaj.model.hierarchy.Employee;
import bednarhalaj.repository.impl.EmployeeRepository;
import bednarhalaj.repository.impl.proxy.SecuredRepository;
import jakarta.persistence.EntityManager;

public class DeleteEmployeeCommand extends DeleteCommand<Employee> {
    public DeleteEmployeeCommand(Employee entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        EntityManager entityManager = EntityManagerHolder.getInstance();
        EmployeeRepository employeeRepository = new EmployeeRepository(entityManager);
        SecuredRepository<Employee> repository = new SecuredRepository<>(employeeRepository);
        try {
            repository.delete(entity);
        } catch (IllegalAccessException e) {
            System.out.println("\nAccess denied!\n");
        }
        return null;
    }
}
