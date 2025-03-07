package org.example.command;

import org.example.manager.CollectionManager;
import org.example.util.Reciewer;

public class ClearCommand implements BaseCommand{
    @Override
    public void execute(CollectionManager collectionManager, Reciewer receiver,Integer id,String path) {
        if (collectionManager.getTickets().isEmpty()) {
            System.out.println("\u001B[31m" + "Нет билетов для удаления" + "\u001B[0m");
            return;
        }
        collectionManager.getTickets().clear();
        System.out.println("\u001B[31m" + "Все билеты удалены!!!" + "\u001B[0m");
    }

    @Override
    public void getDescription() {
        System.out.println("\u001B[35m" + "clear" + "\u001B[0m" + " - Очистка всех билетов");
    }
}
