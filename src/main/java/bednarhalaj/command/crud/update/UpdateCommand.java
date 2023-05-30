package bednarhalaj.command.crud.update;

import bednarhalaj.command.crud.CRUDCommand;
import bednarhalaj.model.DBEntity;
import bednarhalaj.visitor.crud.PromptVisitor;
import bednarhalaj.visitor.crud.UpdateVisitor;

public abstract class UpdateCommand<T extends DBEntity> extends CRUDCommand<T, Void> {

    protected final PromptVisitor visitor = new UpdateVisitor();

    public UpdateCommand(T entity) {
        super(entity);
    }
}
