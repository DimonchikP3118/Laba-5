package org.example.command;

import org.example.manager.CollectionManager;
import org.example.util.Reciewer;

public class ExitCommand implements BaseCommand {
    @Override
    public void execute(CollectionManager collectionManager, Reciewer receiver,Integer id,String path) {
        System.out.println("\u001B[31m" + "Принудительное завершение без сохранения" + "\u001B[0m");
        System.exit(0);
    }

    @Override
    public void getDescription() {
        System.out.println("\u001B[35m" + "exit" + "\u001B[0m" + " - Завершение без сохранения");
    }
}
