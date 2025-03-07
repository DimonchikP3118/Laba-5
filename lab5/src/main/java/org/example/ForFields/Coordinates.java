package org.example.ForFields;

public class Coordinates {
    private long x;
    private Integer y; //Значение поля должно быть больше -376, Поле не может быть null

    public Coordinates(long x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
    @Override
    public String toString(){
        return "(" + getX() + ", " + getY() + ")";
    }
}
