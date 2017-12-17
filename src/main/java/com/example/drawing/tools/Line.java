package com.example.drawing.tools;


import com.example.drawing.Coords;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Alex on 10/12/2017.
 */
public class Line implements Tool {

    private final String command = "[L]\\s\\d+\\s\\d+\\s\\d+\\s\\d+";
    private String marker = "x";

    private Coords pt1;
    private Coords pt2;

    public Line() {
    }

    public Line(Coords pt1, Coords pt2, String marker) {
        this.pt1 = pt1;
        this.pt2 = pt2;
        this.marker = marker;
    }

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
        // X Coordinates must be positive
        if (pt1.getX() <=0 || pt1.getY() <=0)
            return false;
        // Y Coordinates must be positive
        else if (pt2.getX() <=0 || pt2.getY() <=0)
            return false;
        // 2 coordinates is a vertical Line
        else if (pt1.getX() == pt2.getX() && pt1.getY() != pt2.getY())
            return true;
        // 2 coordinates is a horizontal Line
        else if (pt1.getY() == pt2.getY() && pt1.getX() != pt2.getX())
            return true;
        else
            return false;
    }

    @Override
    public Map<Coords, String> execute() {

        Map<Coords, String> result = new HashMap<>();
        // Plot Vertical Line
        if (pt1.getX() == pt2.getX()) {
            if (pt1.getY() < pt2.getY()) {
                for (int i = pt1.getY(); i <= pt2.getY(); i++)
                    result.put(new Coords(pt1.getX(), i), marker);
            } else {
                for (int i = pt2.getY(); i <= pt1.getY(); i++)
                    result.put(new Coords(pt1.getX(), i), marker);
            }
        }
        // Plot Horizontal Line
        else if (pt1.getY() == pt2.getY()) {
            if (pt1.getX() < pt2.getX()) {
                for (int i = pt1.getX(); i <= pt2.getX(); i++)
                    result.put(new Coords(i, pt1.getY()), marker);
            } else {
                for (int i = pt2.getX(); i <= pt1.getX(); i++)
                    result.put(new Coords(i, pt1.getY()), marker);
            }
        }
        return result;
    }
}
