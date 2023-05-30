package bednarhalaj.command;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor<T> {
    private final List<Command<T>> commands = new ArrayList<>();

    public void executeCommand (Command<T> command) {
        commands.add(command);
        command.execute();
    }

}
