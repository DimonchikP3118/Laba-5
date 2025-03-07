package org.example.command;

import org.example.manager.CollectionManager;
import org.example.model.Ticket;
import org.example.model.comparator.TicketComparatorByName;
import org.example.model.comparator.TicketComparatorByType;
import org.example.util.Reciewer;

import java.util.Vector;

public class NewOrderCommand implements BaseCommand{
    @Override
    public void execute(CollectionManager collectionManager, Reciewer receiver,Integer id,String path) {
        Vector<Ticket> tickets = collectionManager.getTickets();
//        TicketComparatorByName comparator = new TicketComparatorByName();
//
//        tickets.stream().sorted(comparator).forEach(t -> {
//            System.out.println(t);
//        });
        TicketComparatorByType comparatorByType = new TicketComparatorByType();

        tickets.stream().sorted(comparatorByType).forEach(ticket -> {
            System.out.println(ticket);
        });
    }


    @Override
    public void getDescription() {
        System.out.println("\u001B[35m" + "reorder" + "\u001B[0m" + " - Отсортировать коллекцию");
    }
}
