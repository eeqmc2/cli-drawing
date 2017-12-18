package com.example.drawing.tools;

import com.example.drawing.Image;

import java.util.regex.Pattern;

/**
 * Class to support drawing canvas
 */
public class Canvas implements Tool {

    private final String command = "[C]\\s\\d+\\s\\d+";
    private final String vertical_symbol = "|";
    private final String horizontal_symbol = "-";

    private Integer width;
    private Integer height;

    public Canvas() {
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Getters
    public Integer getWidth() {
        return width;
    }
    public Integer getHeight() {
        return height;
    }

    public String getVertical_symbol() {
        return vertical_symbol;
    }
    public String getHorizontal_symbol() {
        return horizontal_symbol;
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
    public Image draw(Image image) {
        image.setCanvas(new Canvas(width, height));
        return image;
    }
}

