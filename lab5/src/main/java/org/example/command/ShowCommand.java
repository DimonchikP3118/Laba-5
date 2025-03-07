package org.example.command;

import org.example.manager.CollectionManager;
import org.example.model.Ticket;
import org.example.util.Reciewer;

public class ShowCommand implements BaseCommand{
    @Override
    public void execute(CollectionManager collectionManager, Reciewer receiver,Integer id,String path) {
        if (collectionManager.getTickets().isEmpty()) {
            System.out.println("\u001B[31m" + "Нет билетов" + "\u001B[0m");
            return;
        }
        System.out.println("Общее количество билетов: " + collectionManager.getTickets().size());
        for(Ticket ticket : collectionManager.getTickets()) {
            System.out.println(ticket);
        }
    }

    @Override
    public void getDescription() {
        System.out.println("\u001B[35m" + "show" + "\u001B[0m" + " - Подробная информация о билетах и их количество");
    }
}
