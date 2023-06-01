package bednarhalaj.visitor.crud;

import bednarhalaj.command.crud.read.*;
import bednarhalaj.model.Position;
import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.model.hierarchy.Department;
import bednarhalaj.model.hierarchy.Employee;
import bednarhalaj.model.hierarchy.Team;
import bednarhalaj.repository.impl.*;
import bednarhalaj.repository.impl.proxy.SecuredRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class UpdateVisitor extends PromptVisitor {

    private final Scanner scanner = new Scanner(System.in);

    private final String ERROR = "Something went wrong, try again!\n";

    @Override
    public void visit(Employee employee) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        List<String> fields = List.of("First name", "Surname", "Email", "Birthdate", "Address", "Employee since", "Salary bonus", "Position", "Team");
        for (int i = 0; i < fields.size(); i++) {
            System.out.println((i + 1) + ". " + fields.get(i));
        }
        System.out.print("Choose: ");
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }

        switch (input) {
            case 1 -> {
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
            }
            case 2 -> {
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
            }
            case 3 -> {
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

            }
            case 4 -> {
                while (true) {
                    try {
                        String birthdate = getField("Birthdate (dd.MM.yyyy)");
                        employee.setBirthdate(LocalDate.parse(birthdate, formatter));
                        break;
                    } catch (Exception e) {
                        System.out.println(ERROR);
                    }
                }

            }
            case 5 -> {
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

            }
            case 6 -> {
                while (true) {
                    try {
                        String employeeSince = getField("Employee since (dd.MM.yyyy)");
                        employee.setEmployeeSince(LocalDate.parse(employeeSince, formatter));
                        break;
                    } catch (Exception e) {
                        System.out.println(ERROR);
                    }
                }

            }
            case 7 -> {
                while (true) {
                    try {
                        String salaryBonus = getField("Salary bonus");
                        employee.setSalaryBonus(BigDecimal.valueOf(Long.parseLong(salaryBonus)));
                        break;
                    } catch (Exception e) {
                        System.out.println(ERROR);
                    }
                }

            }
            case 8 -> {
                while (true) {
                    try {
                        ReadCommand<Position> positionReadCommand = new ReadAllPositionsCommand();
                        List<Position> positions = positionReadCommand.execute();
                        for (int i = 0; i < positions.size(); i++) {
                            System.out.println((i + 1) + ". " + positions.get(i).toString());
                        }
                        System.out.println((positions.size() + 1) + ". " + "NO POSITION");

                        System.out.print("Choose position: ");

                        int positionIndex = scanner.nextInt() - 1;

                        if (positionIndex == positions.size()) {
                            employee.setPosition(null);
                        } else {
                            employee.setPosition(positions.get(positionIndex));
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println(ERROR);
                    }
                }

            }
            case 9 -> {
                while (true) {
                    try {
                        String salaryBonus = getField("Salary bonus");
                        employee.setSalaryBonus(BigDecimal.valueOf(Long.parseLong(salaryBonus)));
                        break;
                    } catch (Exception e) {
                        System.out.println(ERROR);
                    }
                }
                ReadCommand<Team> teamReadCommand = new ReadAllTeamsCommand();
                List<Team> teams = teamReadCommand.execute();
                for (int i = 0; i < teams.size(); i++) {
                    System.out.println((i + 1) + ". " + teams.get(i).toString());
                }
                System.out.println((teams.size() + 1) + ". " + "NO TEAM");

                System.out.print("Choose team: ");

                int teamIndex = scanner.nextInt() - 1;
                TeamRepository teamRepository = new TeamRepository(entityManager);

                if (teamIndex == teams.size()) {
                    employee.getTeam().removeSubordinate(employee);
                    teamRepository.update(employee.getTeam());
                    employee.setTeam(null);
                } else {
                    if (employee.getTeam() != null) {
                        employee.getTeam().removeSubordinate(employee);
                        teamRepository.update(employee.getTeam());
                    }
                    employee.setTeam(teams.get(teamIndex));
                    teams.get(teamIndex).addSubordinate(employee);
                    teamRepository.update(teams.get(teamIndex));
                }


            }
            default -> {
                System.out.println(ERROR);
                visit(employee);
                return;
            }
        }

        EmployeeRepository employeeRepository = new EmployeeRepository(entityManager);
        SecuredRepository<Employee> repository = new SecuredRepository<>(employeeRepository);
        try {
            repository.update(employee);
        } catch (IllegalAccessException e) {
            System.out.println("\nAccess denied!\n");
        }
    }

    @Override
    public void visit(Company company) {
        List<String> fields = List.of("Name");
        for (int i = 0; i < fields.size(); i++) {
            System.out.println((i + 1) + ". " + fields.get(i));
        }
        System.out.print("Choose: ");
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }

        if (input == 1) {
            while (true) {
                try {
                    String name = getField("Name");
                    if (name.isEmpty()) {
                        throw new IllegalAccessException();
                    }
                    company.setName(name);
                    break;
                } catch (Exception e) {
                    System.out.println(ERROR);
                }
            }
        } else {
            System.out.println(ERROR);
            visit(company);
            return;
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
        List<String> fields = List.of("Name", "Company");
        for (int i = 0; i < fields.size(); i++) {
            System.out.println((i + 1) + ". " + fields.get(i));
        }
        System.out.print("Choose: ");
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }

        switch (input) {
            case 1 -> {
                while (true) {
                    try {
                        String name = getField("Name");
                        if (name.isEmpty()) {
                            throw new IllegalAccessException();
                        }
                        department.setName(name);
                        break;
                    } catch (Exception e) {
                        System.out.println(ERROR);
                    }
                }
            }
            case 2 -> {
                while (true) {
                    try {
                        ReadCommand<Company> companyReadCommand = new ReadAllCompaniesCommand();
                        List<Company> companies = companyReadCommand.execute();
                        for (int i = 0; i < companies.size(); i++) {
                            System.out.println((i + 1) + ". " + companies.get(i).toString());
                        }
                        System.out.println((companies.size() + 1) + ". " + "NO COMPANY");

                        System.out.print("Choose company: ");
                        int companyIndex = scanner.nextInt() - 1;

                        CompanyRepository companyRepository = new CompanyRepository(entityManager);

                        if (companyIndex == companies.size()) {
                            department.getCompany().removeSubordinate(department);
                            companyRepository.update(department.getCompany());
                            department.setCompany(null);
                        } else {
                            if (department.getCompany() != null) {
                                department.getCompany().removeSubordinate(department);
                                companyRepository.update(department.getCompany());
                            }
                            department.setCompany(companies.get(companyIndex));
                            companies.get(companyIndex).addSubordinate(department);
                            companyRepository.update(companies.get(companyIndex));
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println(ERROR);
                    }
                }


            }
            default -> {
                System.out.println(ERROR);
                visit(department);
                return;
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
        List<String> fields = List.of("Name", "Department");
        for (int i = 0; i < fields.size(); i++) {
            System.out.println((i + 1) + ". " + fields.get(i));
        }
        System.out.print("Choose: ");
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }

        switch (input) {
            case 1 -> {
                while (true) {
                    try {
                        String name = getField("Name");
                        team.setName(name);
                        break;
                    } catch (Exception e) {
                        System.out.println(ERROR);
                    }
                }
            }
            case 2 -> {
                while (true) {
                    try {
                        ReadCommand<Department> departmentReadCommand = new ReadAllDepartmentsCommand();
                        List<Department> departments = departmentReadCommand.execute();
                        for (int i = 0; i < departments.size(); i++) {
                            System.out.println((i + 1) + ". " + departments.get(i).toString());
                        }
                        System.out.println((departments.size() + 1) + ". " + "NO DEPARTMENT");

                        System.out.print("Choose department: ");

                        int departmentIndex = scanner.nextInt() - 1;
                        DepartmentRepository departmentRepository = new DepartmentRepository(entityManager);

                        if (departmentIndex == departments.size()) {
                            team.getDepartment().removeSubordinate(team);
                            departmentRepository.update(team.getDepartment());
                            team.setDepartment(null);
                        } else {
                            if (team.getDepartment() != null) {
                                team.getDepartment().removeSubordinate(team);
                                departmentRepository.update(team.getDepartment());
                            }
                            team.setDepartment(departments.get(departmentIndex));
                            departments.get(departmentIndex).addSubordinate(team);
                            departmentRepository.update(team.getDepartment());
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println(ERROR);
                    }
                }


            }
            default -> {
                System.out.println(ERROR);
                visit(team);
                return;
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
        List<String> fields = List.of("Name", "Base Salary");
        for (int i = 0; i < fields.size(); i++) {
            System.out.println((i + 1) + ". " + fields.get(i));
        }
        System.out.print("Choose: ");
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }

        switch (input) {
            case 1 -> {
                while (true) {
                    try {
                        String name = getField("Name");
                        if (name.isEmpty()) {
                            throw new IllegalAccessException();
                        }
                        position.setName(name);
                        break;
                    } catch (Exception e) {
                        System.out.println(ERROR);
                    }
                }
            }
            case 2 -> {
                while (true) {
                    try {
                        String baseSalary = getField("Base Salary");
                        position.setBaseSalary(BigDecimal.valueOf(Long.parseLong(baseSalary)));
                        break;
                    } catch (Exception e) {
                        System.out.println(ERROR);
                    }
                }
            }
            default -> {
                System.out.println(ERROR);
                visit(position);
                return;
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
