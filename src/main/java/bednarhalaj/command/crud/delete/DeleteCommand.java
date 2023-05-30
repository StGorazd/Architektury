package bednarhalaj.command.crud.delete;

import bednarhalaj.command.crud.CRUDCommand;
import bednarhalaj.model.DBEntity;

public abstract class DeleteCommand<T extends DBEntity> extends CRUDCommand<T, Void> {
        public DeleteCommand(T entity) {
        super(entity);
    }
}
