package org.example.command;

import org.example.manager.CollectionManager;
import org.example.util.Reciewer;

public class AddCommand implements BaseCommand{
    @Override
    public void execute(CollectionManager collectionManager, Reciewer receiver,Integer id,String path) {
        receiver.addTicket(collectionManager);
        System.out.println("\u001B[31m" + "Добавлен новый билет" + "\u001B[0m");
    }

    @Override
    public void getDescription() {
        System.out.println("\u001B[35m" + "add" + "\u001B[0m" + " - Добавление нового билета");
    }
}
