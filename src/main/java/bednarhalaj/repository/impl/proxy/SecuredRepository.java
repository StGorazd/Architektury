package bednarhalaj.repository.impl.proxy;

import bednarhalaj.model.DBEntity;
import bednarhalaj.model.users.User;
import bednarhalaj.output.OutputMediator;
import bednarhalaj.repository.CRUDRepository;

import java.util.List;

public class SecuredRepository<T extends DBEntity> implements CRUDRepository<T> {

    private final CRUDRepository<T> realCRUDRepository;

    private final User user = OutputMediator.getUser();

    public SecuredRepository(CRUDRepository<T> realCRUDRepository) {
        this.realCRUDRepository = realCRUDRepository;
    }

    @Override
    public void create(T entity) throws IllegalAccessException {
        if (user.canCreate()) {
            realCRUDRepository.create(entity);
            return;
        }
        throw new IllegalAccessException();

    }


    @Override
    public List<T> readAll() throws IllegalAccessException {
        if (user.canRead()) {
            return realCRUDRepository.readAll();
        }
        throw new IllegalAccessException();

    }

    @Override
    public T update(T entity) throws IllegalAccessException {
        if (user.canUpdate()) {
            return realCRUDRepository.update(entity);
        }
        throw new IllegalAccessException();

    }

    @Override
    public void delete(T entity) throws IllegalAccessException {
        if (user.canDelete()) {
            realCRUDRepository.delete(entity);
            return;
        }
        throw new IllegalAccessException();

    }
}
