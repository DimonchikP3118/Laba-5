package org.example.ForFields;

import java.util.Objects;

public enum TicketType {
    VIP("VIP",1),
    USUAL("Usual",2),
    BUDGETARY("Budgetary",3),
    CHEAP("Cheap",4);
    private String eng;
    private int Chisl;

    TicketType(String eng, int Chisl) {
        this.eng = eng;
        this.Chisl = Chisl;
    }
    public static void printAllTicketTypes() {
        System.out.println("\u001B[32m" + "Список типов билетов:" + "\u001B[0m");
        for (TicketType type : TicketType.values()) {
            System.out.println("\u001B[33m" + type + "\u001B[0m");
        }
    }

    @Override
    public String toString() {
        return eng;
    }
    public String getEng() {
        return eng;
    }
    public void setEng(String eng) {
        this.eng = eng;
    }
    public int getChisl() {
        return Chisl;
    }
    public void setChisl(int chisl) {
        Chisl = chisl;
    }

    public static TicketType getTypeByEng(String eng){
        for (TicketType type: TicketType.values()){
            if (Objects.equals(type.getEng(), eng)){
                return type;
            }
        }
        throw new IllegalArgumentException("Нет такого типа: " + eng);
    }
}
