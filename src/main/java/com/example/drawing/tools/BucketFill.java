package com.example.drawing.tools;

import com.example.drawing.Coords;
import com.example.drawing.Image;

import java.util.regex.Pattern;

/**
 * Class to support applying bucket fill
 */
public class BucketFill implements Tool {

    private final String command = "[B]\\s\\d+\\s\\d+\\s.";

    private Image image;
    private Coords target;
    private String symbol = "";


    @Override
    public boolean parse(String input) {

        Pattern pattern = Pattern.compile(command, Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(input).matches()) {
            String[] args = input.split(" ");
            this.image = new Image();
            this.target = new Coords(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            this.symbol = args[3];

            return validate();
        }
        return false;
    }

    @Override
    public boolean validate() {
        // Coordinates must be positive
        if (target.getX() <=0 || target.getY() <=0)
            return false;
        else
            return true;
    }

    @Override
    public Image draw(Image image) {

        this.image = image;
        String currPixel = image.getPixels().get(target);
        currPixel = currPixel == null ? image.getBackground() : currPixel;
        draw(target, symbol, currPixel);
        return image;
    }

    private void draw(Coords c, String newPixel, String currPixel) {

        // Check coords are within boundaries
        if (c.getX() <= 0 || c.getY() <= 0) return;
        if (c.getX() > image.getCanvas().getWidth()) return;
        if (c.getY() > image.getCanvas().getHeight()) return;

        String replacePixel = image.getPixels().get(c) == null ? image.getBackground() : image.getPixels().get(c);
        if (currPixel.equals(replacePixel)) {

            image.getPixels().put(c, newPixel);
            draw(new Coords(c.getX() - 1, c.getY()), newPixel, currPixel);
            draw(new Coords(c.getX() + 1, c.getY()), newPixel, currPixel);
            draw(new Coords(c.getX(), c.getY() - 1), newPixel, currPixel);
            draw(new Coords(c.getX(), c.getY() + 1), newPixel, currPixel);
        }
    }
}
