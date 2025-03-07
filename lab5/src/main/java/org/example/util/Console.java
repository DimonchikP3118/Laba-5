package org.example.util;

import org.example.manager.CollectionManager;
import org.example.manager.CommandManager;

import java.util.Scanner;

public class Console {
    private final CollectionManager collectionManager = new CollectionManager();
    private final CommandManager commandManager = new CommandManager();
    private final Reciewer reciewer = new Reciewer();

    public void start(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            commandManager.execute(scanner.nextLine(), collectionManager, reciewer);
        }
    }
}
