package bednarhalaj;


import bednarhalaj.crud.impl.*;
import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.model.hierarchy.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bednarhalaj.jpa")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            CompanyRepository companyRepository = new CompanyRepository(entityManager);
            DepartmentRepository departmentRepository = new DepartmentRepository(entityManager);
            TeamRepository teamRepository = new TeamRepository(entityManager);
            EmployeeRepository employeeRepository = new EmployeeRepository(entityManager);
            PositionRepository positionRepository = new PositionRepository(entityManager);

            Company company = new Company();
            company.setName("Google");
            companyRepository.create(company);
            Company retrievedCompany = companyRepository.read(Company.class, company.getId());
            assert retrievedCompany.equals(company);

            Department department = new Department();
            department.setCompany(company);
            company.addSubordinate(department);
            department.setName("HR");
            departmentRepository.create(department);
            companyRepository.update(company);

            retrievedCompany = companyRepository.read(Company.class, company.getId());
            assert retrievedCompany.getSubordinates().size() == 1;


        }

    }
}