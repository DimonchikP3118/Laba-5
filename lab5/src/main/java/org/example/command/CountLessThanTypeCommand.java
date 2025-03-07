package org.example.command;

import org.example.ForFields.TicketType;
import org.example.manager.CollectionManager;
import org.example.model.Ticket;
import org.example.util.Reciewer;

public class CountLessThanTypeCommand implements BaseCommand{
    @Override
    public void execute(CollectionManager collectionManager, Reciewer receiver,Integer id,String path) {
        if (collectionManager.getTickets().isEmpty()){
            System.out.println("Коллекция пуста");
            return;
        }
        try {
            int count = 0;
            for (Ticket ticket: collectionManager.getTickets()){
                if (ticket.getType().getChisl() > id){
                    count+=1;
                }
            }
            System.out.println("Количество необходимых элементов: " + count);
        } catch (NullPointerException e){
            System.out.println("Wrong argument");
        }
    }
    @Override
    public void getDescription() {
        System.out.println("\u001B[35m" + "count_less_than_type Type(нужно ввести тип билета)" + "\u001B[0m" + " - Вывести количество элементов, значение поля type которых меньше заданного");
    }
}
