package com.example.drawing.tools;

import com.example.drawing.Coords;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Alex on 10/12/2017.
 */
public class Canvas implements Tool {

    private final String command = "[C]\\s\\d+\\s\\d+";
    private final String vertical_marker = "|";
    private final String horizontal_marker = "-";

    private int width;
    private int height;

    // Getters
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    @Override
    public boolean parse(String userInput) {

        Pattern pattern = Pattern.compile(command, Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(userInput).matches()) {

            String[] args = userInput.split(" ");
            this.width = Integer.parseInt(args[1]);
            this.height = Integer.parseInt(args[2]);

            return validate();
        }
        return false;
    }

    @Override
    public boolean validate() {
        if (width > 0 && height > 0)
            return true;
        else
            return false;
    }

    @Override
    public Map<Coords, String> execute() {

        Map<Coords, String> result = new HashMap<>();
        for (int h = 0; h <= height + 1; h++) {
            for (int w = 0; w <= width + 1; w++) {
                // Draw horizontal line
                if (h == 0 || h == height + 1) {
                    result.put(new Coords(w,h), horizontal_marker);
                } else {
                    // Draw vertical line
                    if (h > 0 && h < height + 1 && (w == 0 || w == width + 1)) {
                        result.put(new Coords(w, h), vertical_marker);
                    }
                }
            }
        }
        return result;
    }
}
