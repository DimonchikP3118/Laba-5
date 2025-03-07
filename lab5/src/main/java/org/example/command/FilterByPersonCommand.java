package org.example.command;

import org.example.ForFields.Color;
import org.example.ForFields.Country;
import org.example.manager.CollectionManager;
import org.example.model.Ticket;
import org.example.util.Reciewer;

import java.util.Objects;
import java.util.Scanner;

public class FilterByPersonCommand implements BaseCommand{
    @Override
    public void execute(CollectionManager collectionManager, Reciewer receiver,Integer id,String path) {
        if (collectionManager.getTickets().isEmpty()){
            System.out.println("коллекция пуста");
            return;
        }
        System.out.println("Чтобы найти похожих людей нужно ввести несколько полей:");
        String color = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Color.printAllColors();
            System.out.println("\u001B[35m" + "Выберите и впишите один цвет глаз у человека:" + "\u001B[0m");
            color = scanner.nextLine();
            boolean isValidType = false;

            for (Color calor : Color.values()) {
                if (Objects.equals(calor.getEng(), color)) {
                    isValidType = true;
                    break;
                }
            }
            if (isValidType) {
                break;
            } else {
                System.out.println("\u001B[31m" + "Такого цвета глаз не существует" + "\u001B[0m");
            }
        }

        String natia = null;
        while (true) {
            Country.printAllCountries();
            System.out.println("\u001B[35m" + "Выберите и впишите национальность у человека:" + "\u001B[0m");
            natia = scanner.nextLine();
            boolean isValidType = false;

            for (Country country : Country.values()) {
                if (Objects.equals(country.getEng(), natia)) {
                    isValidType = true;
                    break;
                }
            }
            if (isValidType) {
                break;
            } else {
                System.out.println("\u001B[31m" + "Такой национальности не существует" + "\u001B[0m");
            }
        }
        boolean c = false;
        System.out.println("Элементы коллекции с похожими людьми:");
        for (Ticket ticket: collectionManager.getTickets()){
            if (Objects.equals(ticket.getPerson().getEyeColor().getEng(), color) && Objects.equals(ticket.getPerson().getNationality().getEng(), natia)){
                System.out.println(ticket);
                c = true;
            }
        }
        if (!c){
            System.out.println("Совпадений не найдено");
        }
    }

    @Override
    public void getDescription() {
        System.out.println("\u001B[35m" + "filter_by_person" + "\u001B[0m" + " - Вывести элементы, значение поля person которых равно заданному");
    }
}
