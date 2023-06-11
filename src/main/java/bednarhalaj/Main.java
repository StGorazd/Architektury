package bednarhalaj;


import bednarhalaj.output.Manager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        /*DBUserRepository dbUserRepository = new DBUserRepository(EntityManagerHolder.getEntityManager());

        DBUser dbUser0 = new DBUser();
        dbUser0.setName("Admin");
        dbUser0.setPassword("admin");
        dbUser0.setRole(Role.ADMIN);
        dbUserRepository.create(dbUser0);

        DBUser dbUser = new DBUser();
        dbUser.setName("Editor");
        dbUser.setPassword("editor");
        dbUser.setRole(Role.EDITOR);
        dbUserRepository.create(dbUser);

        DBUser dbUser2 = new DBUser();
        dbUser2.setName("Reader");
        dbUser2.setPassword("reader");
        dbUser2.setRole(Role.READER);
        dbUserRepository.create(dbUser2);*/

        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        Manager mediator = new Manager();
        mediator.start();
    }
}