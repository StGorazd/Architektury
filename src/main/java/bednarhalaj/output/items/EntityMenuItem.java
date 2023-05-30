package bednarhalaj.output.items;

public enum EntityMenuItem implements MenuItem<String> {
    EMPLOYEE("Employee"),
    TEAM("Team"),
    DEPARTMENT("Department"),
    COMPANY("Company"),
    POSITION("Position");
    private String label;

    EntityMenuItem(String label) {
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
