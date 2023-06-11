package bednarhalaj.output.strategy;

import bednarhalaj.model.DBEntity;
import bednarhalaj.output.items.DBEntityMenuItem;

import java.util.List;

public class ListDBEntityOutputStrategy extends OutputStrategy {

    private final String ERROR = "Something went wrong, try again!\n";
    List<? extends DBEntity> entityList;

    private final String prompt;

    private final boolean choose;

    public ListDBEntityOutputStrategy(List<? extends DBEntity> entityList, boolean choose, String prompt) {
        this.entityList = entityList;
        this.choose = choose;
        this.prompt = prompt;
    }

    @Override
    public void execute() {
        System.out.println(prompt);
        if(entityList.isEmpty()){
            System.out.println("No entries!\n");
        }
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

        manager.process(dbEntityMenuItem);
    }
}
