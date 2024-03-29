package bednarhalaj.output.items;

public enum ActionMenuItem implements MenuItem<String> {

    CREATE("Create a new entity"),
    UPDATE("Update an entity"),
    DELETE("Delete an entity"),
    READ("List all entities"),
    COMPUTE_COST("Compute cost"),
    BACK("Go back"),

    EXIT("Exit");

    private String label;

    ActionMenuItem(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }
}
