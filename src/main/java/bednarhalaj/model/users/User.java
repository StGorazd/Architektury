package bednarhalaj.model.users;

public interface User {
    boolean canRead();

    boolean canCreate();

    boolean canUpdate();

    boolean canDelete();
}
