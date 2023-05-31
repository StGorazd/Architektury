package bednarhalaj.model.users.decorator;

import bednarhalaj.model.users.User;

public class CanUpdateUserDecorator extends UserDecorator {

    public CanUpdateUserDecorator(User user) {
        super(user);
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

}
