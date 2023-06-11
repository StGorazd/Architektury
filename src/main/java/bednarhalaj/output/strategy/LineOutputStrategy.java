package bednarhalaj.output.strategy;

public class LineOutputStrategy extends OutputStrategy {

    private final String line;

    public LineOutputStrategy(String line) {
        this.line = line;
    }

    @Override
    public void execute() {
        System.out.println(line);
        System.out.println();
        manager.process(null);
    }
}
