package org.example.command;

import org.example.CSV.CSVReader;
import org.example.ForFields.*;
import org.example.manager.CollectionManager;
import org.example.manager.CommandManager;
import org.example.model.Ticket;
import org.example.util.Reciewer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ExecuteScriptCommand implements BaseCommand{
    @Override
    public void execute(CollectionManager collectionManager, Reciewer receiver,Integer id,String path) {
        ArrayList<String> commands = CSVReader.readCsv(path);
        for (String command: commands){
            String[] elements = command.split(" ");
            System.out.println("\u001B[33m" + "Команда - " + elements[0] + "\u001B[0m");
            if (Objects.equals(elements[0],"add")){
                if (collectionManager.getTickets().isEmpty()){
                    System.out.println("Коллекция пуста");
                }
                try {
                    receiver.addTicketWithAll(collectionManager,null,elements[1],new Coordinates(Long.parseLong(elements[2]),Integer.valueOf(elements[3])),Integer.valueOf(elements[4]),Integer.parseInt(elements[5]), TicketType.getTypeByEng(elements[6]),new Person(elements[7], Color.getColorByEng(elements[8]), Country.getCountryByEng(elements[9])));
                } catch (IllegalArgumentException e){
                    System.out.println("Wrong argument");
                }
            }
            else if (Objects.equals(elements[0],"update_by_id")){
                if (collectionManager.getTickets().isEmpty()){
                    System.out.println("Коллекция пуста");
                    continue;
                }
                try {
                    receiver.updateIDWithAll(collectionManager,Integer.parseInt(elements[1]),elements[2],new Coordinates(Long.parseLong(elements[3]),Integer.valueOf(elements[4])),Integer.valueOf(elements[5]),Integer.parseInt(elements[6]),TicketType.getTypeByEng(elements[7]),new Person(elements[8],Color.getColorByEng(elements[9]),Country.getCountryByEng(elements[10])));
                }catch (Exception e){
                    System.out.println("Wrong argument");
                }
            }
            else if (Objects.equals(elements[0],"remove_by_id")){
                try{
                    receiver.removeTicketbyID(collectionManager,Integer.parseInt(elements[1]));
                }catch (Exception e){
                    System.out.println("Wrong argument");
                }
            } else if (Objects.equals(elements[0],"count_less_than_type")) {
                CountLessThanTypeCommand countLessThanTypeCommand = new CountLessThanTypeCommand();
                try {
                    countLessThanTypeCommand.execute(collectionManager,receiver,TicketType.getTypeByEng(elements[1]).getChisl(),null);
                } catch (Exception e){
                    System.out.println("Wrong argument");
                }
            }
            else if (Objects.equals(elements[0],"filter_by_person")){
                if (collectionManager.getTickets().isEmpty()){
                    System.out.println("Пустая коллекция");
                    continue;
                }
                boolean c = false;
                System.out.println("Ищем элементы коллекции с похожими людьми:");
                try{
                    for (Ticket ticket: collectionManager.getTickets()){
                        if (Objects.equals(ticket.getPerson().getEyeColor(),Color.getColorByEng(elements[1])) && Objects.equals(ticket.getPerson().getNationality(),Country.getCountryByEng(elements[2]))){
                            System.out.println(ticket);
                            c = true;
                        }
                    }
                } catch (Exception e){
                    System.out.println("Wrong argument");
                    c = false;
                    continue;
                }
                if (!c){
                    System.out.println("Совпадений не найдено");
                }
            }
            else{
                CommandManager.exec(command,collectionManager,receiver);
            }
        }
    }

    @Override
    public void getDescription() {
        System.out.println("\u001B[35m" + "execute_script file_name(нужно ввести путь до файла)" + "\u001B[0m" + " - Считать и исполнить скрипт из указанного файла");
    }
}
