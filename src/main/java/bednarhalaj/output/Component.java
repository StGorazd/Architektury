package bednarhalaj.output;

public abstract class Component {

    protected OutputMediator outputMediator;

    public void setMediator(OutputMediator outputMediator) {
        this.outputMediator = outputMediator;
    }

    abstract public void execute();


}
