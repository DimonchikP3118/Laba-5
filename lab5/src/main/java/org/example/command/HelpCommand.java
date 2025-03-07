package org.example.command;

import org.example.manager.CollectionManager;
import org.example.manager.CommandManager;
import org.example.util.Reciewer;

public class HelpCommand implements BaseCommand{
    @Override
    public void execute(CollectionManager collectionManager, Reciewer receiver,Integer id,String path) {
        CommandManager commandManager = new CommandManager();
        commandManager.getCommandList();
    }

    @Override
    public void getDescription() {
        System.out.println("\u001B[35m" + "help" + "\u001B[0m" + " - Вывод справки по всем командам");
    }
}
