package org.example.command;

import org.example.manager.CollectionManager;
import org.example.util.Reciewer;


public interface BaseCommand {
    void execute(CollectionManager collectionManager, Reciewer receiver,Integer id, String path);
    void getDescription();
}
