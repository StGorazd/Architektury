package bednarhalaj.command.crud.read;

import bednarhalaj.model.EntityManagerHolder;
import bednarhalaj.model.hierarchy.Employee;
import bednarhalaj.repository.impl.EmployeeRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ReadAllEmployeesCommand extends ReadCommand<Employee> {
    @Override
    public List<Employee> execute() {
        EmployeeRepository employeeRepository = new EmployeeRepository(entityManager);
        return employeeRepository.readAll();
    }
}
