package builder;

import bednarhalaj.model.hierarchy.Company;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompanyBuilderTest {

    @Test
    public void companyBuild() {
        Company company = new Company.Builder("Google").build();
        Assertions.assertEquals("Google", company.getName());
    }
}
