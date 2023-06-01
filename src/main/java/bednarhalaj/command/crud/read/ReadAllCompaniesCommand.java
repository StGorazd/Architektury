package bednarhalaj.command.crud.read;

import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.repository.impl.CompanyRepository;
import bednarhalaj.repository.impl.proxy.SecuredRepository;

import java.util.ArrayList;
import java.util.List;

public class ReadAllCompaniesCommand extends ReadCommand<Company> {
    @Override
    public List<Company> execute() {
        CompanyRepository companyRepository = new CompanyRepository(entityManager);
        SecuredRepository<Company> repository = new SecuredRepository<>(companyRepository);
        try {
            return repository.readAll();
        } catch (IllegalAccessException e) {
            System.out.println("\nAccess denied!\n");
        }
        return new ArrayList<>();
    }
}
