package org.example.ForFields;

import java.util.Objects;

public enum Color {
    GREEN("Green"),
    BLACK("Black"),
    BLUE9("Blue"),
    ORANGE("Orange"),
    WHITE("White");
    private String eng;

    Color(String eng) {
        this.eng = eng;
    }
    public static void printAllColors() {
        System.out.println("\u001B[32m" + "Список цветов глаз для человека:" + "\u001B[0m");
        for (Color color : Color.values()) {
            System.out.println("\u001B[33m" + color + "\u001B[0m");
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

    public static Color getColorByEng(String eng){
        for (Color color: Color.values()){
            if (Objects.equals(color.getEng(), eng)){
                return color;
            }
        }
        throw new IllegalArgumentException("Нет такого цвета: " + eng);
    }
}
