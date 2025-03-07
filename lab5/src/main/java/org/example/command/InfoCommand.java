package org.example.command;

import org.example.manager.CollectionManager;
import org.example.util.Reciewer;

public class InfoCommand implements BaseCommand{
    @Override
    public void execute(CollectionManager collectionManager, Reciewer receiver,Integer id,String path) {
        System.out.println("Тип коллекции: " + collectionManager.getTickets().getClass());
        System.out.println("Количество элементов коллекции: " + collectionManager.getTickets().size());
    }

    @Override
    public void getDescription() {
        System.out.println("\u001B[35m" + "info" + "\u001B[0m" + " - Вывод информации о коллекции");
    }
}
