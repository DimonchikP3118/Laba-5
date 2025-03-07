package org.example.command;

import org.example.manager.CollectionManager;
import org.example.model.Ticket;
import org.example.util.Reciewer;

import java.util.HashMap;
import java.util.Map;

public class GroupCountingByDiscountCommand implements BaseCommand{
    @Override
    public void execute(CollectionManager collectionManager, Reciewer receiver,Integer id,String path) {
        if (collectionManager.getTickets().isEmpty()){
            System.out.println("Коллекция пуста");
            return;
        }
        Map<Integer, Integer> discountGroups = new HashMap<>();

        for (Ticket ticket : collectionManager.getTickets()) {
            int discount = ticket.getDiscount();
            discountGroups.put(discount, discountGroups.getOrDefault(discount, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : discountGroups.entrySet()) {
            System.out.println("Скидка: " + entry.getKey() + ", количество: " + entry.getValue());
        }
    }


    @Override
    public void getDescription() {
        System.out.println("\u001B[35m" + "group_counting_by_discount" + "\u001B[0m" + " - Сгруппировать элементы коллекции по значению поля discount, вывести количество элементов в каждой группе");
    }
}
