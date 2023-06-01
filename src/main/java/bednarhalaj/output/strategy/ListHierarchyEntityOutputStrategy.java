package bednarhalaj.output.strategy;

import bednarhalaj.model.DBEntity;
import bednarhalaj.model.hierarchy.HierarchyEntity;
import bednarhalaj.output.items.HierarchyEntityMenuItem;

import java.util.List;

public class ListHierarchyEntityOutputStrategy extends OutputStrategy {

    private final List<? extends HierarchyEntity> entityList;

    private final boolean choose;

    private final String ERROR = "Something went wrong, try again!\n";

    public ListHierarchyEntityOutputStrategy(List<? extends HierarchyEntity> entityList, boolean choose) {
        this.entityList = entityList;
        this.choose = choose;
    }

    @Override
    public void execute() {
        if(entityList.isEmpty()){
            System.out.println("No entries!\n");
        }
        for (int i = 0; i < entityList.size(); i++) {
            HierarchyEntity hierarchyEntity = entityList.get(i);
            System.out.println((i + 1) + ". " + hierarchyEntity.toString());
        }
        System.out.println();
        HierarchyEntityMenuItem hierarchyEntityMenuItem = HierarchyEntityMenuItem.ITEM;
        if (choose) {
            while (true) {
                try {
                    System.out.print("Choose: ");
                    int input = Integer.parseInt(scanner.nextLine());
                    HierarchyEntity entity = entityList.get(input - 1);
                    hierarchyEntityMenuItem.setLabel(entity);
                    break;
                } catch (Exception e) {
                    System.out.println(ERROR);
                }
            }

            outputMediator.notify(hierarchyEntityMenuItem);
        }
    }
}
