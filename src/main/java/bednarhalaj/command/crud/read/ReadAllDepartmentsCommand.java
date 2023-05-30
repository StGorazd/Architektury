package bednarhalaj.command.crud.read;

import bednarhalaj.model.hierarchy.Department;
import bednarhalaj.repository.impl.DepartmentRepository;
import bednarhalaj.repository.impl.EmployeeRepository;

import java.util.List;

public class ReadAllDepartmentsCommand extends ReadCommand<Department> {
    @Override
    public List<Department> execute() {
        DepartmentRepository departmentRepository = new DepartmentRepository(entityManager);
        return departmentRepository.readAll();
    }
}
