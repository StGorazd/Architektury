package bednarhalaj.command.crud.read;

import bednarhalaj.model.hierarchy.Department;
import bednarhalaj.repository.impl.DepartmentRepository;
import bednarhalaj.repository.impl.proxy.SecuredRepository;

import java.util.ArrayList;
import java.util.List;

public class ReadAllDepartmentsCommand extends ReadCommand<Department> {
    @Override
    public List<Department> execute() {
        DepartmentRepository departmentRepository = new DepartmentRepository(entityManager);
        SecuredRepository<Department> repository = new SecuredRepository<>(departmentRepository);
        try {
            return repository.readAll();
        } catch (IllegalAccessException e) {
            System.out.println("\nAccess denied!\n");
        }
        return new ArrayList<>();
    }
}
