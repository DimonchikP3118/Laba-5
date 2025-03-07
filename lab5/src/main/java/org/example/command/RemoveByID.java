package org.example.command;

import org.example.manager.CollectionManager;
import org.example.util.Reciewer;

public class RemoveByID implements BaseCommand{
    @Override
    public void execute(CollectionManager collectionManager, Reciewer receiver,Integer id,String path) {
        receiver.removeTicketbyID(collectionManager,id);
    }

    @Override
    public void getDescription() {
        System.out.println("\u001B[35m" + "remove_by_id ID(надо ввести ID)" + "\u001B[0m" + " - Удаление билета по id");
    }
}
