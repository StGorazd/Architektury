package bednarhalaj.command.crud.read;

import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.repository.impl.CompanyRepository;
import bednarhalaj.repository.impl.DepartmentRepository;

import java.util.List;

public class ReadAllCompaniesCommand extends ReadCommand<Company> {
    @Override
    public List<Company> execute() {
        CompanyRepository companyRepository = new CompanyRepository(entityManager);
        return companyRepository.readAll();
    }
}
