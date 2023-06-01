package bednarhalaj.output.items;

import bednarhalaj.model.users.db.DBUser;

public enum LoginMenuItem implements MenuItem<DBUser> {
    PASSWORD_MATCH(null), PASSWORD_MISMATCH(null);

    private DBUser dbUser;

    LoginMenuItem(DBUser dbUser) {
        this.dbUser = dbUser;
    }

    @Override
    public DBUser getLabel() {
        return dbUser;
    }

    @Override
    public void setLabel(DBUser label) {
        this.dbUser = label;

    }
}
