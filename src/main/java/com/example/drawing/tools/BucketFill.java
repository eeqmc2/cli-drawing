package com.example.drawing.tools;

import com.example.drawing.Coords;
import com.example.drawing.Image;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Alex on 10/12/2017.
 */
public class BucketFill implements Tool {

    private final String command = "[B]\\s\\d+\\s\\d+\\s.";

    private Image image;
    private Coords target;
    private String marker = "";


    @Override
    public boolean parse(String input) {

        Pattern pattern = Pattern.compile(command, Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(input).matches()) {
            String[] args = input.split(" ");
            this.image = new Image();
            this.target = new Coords(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            this.marker = args[3];

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
    public Image execute(Image image) {

        this.image = image;
        String currPixel = image.getPixels().get(target);
        currPixel = currPixel == null ? image.getBackground() : currPixel;
        execute(target, marker, currPixel);
        return image;
    }

    private void execute(Coords c, String newPixel, String currPixel) {

        // Check coords are within boundaries
        if (c.getX() <= 0 || c.getY() <= 0) return;
        if (c.getX() > image.getCanvas().getWidth()) return;
        if (c.getY() > image.getCanvas().getHeight()) return;

        String replacePixel = image.getPixels().get(c) == null ? image.getBackground() : image.getPixels().get(c);
        if (currPixel.equals(replacePixel)) {

            image.getPixels().put(c, newPixel);
            execute(new Coords(c.getX() - 1, c.getY()), newPixel, currPixel);
            execute(new Coords(c.getX() + 1, c.getY()), newPixel, currPixel);
            execute(new Coords(c.getX(), c.getY() - 1), newPixel, currPixel);
            execute(new Coords(c.getX(), c.getY() + 1), newPixel, currPixel);
        }
    }
}
