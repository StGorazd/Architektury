package bednarhalaj.visitor.crud;

import bednarhalaj.model.Position;
import bednarhalaj.repository.impl.*;
import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.model.hierarchy.Department;
import bednarhalaj.model.hierarchy.Employee;
import bednarhalaj.model.hierarchy.Team;
import bednarhalaj.repository.impl.proxy.SecuredRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateVisitor extends PromptVisitor {

    private final Scanner scanner = new Scanner(System.in);

    private final String ERROR = "Something went wrong, try again!\n";

    @Override
    public void visit(Employee employee) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        while (true) {
            try {
                String firstName = getField("First name");
                if (firstName.isEmpty()) {
                    throw new IllegalAccessException();
                }
                employee.setFirstname(firstName);
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }

        while (true) {
            try {
                String surname = getField("Surname");
                if (surname.isEmpty()) {
                    throw new IllegalAccessException();
                }
                employee.setSurname(surname);
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }

        while (true) {
            try {
                String email = getField("Email");
                if (email.isEmpty()) {
                    throw new IllegalAccessException();
                }
                employee.setEmail(email);
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }

        while (true) {
            try {
                String birthdate = getField("Birthdate (dd.MM.yyyy)");
                employee.setBirthdate(LocalDate.parse(birthdate, formatter));
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }

        while (true) {
            try {
                String address = getField("Address");
                if (address.isEmpty()) {
                    throw new IllegalAccessException();
                }
                employee.setAddress(address);
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }

        while (true) {
            try {
                String employeeSince = getField("Employee since (dd.MM.yyyy)");
                employee.setEmployeeSince(LocalDate.parse(employeeSince, formatter));
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }
        while (true) {
            try {
                String salaryBonus = getField("Salary bonus");
                employee.setSalaryBonus(BigDecimal.valueOf(Long.parseLong(salaryBonus)));
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }

        EmployeeRepository employeeRepository = new EmployeeRepository(entityManager);
        SecuredRepository<Employee> repository = new SecuredRepository<>(employeeRepository);
        try {
            repository.create(employee);
        } catch (IllegalAccessException e) {
            System.out.println("\nAccess denied!\n");
        }
    }

    @Override
    public void visit(Company company) {
        while (true) {
            try {
                String name = getField("name");
                if (name.isEmpty()) {
                    throw new IllegalAccessException();
                }
                company.setName(name);
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }

        CompanyRepository companyRepository = new CompanyRepository(entityManager);
        SecuredRepository<Company> repository = new SecuredRepository<>(companyRepository);
        try {
            repository.create(company);
        } catch (IllegalAccessException e) {
            System.out.println("\nAccess denied!\n");
        }
    }

    @Override
    public void visit(Department department) {
        while (true) {
            try {
                String name = getField("name");
                if (name.isEmpty()) {
                    throw new IllegalAccessException();
                }
                department.setName(name);
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }
        DepartmentRepository departmentRepository = new DepartmentRepository(entityManager);
        SecuredRepository<Department> repository = new SecuredRepository<>(departmentRepository);
        try {
            repository.create(department);
        } catch (IllegalAccessException e) {
            System.out.println("\nAccess denied!\n");
        }

    }

    @Override
    public void visit(Team team) {
        while (true) {
            try {
                String name = getField("name");
                if (name.isEmpty()) {
                    throw new IllegalAccessException();
                }
                team.setName(name);
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }

        TeamRepository teamRepository = new TeamRepository(entityManager);
        SecuredRepository<Team> repository = new SecuredRepository<>(teamRepository);
        try {
            repository.create(team);
        } catch (IllegalAccessException e) {
            System.out.println("\nAccess denied!\n");
        }

    }

    @Override
    public void visit(Position position) {
        while (true) {
            try {
                String name = getField("name");
                if (name.isEmpty()) {
                    throw new IllegalAccessException();
                }
                position.setName(name);
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }

        while (true) {
            try {
                String salary = getField("Salary");
                position.setBaseSalary(BigDecimal.valueOf(Long.parseLong(salary)));
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }

        PositionRepository positionRepository = new PositionRepository(entityManager);
        SecuredRepository<Position> repository = new SecuredRepository<>(positionRepository);
        try {
            repository.create(position);
        } catch (IllegalAccessException e) {
            System.out.println("\nAccess denied!\n");
        }

    }

    private String getField(String name) {
        System.out.print(name + ": ");
        return scanner.nextLine();
    }
}
