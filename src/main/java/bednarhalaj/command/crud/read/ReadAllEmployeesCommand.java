package bednarhalaj.command.crud.read;

import bednarhalaj.model.hierarchy.Employee;
import bednarhalaj.repository.impl.EmployeeRepository;
import bednarhalaj.repository.impl.proxy.SecuredRepository;

import java.util.ArrayList;
import java.util.List;

public class ReadAllEmployeesCommand extends ReadCommand<Employee> {
    @Override
    public List<Employee> execute() {
        EmployeeRepository employeeRepository = new EmployeeRepository(entityManager);
        SecuredRepository<Employee> repository = new SecuredRepository<>(employeeRepository);
        try {
            return repository.readAll();
        } catch (IllegalAccessException e) {
            System.out.println("\nAccess denied!\n");
        }
        return new ArrayList<>();
    }
}
