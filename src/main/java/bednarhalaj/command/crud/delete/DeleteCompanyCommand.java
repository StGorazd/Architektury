package bednarhalaj.command.crud.delete;

import bednarhalaj.model.EntityManagerHolder;
import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.repository.impl.CompanyRepository;
import bednarhalaj.repository.impl.proxy.SecuredRepository;
import jakarta.persistence.EntityManager;

public class DeleteCompanyCommand extends DeleteCommand<Company> {
    public DeleteCompanyCommand(Company entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        EntityManager entityManager = EntityManagerHolder.getInstance();
        CompanyRepository companyRepository = new CompanyRepository(entityManager);
        SecuredRepository<Company> repository = new SecuredRepository<>(companyRepository);
        try {
            repository.delete(entity);
        } catch (IllegalAccessException e) {
            System.out.println("\nAccess denied!\n");
        }
        return null;

    }
}
