package bednarhalaj.output.strategy;

import bednarhalaj.model.DBEntity;
import bednarhalaj.model.hierarchy.HierarchyEntity;
import bednarhalaj.output.items.DBEntityMenuItem;

import java.util.List;

public class ListDBEntityOutputStrategy extends OutputStrategy {

    private final String ERROR = "Something went wrong, try again!\n";
    List<? extends DBEntity> entityList;

    private final boolean choose;

    public ListDBEntityOutputStrategy(List<? extends DBEntity> entityList, boolean choose) {
        this.entityList = entityList;
        this.choose = choose;
    }

    @Override
    public void execute() {
        for (int i = 0; i < entityList.size(); i++) {
            DBEntity dbEntity = entityList.get(i);
            System.out.println((i + 1) + ". " + dbEntity.toString());
        }
        System.out.println();
        DBEntityMenuItem dbEntityMenuItem = DBEntityMenuItem.ITEM;
        if (choose) {
            while (true) {
                try {
                    System.out.print("Choose: ");
                    int input = Integer.parseInt(scanner.nextLine());
                    DBEntity entity = entityList.get(input - 1);
                    dbEntityMenuItem.setLabel(entity);
                    break;
                } catch (Exception e) {
                    System.out.println(ERROR);
                }
            }
        }

        outputMediator.notify(dbEntityMenuItem);
    }
}
