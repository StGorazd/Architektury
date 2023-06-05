package bednarhalaj.command.crud.read;

import bednarhalaj.command.crud.CRUDCommand;
import bednarhalaj.model.DBEntity;
import bednarhalaj.model.EntityManagerHolder;
import jakarta.persistence.EntityManager;

import java.util.List;

public abstract class ReadAllCommand<T extends DBEntity> extends CRUDCommand<T, List<T>> {

    protected final EntityManager entityManager = EntityManagerHolder.getEntityManager();
}
