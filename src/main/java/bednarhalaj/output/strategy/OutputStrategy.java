package bednarhalaj.output.strategy;

import bednarhalaj.output.Manager;

import java.util.Scanner;

public abstract class OutputStrategy {
    protected final Scanner scanner = new Scanner(System.in);

    protected Manager manager;

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    abstract public void execute();
}
