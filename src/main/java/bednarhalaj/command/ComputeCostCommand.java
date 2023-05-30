package bednarhalaj.command;

import bednarhalaj.model.hierarchy.HierarchyEntity;

import java.math.BigDecimal;

public class ComputeCostCommand<T extends HierarchyEntity> implements Command<BigDecimal> {

    private final T entity;

    public ComputeCostCommand(T entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal execute() {
        return entity.getCost();
    }
}
