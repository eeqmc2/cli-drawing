package com.example.drawing.commands;

import com.example.drawing.DrawingTool;
import com.example.drawing.tools.BucketFill;
import com.example.drawing.tools.Rectangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alex on 10/12/2017.
 */
public class RectangleTest {
/*
    @Test
    public void acceptCorrectFormatRectangleCommand() {

        String command = "R 14 1 18 3";
        Rectangle rect = new Rectangle();
        rect.parse(command);
        assertEquals(true, rect.parse(command));
    }
    */



    @Test
    public void acceptValidRectangleCommand() {

        Rectangle rect = new Rectangle();
        String command = "R 14 1 18 3";
        assertEquals(true, rect.parse(command));
    }

    @Test
    public void rejectInvalidRectangleCommand() {

        Rectangle rect = new Rectangle();
        String command = "R 14 1 18";
        assertEquals(false, rect.parse(command));
    }

}
