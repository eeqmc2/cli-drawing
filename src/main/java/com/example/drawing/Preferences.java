package com.example.drawing;

import com.example.drawing.tools.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 16/12/2017.
 */
public class Preferences {

    public static final String DEFAULT_BACKGROUND = " ";
    public static final Integer DEFAULT_CANVAS_WIDTH = 10;
    public static final Integer DEFAULT_CANVAS_HEIGHT = 5;
    public static final String QUIT_COMMAND = "Q";
    public static final List<Tool> TOOLS = Arrays.asList(
            new Canvas(),
            new Line(),
            new Rectangle(),
            new BucketFill()
    );

}
