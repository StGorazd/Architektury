package bednarhalaj.command.crud.create;

import bednarhalaj.command.crud.CRUDCommand;
import bednarhalaj.model.DBEntity;
import bednarhalaj.visitor.crud.CreateVisitor;
import bednarhalaj.visitor.crud.PromptVisitor;

public abstract class CreateCommand<T extends DBEntity> extends CRUDCommand<T, Void> {

    protected final PromptVisitor visitor = new CreateVisitor();

    public CreateCommand(T entity) {
        super(entity);
    }

}
