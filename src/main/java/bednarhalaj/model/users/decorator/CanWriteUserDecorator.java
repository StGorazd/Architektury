package bednarhalaj.model.users.decorator;

import bednarhalaj.model.users.User;

public class CanWriteUserDecorator extends UserDecorator {

    public CanWriteUserDecorator(User user) {
        super(user);
    }

    @Override
    public boolean canWrite() {
        return true;
    }
}
