package org.example.command;

import org.example.ForFields.*;
import org.example.manager.CollectionManager;
import org.example.model.Ticket;
import org.example.util.Reciewer;

import java.time.LocalDate;

public class FastAddCommand implements BaseCommand{
    @Override
    public void execute(CollectionManager collectionManager, Reciewer receiver,Integer id,String path) {
        Ticket ticket = new Ticket(1,"52", new Coordinates(2,4), LocalDate.now(),500,5, TicketType.BUDGETARY,new Person("52", Color.BLACK, Country.RUSSIA));
        Ticket ticket2 = new Ticket(2,"52", new Coordinates(2,4), LocalDate.now(),500,5, TicketType.BUDGETARY,new Person("52", Color.BLACK, Country.RUSSIA));
        Ticket ticket3 = new Ticket(3,"52", new Coordinates(2,4), LocalDate.now(),500,5, TicketType.BUDGETARY,new Person("52", Color.BLACK, Country.RUSSIA));
        collectionManager.getTickets().add(ticket);
        collectionManager.getTickets().add(ticket2);
        collectionManager.getTickets().add(ticket3);
    }

    @Override
    public void getDescription() {

    }
}
