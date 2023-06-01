package bednarhalaj.output.strategy;

import bednarhalaj.output.OutputMediator;

import java.util.Scanner;

public abstract class OutputStrategy {
    protected final Scanner scanner = new Scanner(System.in);

    protected OutputMediator outputMediator;

    public void setMediator(OutputMediator outputMediator) {
        this.outputMediator = outputMediator;
    }

    abstract public void execute();
}
