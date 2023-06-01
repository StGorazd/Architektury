package bednarhalaj.command.crud.read;

import bednarhalaj.model.users.db.DBUser;
import bednarhalaj.repository.impl.DBUserRepository;

import java.util.List;

public class ReadAllUsersCommand extends ReadCommand<DBUser> {
    @Override
    public List<DBUser> execute() {
        DBUserRepository dbUserRepository = new DBUserRepository(entityManager);
        return dbUserRepository.readAll();
    }
}
