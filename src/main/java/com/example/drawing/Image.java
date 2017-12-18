package com.example.drawing;

import com.example.drawing.tools.Canvas;

import java.util.HashMap;
import java.util.Map;

import static com.example.drawing.Preferences.*;

/**
 * Created by Alex on 16/12/2017.
 */
public class Image {

    private Map<Coords, String> pixels;
    private String background;
    private Canvas canvas;

    public Image() {
        this.pixels = new HashMap<>();
        this.background = DEFAULT_BACKGROUND;
        this.canvas  = new Canvas(DEFAULT_CANVAS_WIDTH, DEFAULT_CANVAS_HEIGHT);
    }

    public void print() {

        for (int h = 0; h <= canvas.getHeight() + 1; h++) {
            for (int w = 0; w <= canvas.getWidth() + 1; w++) {

                // Print the Horizontal Canvas
                if (h == 0 || h == (canvas.getHeight() + 1)) {
                    System.out.print(canvas.getHorizontal_symbol());
                } // Print the Vertical Canvas
                else if (w == 0 || w == (canvas.getWidth() + 1)) {
                    System.out.print(canvas.getVertical_symbol());
                } // Print the other remaining pixels
                else {
                    // Print the stored pixels
                    Coords c = new Coords(w, h);
                    if (pixels.containsKey(c)) {
                        System.out.print(pixels.get(c));
                    } else {
                        System.out.print(background);
                    }
                }
            }
            System.out.println();
        }
    }

    // Getters and Setters
    public Map<Coords, String> getPixels() {
        return pixels;
    }

    public void setPixels(Map<Coords, String> pixels) {
        this.pixels = pixels;
    }

    public String getBackground() {
        return background;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}
