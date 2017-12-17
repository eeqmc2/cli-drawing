package com.example.drawing;

import com.example.drawing.tools.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 15/12/2017.
 */
public class Preferences {

    public static final String DEFAULT_BACKGROUND = " ";
    public static final int DEFAULT_CANVAS_WIDTH = 20;
    public static final int DEFAULT_CANVAS_HEIGHT = 5;
    public static final String QUIT_COMMAND = "Q";
    public static final List<Action> FUNCTIONS = Arrays.asList(
            new Canvas(),
            new Line(),
            new Rectangle(),
            new BucketFill()
    );

}
