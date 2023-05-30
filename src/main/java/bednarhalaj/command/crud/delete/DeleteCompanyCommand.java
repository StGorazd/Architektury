package bednarhalaj.command.crud.delete;

import bednarhalaj.model.EntityManagerHolder;
import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.repository.impl.CompanyRepository;
import bednarhalaj.repository.impl.EmployeeRepository;
import jakarta.persistence.EntityManager;

public class DeleteCompanyCommand extends DeleteCommand<Company> {
    public DeleteCompanyCommand(Company entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        EntityManager entityManager = EntityManagerHolder.getEntityManager();
        CompanyRepository companyRepository = new CompanyRepository(entityManager);
        companyRepository.delete(entity);
        return null;

    }
}
