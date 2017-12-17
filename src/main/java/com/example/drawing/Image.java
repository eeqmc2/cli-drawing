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
    private int width;
    private int height;

    public Image() {
        this.pixels = new HashMap<>();
        this.background = DEFAULT_BACKGROUND;
        this.width = DEFAULT_CANVAS_WIDTH;
        this.height = DEFAULT_CANVAS_HEIGHT;
    }

    public void draw(Tool tool) {
        if (tool instanceof Canvas) {
            this.width = ((Canvas) tool).getWidth();
            this.height = ((Canvas) tool).getHeight();
        } else if (tool instanceof BucketFill) {
            ((BucketFill) tool).setImage(this);
        }
        Map<Coords, String> shape = tool.execute();
        pixels.putAll(shape);
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

    // Getters
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

}
