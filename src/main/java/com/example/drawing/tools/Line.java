package com.example.drawing.tools;


import com.example.drawing.Coords;
import com.example.drawing.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.regex.Pattern;

import static com.example.drawing.Preferences.NOT_A_STRAIGHT_LINE_ERROR;

/**
 * Class to support drawing straight lines
 */
public class Line implements Tool {

    private final static Logger logger = LoggerFactory.getLogger(Line.class);

    private final String command = "[L]\\s\\d+\\s\\d+\\s\\d+\\s\\d+";
    private String symbol = "x";

    private Coords pt1;
    private Coords pt2;

    public Line() {
    }

    public Line(Coords pt1, Coords pt2, String symbol) {
        this.pt1 = pt1;
        this.pt2 = pt2;
        this.symbol = symbol;
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
        // Coordinate 1 must have positive Coordinates
        if (pt1.getX() <= 0 || pt1.getY() <= 0) {
            logger.warn(String.format("Invalid Coordinates {x:%d,y:%d}",pt1.getX(), pt1.getY()));
            return false;
        } // Coordinate 2 must have positive Coordinates
        else if (pt2.getX() <= 0 || pt2.getY() <= 0) {
            logger.warn(String.format("Invalid Coordinates {x:%d,y:%d}",pt2.getX(), pt2.getY()));
            return false;
        } // 2 coordinates is a vertical Line {
        else if (pt1.getX() == pt2.getX() && pt1.getY() != pt2.getY()) {
            return true;
        } // 2 coordinates is a horizontal Line
        else if (pt1.getY() == pt2.getY() && pt1.getX() != pt2.getX()) {
            return true;
        } else {
            logger.warn(NOT_A_STRAIGHT_LINE_ERROR);
            return false;
        }
    }

    @Override
    public Image draw(Image image) {

        Map<Coords, String> result = image.getPixels();

        // Factor in the Canvas Size
        Canvas c = image.getCanvas();
        int minX = getCoordsWithinCanvas(Math.min(pt1.getX(), pt2.getX()),c.getWidth());
        int maxX = getCoordsWithinCanvas(Math.max(pt1.getX(), pt2.getX()),c.getWidth());
        int minY = getCoordsWithinCanvas(Math.min(pt1.getY(), pt2.getY()),c.getHeight());
        int maxY = getCoordsWithinCanvas(Math.max(pt1.getY(), pt2.getY()),c.getHeight());

        // Plot Vertical Line
        if (pt1.getX() == pt2.getX()) {
            for (int i = minY ; i <= maxY; i++) {
                if (pt1.getX() >= 1 && pt1.getX() <= c.getWidth())
                    result.put(new Coords(pt1.getX(), i), symbol);
            }
        }
        // Plot Horizontal Line
        else if (pt1.getY() == pt2.getY()) {
            for (int i = minX ; i <= maxX; i++)
                if (pt1.getY() >= 1 && pt1.getY() <= c.getHeight())
                    result.put(new Coords(i, pt1.getY()), symbol);
        }
        image.setPixels(result);
        return image;
    }

    /**
     * Return the coordinates (truncated) within the Canvas
     * @param x     arbitrary x or y point
     * @param max   the upper limit of the canvas dimension
     * @return      the close point within the Canvas
     */
    public int getCoordsWithinCanvas(int x, int max) {
        if (x > max) return max;
        else if (x < 1) return 1;
        else return x;
    }
}
