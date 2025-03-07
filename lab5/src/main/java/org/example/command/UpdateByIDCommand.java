package org.example.command;

import org.example.manager.CollectionManager;
import org.example.util.Reciewer;

public class UpdateByIDCommand implements BaseCommand{
    @Override
    public void execute(CollectionManager collectionManager, Reciewer receiver,Integer id,String path) {
        receiver.updatebyID(collectionManager,id);
    }

    @Override
    public void getDescription() {
        System.out.println("\u001B[35m" + "update_by_id ID(нужно ввести ID)" + "\u001B[0m" + " - обновить значение билета по ID");
    }
}
