package com.example.drawing.tools;

import com.example.drawing.Coords;
import com.example.drawing.Image;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Alex on 10/12/2017.
 */
public class Rectangle implements Tool {

    private final String command = "[R]\\s\\d+\\s\\d+\\s\\d+\\s\\d+";

    private String symbol = "x";
    private Coords pt1;
    private Coords pt2;


    @Override
    public boolean parse(String userInput) {

        Pattern pattern = Pattern.compile(command, Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(userInput).matches()) {

            String[] args = userInput.split(" ");
            this.pt1 = new Coords(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            this.pt2 = new Coords(Integer.parseInt(args[3]), Integer.parseInt(args[4]));

            return validate();
        }
        return false;
    }

    @Override
    public boolean validate() {
        // First Coordinates must be positive
        if (pt1.getX() <=0 || pt1.getY() <=0)
            return false;
        // Second Coordinates must be positive
        else if (pt2.getX() <=0 || pt2.getY() <=0)
            return false;
        else
            return true;
    }

    @Override
    public Image execute(Image image) {

        // Construct rectangle with lines
        Coords upperLeft = new Coords(pt1.getX(), pt1.getY());
        Coords upperRight = new Coords(pt2.getX(), pt1.getY());
        Coords lowerLeft = new Coords(pt1.getX(), pt2.getY());
        Coords lowerRight = new Coords(pt2.getX(), pt2.getY());

        Line top = new Line(upperLeft,upperRight, symbol);
        Line left = new Line(upperLeft,lowerLeft, symbol);
        Line right = new Line(upperRight, lowerRight, symbol);
        Line bottom = new Line(lowerLeft,lowerRight, symbol);

        Map<Coords, String> result = new HashMap<>();
        result.putAll(top.execute());
        result.putAll(left.execute());
        result.putAll(right.execute());
        result.putAll(bottom.execute());

        image.setPixels(result);
        return image;
    }
}

