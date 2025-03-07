package org.example.command;

import org.example.manager.CollectionManager;
import org.example.util.Reciewer;

public class RemoveLastCommand implements BaseCommand{
    @Override
    public void execute(CollectionManager collectionManager, Reciewer receiver,Integer id,String path) {
        if (collectionManager.getTickets().isEmpty()) {
            System.out.println("\u001B[31m" + "Нет билетов для удаления" + "\u001B[0m");
            return;
        }
        collectionManager.getTickets().remove(collectionManager.getTickets().size()-1);
        System.out.println("\u001B[31m" + "Последний билет удален" + "\u001B[0m");
    }

    @Override
    public void getDescription() {
        System.out.println("\u001B[35m" + "remove_last" + "\u001B[0m" + " - Удаление последнего билета");
    }
}
