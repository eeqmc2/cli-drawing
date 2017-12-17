package com.example.drawing;

import com.example.drawing.tools.Canvas;

import java.util.HashMap;
import java.util.Map;

import static com.example.drawing.Preferences.DEFAULT_BACKGROUND;
import static com.example.drawing.Preferences.DEFAULT_CANVAS_HEIGHT;
import static com.example.drawing.Preferences.DEFAULT_CANVAS_WIDTH;

/**
 * Created by Alex on 12/12/2017.
 */
public class Image {

    private Map<Coords, String> pixels;
    private String background;
    private int width;
    private int height;

    public Image() {
        this.pixels = new HashMap<>();
        this.background = DEFAULT_BACKGROUND;
        this.width = DEFAULT_CANVAS_WIDTH;
        this.height = DEFAULT_CANVAS_HEIGHT;
    }

    public Map<Coords, String> getPixels() {
        return pixels;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public String getBackground() {
        return background;
    }

    public void setCanvas(Canvas canvas) {
        this.width = canvas.getWidth();
        this.height = canvas.getHeight();
    }

    public void draw(Map<Coords, String> shapes) {
        pixels.putAll(shapes);
    }

    public void print() {

        for (int h = 0; h <= height + 1; h++) {
            for (int w = 0; w <= width + 1; w++) {
                Coords c = new Coords(w,h);
                if (pixels.containsKey(c)) {
                    System.out.print(pixels.get(c));
                } else {
                    System.out.print(background);
                }
            }
            System.out.println();
        }
    }


}
