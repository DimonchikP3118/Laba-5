package org.example.ForFields;

public class Person {
    private String passportID; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Длина строки должна быть не меньше 8, Поле может быть null
    private Color eyeColor; //Поле не может быть null
    private Country nationality; //Поле может быть null

    public Person() {
    }

    public Person(String passportID, Color eyeColor, Country nationality) {
        this.passportID = passportID;
        this.eyeColor = eyeColor;
        this.nationality = nationality;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }
    @Override
    public String toString(){
        return "ПаспортID=" + passportID + ", " + "цвет глаз=" + eyeColor + ", национальность=" + nationality;
    }
}
