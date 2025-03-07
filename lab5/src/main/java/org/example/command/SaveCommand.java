package org.example.command;

import org.example.CSV.CSVWriter;
import org.example.manager.CollectionManager;
import org.example.util.Reciewer;

public class SaveCommand implements BaseCommand{
    @Override
    public void execute(CollectionManager collectionManager, Reciewer receiver,Integer id,String path) {
        if (collectionManager.getTickets().isEmpty()){
            System.out.println("Коллекция пуста и нечего сохранять");
            return;
        }
        CSVWriter.writeCsv("C:\\Users\\Dmitriy\\IdeaProjects\\comparators\\src\\main\\java\\org\\example\\util\\resulty.csv",collectionManager.getTickets());
    }

    @Override
    public void getDescription() {
        System.out.println("\u001B[35m" + "save" + "\u001B[0m" + " - Сохранить коллекцию в файл");
    }
}
