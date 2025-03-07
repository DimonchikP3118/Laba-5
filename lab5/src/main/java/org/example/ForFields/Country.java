package org.example.ForFields;

import java.util.Objects;

public enum Country {
    RUSSIA("Russia"),
    UNITED_KINGDOM("Britain"),
    SOUTH_KOREA("Korea");
    private String eng;

    Country(String eng) {
        this.eng = eng;
    }

    public static void printAllCountries() {
        System.out.println("\u001B[32m" + "Список стран для человека:" + "\u001B[0m");
        for (Country country : Country.values()) {
            System.out.println("\u001B[33m" + country + "\u001B[0m");
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

    public static Country getCountryByEng(String eng){
        for (Country country: Country.values()){
            if (Objects.equals(country.getEng(), eng)){
                return country;
            }
        }
        throw new IllegalArgumentException("Нет такой страны: " + eng);
    }
}