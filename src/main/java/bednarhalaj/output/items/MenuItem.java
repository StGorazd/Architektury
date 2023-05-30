package bednarhalaj.output.items;

public interface MenuItem<T> {
    T getLabel();

    void setLabel(T label);
}
