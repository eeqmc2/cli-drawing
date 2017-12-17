package com.example.drawing.tools;

import com.example.drawing.Coords;
import com.example.drawing.Image;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Alex on 10/12/2017.
 */
public class BucketFill implements Action {

    private final String command = "[B]\\s\\d+\\s\\d+\\s\\w";

    private Image image;
    private Coords pt;
    private String marker = "";

    public BucketFill() {
    }

    public BucketFill(String command) {

        String[] args = command.split(" ");
        this.pt = new Coords(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        this.marker = args[3];

    }

    // Getters and Setters
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }

    public Coords getPt() {
        return pt;
    }
    public void setPt(Coords pt) {
        this.pt = pt;
    }

    public String getMarker() {
        return marker;
    }
    public void setMarker(String marker) {
        this.marker = marker;
    }

    @Override
    public boolean parse(String input) {

        Pattern pattern = Pattern.compile(command, Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(input).matches()) {
            String[] args = input.split(" ");
            this.pt = new Coords(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            this.marker = args[3];

            return validate();
        }
        return false;
    }

    @Override
    public boolean validate() {
        // Coordinates must be positive
        if (pt.getX() <=0 || pt.getY() <=0)
            return false;
        else
            return true;
    }

    @Override
    public Map<Coords, String> execute()
    {
        return null;
    }

    public Map<Coords, String> execute(Coords coord, String newPixel) {

        String oldPixel = image.getPixels().get(coord) == null ?
                image.getBackground() : image.getPixels().get(coord);
        execute(coord, newPixel, oldPixel);
        return image.getPixels();
    }

    private void execute(Coords c, String newPixel, String oldPixel) {

        // Check coords are within boundaries
        if (c.getX() <= 0 || c.getY() <= 0) return;
        if (c.getX() > image.getWidth() || c.getY() > image.getHeight()) return;

        String replacePixel = image.getPixels().get(c) == null ? image.getBackground() : image.getPixels().get(c);
        if (oldPixel.equals(replacePixel)) {

            image.getPixels().put(c, newPixel);
            execute(new Coords(c.getX() - 1, c.getY()), newPixel, oldPixel);
            execute(new Coords(c.getX() + 1, c.getY()), newPixel, oldPixel);
            execute(new Coords(c.getX(), c.getY() - 1), newPixel, oldPixel);
            execute(new Coords(c.getX(), c.getY() + 1), newPixel, oldPixel);
        }
    }
}
