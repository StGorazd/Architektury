package bednarhalaj;

import bednarhalaj.repository.DepartmentRepository;
import bednarhalaj.repository.EmployeeRepository;
import bednarhalaj.repository.PositionRepository;
import bednarhalaj.repository.TeamRepository;

public class Main {
    public static void main(String[] args) {
        DepartmentRepository departmentRepository = new DepartmentRepository();
        TeamRepository teamRepository = new TeamRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        PositionRepository positionRepository = new PositionRepository();
    }
}