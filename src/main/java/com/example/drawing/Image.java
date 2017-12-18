package com.example.drawing;

import com.example.drawing.tools.Tool;
import com.example.drawing.tools.BucketFill;
import com.example.drawing.tools.Canvas;

import java.util.HashMap;
import java.util.Map;

import static com.example.drawing.Preferences.DEFAULT_BACKGROUND;
import static com.example.drawing.Preferences.DEFAULT_CANVAS_HEIGHT;
import static com.example.drawing.Preferences.DEFAULT_CANVAS_WIDTH;

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
        canvas  = new Canvas(DEFAULT_CANVAS_WIDTH, DEFAULT_CANVAS_HEIGHT);
        pixels.putAll(canvas.execute());
    }

    public void print() {
        for (int h = 0; h <= canvas.getHeight() + 1; h++) {
            for (int w = 0; w <= canvas.getWidth() + 1; w++) {
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
