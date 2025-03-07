package org.example.util;

import org.example.ForFields.*;
import org.example.command.ShowCommand;
import org.example.manager.CollectionManager;
import org.example.model.Ticket;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Reciewer {
    public void addTicket(CollectionManager collectionManager){
        collectionManager.getTickets().add(createTicket(null));
    }
    public void addTicketWithAll (CollectionManager collectionManager,Integer idos, String name, Coordinates coordinates, Integer price, int discount, TicketType type, Person person){
        if (collectionManager.getTickets().isEmpty()){
            return;
        }
        for (Ticket ticket: collectionManager.getTickets()){
            if (Objects.equals(person.getPassportID(), ticket.getPerson().getPassportID())){
                System.out.println("Поля класса Ticket не соответствуют допустимым значениям");
                return;
            }
        }
        if (coordinates.getY() < -376 || price < 0 || discount < 0 || discount > 100 || person.getPassportID().length() < 8){
            System.out.println("Поля класса Ticket не соответствуют допустимым значениям");
            return;
        }
        if (!(idos == null)){
            Ticket ticket = new Ticket(idos,name,coordinates,LocalDate.now(),price,discount,type,person);
            collectionManager.getTickets().add(ticket);
            System.out.println("\u001B[31m" + "Билет создан" + "\u001B[0m");
        }else {
            Ticket ticket = new Ticket(id,name,coordinates,LocalDate.now(),price,discount,type,person);
            collectionManager.getTickets().add(ticket);
            id+=1;
            System.out.println("\u001B[31m" + "Билет создан" + "\u001B[0m");
        }
    }
    public void updateIDWithAll(CollectionManager collectionManager,Integer idos, String name, Coordinates coordinates, Integer price, int discount, TicketType type, Person person){
        Reciewer reciewer = new Reciewer();
        reciewer.removeTicketbyID(collectionManager,idos);
        reciewer.addTicketWithAll(collectionManager,idos,name,coordinates,price,discount,type,person);
        System.out.println("Элемент по id = " + idos + " обновлен");
    }
    public void updatebyID(CollectionManager collectionManager,Integer Id){
        if(collectionManager.getTickets().isEmpty()){
            System.out.println("\u001B[31m" + "Нет билетов совсем" + "\u001B[0m");
            return;
        }
        for(Ticket ticket: collectionManager.getTickets()){
            if(Objects.equals(Id, ticket.getId())){
                System.out.println("\u001B[33m" + "Меняем значение билета по ID=" + Id + "\u001B[0m");
                collectionManager.getTickets().remove(ticket);
                collectionManager.getTickets().add(createTicket(Id));
                System.out.println("\u001B[35m" + "Поменяли значение билета" + "\u001B[0m");
                return;
            }
        }
        System.out.println("\u001B[31m" + "Нет билетов c таким id" + "\u001B[0m");
    }
    public void removeTicketbyID(CollectionManager collectionManager,Integer id){
        if(collectionManager.getTickets().isEmpty()){
            System.out.println("\u001B[31m" + "Нет билетов совсем" + "\u001B[0m");
            return;
        }
        for(Ticket ticket: collectionManager.getTickets()){
            if(Objects.equals(id, ticket.getId())){
                collectionManager.getTickets().remove(ticket);
                System.out.println("\u001B[32m" + "Билет по id = " + id + " удален" + "\u001B[0m");
                return;
            }
        }
        System.out.println("\u001B[31m" + "Нет билетов c таким id" + "\u001B[0m");
    }



    int id = 1;
    ArrayList<String> IDES = new ArrayList<>();

    private Ticket createTicket(Integer Id){
        Scanner scanner = new Scanner(System.in);
        Ticket ticket = new Ticket();


        String ticketName = null;
        while (true){
            System.out.println("Введите название билета: ");
            ticketName = scanner.nextLine();
            if (ticketName.isEmpty()){
                System.out.println("\u001B[31m" + "Название не может быть пустое" + "\u001B[0m");
            }
            else{
                break;
            }
        }
        ticket.setName(ticketName);

        Integer price = null;
        while (true){
            System.out.println("Введите цену билета: ");
            try {
                price = Integer.valueOf(scanner.nextLine());
                if (price <= 0){
                    System.out.println("\u001B[31m" + "Билет должен стоить больше 0" + "\u001B[0m");
                }
                else{
                    break;
                }
            } catch (NumberFormatException e){
                System.out.println("\u001B[31m" + "Введите стоимость, используя только цифры" + "\u001B[0m");
            }
        }
        ticket.setPrice(price);

        Integer discount = null;
        while (true){
            System.out.println("Введите цену скидки: ");
            try {
                discount = Integer.valueOf(scanner.nextLine());
                if (discount <= 0 || discount > 100){
                    System.out.println("\u001B[31m" + "Скидка должна быть в диапазоне от 1 до 100" + "\u001B[0m");
                }
                else{
                    break;
                }
            } catch (NumberFormatException e){
                System.out.println("\u001B[31m" + "Введите скидку, используя только цифры" + "\u001B[0m");
            }
        }
        ticket.setDiscount(discount);

        if (Id == null){
            ticket.setId(id);
            id +=1;
        } else{
            ticket.setId(Id);
        }


        ticket.setCreationDate(LocalDate.now());

        Long x = null;
        while (true){
            System.out.println("Введите координаты по X:");
            try{
                x = Long.valueOf(scanner.nextLine());
                break;
            }catch (NumberFormatException e){
                System.out.println("\u001B[31m" + "Введите координату, используя только цифры" + "\u001B[0m");
            }
        }

        Integer y = null;
        while (true){
            System.out.println("Введите координаты по Y:");
            try{
                y = Integer.valueOf(scanner.nextLine());
                if (y > -376){
                    break;
                }
                else{
                    System.out.println("\u001B[31m" + "Координата по Y должна быть больше -376" + "\u001B[0m");
                }
            }catch (NumberFormatException e){
                System.out.println("\u001B[31m" + "Введите координату, используя только цифры" + "\u001B[0m");
            }
        }

        Coordinates coordinates = new Coordinates(x,y);
        ticket.setCoordinates(coordinates);

        String tickettype = null;
        while (true) {
            TicketType.printAllTicketTypes();
            System.out.println("\u001B[35m" + "Выберите и впишите один тип билета из списка:" + "\u001B[0m");
            tickettype = scanner.nextLine();
            boolean isValidType = false;

            for (TicketType type : TicketType.values()) {
                if (Objects.equals(type.getEng(), tickettype)) {
                    ticket.setType(type);
                    isValidType = true;
                    break;
                }
            }
            if (isValidType) {
                break;
            } else {
                System.out.println("\u001B[31m" + "Такого типа билета не существует" + "\u001B[0m");
            }
        }

        Person person = new Person();

        String IDI = null;
        while (true){
            System.out.println("Запишите паспорт ID человека:");
            IDI = scanner.nextLine();
            if ((!IDES.contains(IDI))&& IDI.length() >= 8){
                person.setPassportID(IDI);
                IDES.add(IDI);
                break;
            }
            else if (IDES.contains(IDI)){
                System.out.println("\u001B[31m" + "ID должен быть уникален" + "\u001B[0m");
            } else if (IDI.length() < 8) {
                System.out.println("\u001B[31m" + "Длина ID должна быть не меньше 8" + "\u001B[0m");
            }
        }

        String color = null;
        while (true) {
            Color.printAllColors();
            System.out.println("\u001B[35m" + "Выберите и впишите один цвет глаз у человека:" + "\u001B[0m");
            color = scanner.nextLine();
            boolean isValidType = false;

            for (Color calor : Color.values()) {
                if (Objects.equals(calor.getEng(), color)) {
                    person.setEyeColor(calor);
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
                    person.setNationality(country);
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

        ticket.setPerson(person);

        return ticket;
    }
}
