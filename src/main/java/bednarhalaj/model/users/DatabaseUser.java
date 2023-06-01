package bednarhalaj.model.users;

public class DatabaseUser implements User {
    @Override
    public boolean canRead() {
        return false;
    }

    @Override
    public boolean canCreate() {
        return false;
    }

    @Override
    public boolean canUpdate() {
        return false;
    }

    @Override
    public boolean canDelete() {
        return false;
    }
}
