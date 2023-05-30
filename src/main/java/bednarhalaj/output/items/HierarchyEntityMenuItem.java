package bednarhalaj.output.items;

import bednarhalaj.model.hierarchy.HierarchyEntity;

public enum HierarchyEntityMenuItem implements MenuItem<HierarchyEntity> {
    ITEM(null);
    private HierarchyEntity label;

    HierarchyEntityMenuItem(HierarchyEntity label) {
        this.label = label;
    }


    @Override
    public HierarchyEntity getLabel() {
        return this.label;
    }

    @Override
    public void setLabel(HierarchyEntity label) {
        this.label = label;

    }
}
