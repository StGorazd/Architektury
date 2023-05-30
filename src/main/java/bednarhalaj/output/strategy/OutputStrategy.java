package bednarhalaj.output.strategy;

import bednarhalaj.output.Component;
import bednarhalaj.output.OutputMediator;

import java.util.Scanner;

public abstract class OutputStrategy extends Component {
    protected final Scanner scanner = new Scanner(System.in);

    abstract public void execute();
}
