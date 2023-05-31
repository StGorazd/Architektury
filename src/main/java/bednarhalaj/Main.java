package bednarhalaj;


import bednarhalaj.model.EntityManagerHolder;
import bednarhalaj.model.users.db.DBUser;
import bednarhalaj.model.users.db.Role;
import bednarhalaj.output.OutputMediator;
import bednarhalaj.repository.impl.DBUserRepository;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        OutputMediator mediator = new OutputMediator();
        mediator.start();
    }
}