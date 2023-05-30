package bednarhalaj.command;

public interface Command<T> {
    T execute();
}