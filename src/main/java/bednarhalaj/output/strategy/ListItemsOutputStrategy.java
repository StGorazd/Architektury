package bednarhalaj.output.strategy;

import bednarhalaj.output.items.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ListItemsOutputStrategy extends OutputStrategy {

    private final List<MenuItem<?>> items;

    private final String ERROR = "Something went wrong, try again!\n";

    public ListItemsOutputStrategy(MenuItem<?>... menuItems) {
        items = new ArrayList<>(List.of(menuItems));
    }

    @Override
    public void execute() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getLabel());
        }
        System.out.println();
        MenuItem<?> item;
        while (true) {
            System.out.print("Choose: ");
            try {
                int input = Integer.parseInt(scanner.nextLine());
                item = items.get(input - 1);
                break;
            } catch (Exception e) {
                System.out.println(ERROR);
            }
        }
        outputMediator.notify(item);
    }
}
