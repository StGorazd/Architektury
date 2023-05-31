package bednarhalaj.model.users.decorator;

import bednarhalaj.model.users.User;

public abstract class UserDecorator implements User {

    protected User user;

    public UserDecorator(User user) {
        this.user = user;
    }

    public boolean canRead() {
        return user.canRead();
    }

    public boolean canWrite() {
        return user.canWrite();
    }

    public boolean canUpdate() {
        return user.canUpdate();
    }

    public boolean canDelete() {
        return user.canDelete();
    }

}
