package com.example.drawing;

/**
 * Created by Alex on 16/12/2017.
 */
public class Coords {

    private int x;
    private int y;

    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null || !(obj instanceof Coords))
            return false;

        if (this.x == ((Coords)obj).getX() && this.y == ((Coords)obj).getY())
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Coords{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    // Getters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
