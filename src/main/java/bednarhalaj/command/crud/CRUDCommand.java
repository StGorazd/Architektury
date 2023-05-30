package bednarhalaj.command.crud;

import bednarhalaj.model.DBEntity;
import bednarhalaj.command.Command;

public abstract class CRUDCommand<T extends DBEntity, R> implements Command<R> {

    protected T entity;

    public CRUDCommand(T entity) {
        this.entity = entity;
    }

    public CRUDCommand() {

    }
}
