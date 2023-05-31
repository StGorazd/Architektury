package bednarhalaj.model.users.decorator;

import bednarhalaj.model.users.User;

public class CanReadUserDecorator extends UserDecorator {

    public CanReadUserDecorator(User user) {
        super(user);
    }

    @Override
    public boolean canRead() {
        return true;
    }
}

