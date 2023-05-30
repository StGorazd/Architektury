package bednarhalaj.output.items;

import bednarhalaj.model.DBEntity;
public enum DBEntityMenuItem implements MenuItem<DBEntity> {

    ITEM(null);

    private DBEntity label;

    DBEntityMenuItem(DBEntity label) {
        this.label = label;
    }


    @Override
    public DBEntity getLabel() {
        return this.label;
    }

    @Override
    public void setLabel(DBEntity label) {
        this.label = label;

    }
}
