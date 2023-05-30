package bednarhalaj.visitor.crud;

import bednarhalaj.model.EntityManagerHolder;
import bednarhalaj.model.Position;
import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.model.hierarchy.Department;
import bednarhalaj.model.hierarchy.Employee;
import bednarhalaj.model.hierarchy.Team;
import jakarta.persistence.EntityManager;

public abstract class PromptVisitor {

    protected final EntityManager entityManager = EntityManagerHolder.getEntityManager();
    public abstract void visit(Employee employee);

    public abstract void visit(Company company);

    public abstract void visit(Department department);

    public abstract void visit(Team team);

    public abstract void visit(Position position);

}
