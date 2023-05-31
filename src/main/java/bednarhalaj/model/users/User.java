package bednarhalaj.model.users;

public interface User {
    boolean canRead();

    boolean canWrite();

    boolean canUpdate();

    boolean canDelete();
}
