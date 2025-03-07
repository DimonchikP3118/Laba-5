package org.example.manager;

import org.example.ForFields.TicketType;
import org.example.command.*;
import org.example.model.Ticket;
import org.example.util.Reciewer;


import java.util.HashMap;
import java.util.Objects;

import static java.lang.System.in;

public class CommandManager {
    private HashMap<String, BaseCommand> commands = new HashMap<>();
    public CommandManager() {
        commands.put("info", new InfoCommand());
        commands.put("show", new ShowCommand());
        commands.put("add", new AddCommand());
        commands.put("reorder", new NewOrderCommand());
        commands.put("clear", new ClearCommand());
        commands.put("exit", new ExitCommand());
        commands.put("remove_first", new RemoveFirstCommand());
        commands.put("remove_last", new RemoveLastCommand());
        commands.put("help", new HelpCommand());
        commands.put("remove_by_id", new RemoveByID());
        commands.put("update_by_id", new UpdateByIDCommand());
        commands.put("count_less_than_type", new CountLessThanTypeCommand());
        commands.put("group_counting_by_discount", new GroupCountingByDiscountCommand());
        commands.put("save", new SaveCommand());
        commands.put("filter_by_person", new FilterByPersonCommand());
        commands.put("fast",new FastAddCommand());
        commands.put("execute_script",new ExecuteScriptCommand());
    }
    public static void exec(String input, CollectionManager collectionManager, Reciewer receiver){
        CommandManager commandManager = new CommandManager();
        commandManager.execute(input,collectionManager,receiver);
    }

    public void execute(String input, CollectionManager collectionManager, Reciewer receiver) {
        String command = input.split(" ")[0];
        if (input.split(" ").length >= 2 && ((Objects.equals(command, "update_by_id")) || (Objects.equals(command, "remove_by_id")) || (Objects.equals(command,"count_less_than_type")) || (Objects.equals(command,"execute_script")))) {
            if (input.split(" ").length == 2){
                String id = input.split(" ")[1];
                if (Objects.equals(command,"execute_script")){
                    commands.get("execute_script").execute(collectionManager,receiver,null,id);
                    return;
                }
                if (Objects.equals(command,"count_less_than_type")){
                    try{
                        for (TicketType type: TicketType.values()){
                            if (Objects.equals(type.getEng(), id)){
                                commands.get("count_less_than_type").execute(collectionManager, receiver, type.getChisl(),null);
                                return;
                            }
                        }
                    } catch (Exception ignored){
                    }
                }

                try {
                    Integer ID = Integer.valueOf(id);
                    if (Objects.equals(command, "update_by_id")) {
                        commands.get("update_by_id").execute(collectionManager, receiver, ID,null);
                        return;
                    }
                    if (Objects.equals(command, "remove_by_id")) {
                        commands.get("remove_by_id").execute(collectionManager, receiver, ID,null);
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Wrong argument");
                    return;
                }
            }
            else {
                System.out.println("Wrong argument");
                return;
            }
        }
        if(commands.containsKey(command) && input.split(" ").length == 1){
            commands.get(command).execute(collectionManager, receiver,null,null);
        } else {
            System.out.println("Неизвестная команда: " + input);
        }
    }
    public void getCommandList() {
        System.out.println("\u001B[32m" + "Список доступных команд:" + "\u001B[0m");
        for (BaseCommand command: commands.values()){
            command.getDescription();
        }
    }
}
