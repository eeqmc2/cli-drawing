package com.example.drawing.commands;


import com.example.drawing.Image;
import com.example.drawing.tools.Canvas;
import com.example.drawing.tools.Rectangle;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 10/12/2017.
 */
public class CanvasTest {

    @Test
    public void acceptValidCanvasCommand() {

        Canvas c = new Canvas();
        String command = "C 20 14";
        assertEquals(true, c.parse(command));
    }


    @Test
    public void rejectUserInputWithIncorrectFormat() {
        Canvas c = new Canvas();
        String command = "C 20 14 5";
        assertEquals(false, c.parse(command));
    }

    @Test
    public void rejectCanvasWithNegativeHeight() {
        Canvas c = new Canvas();
        String command = "C 10 -4";
        assertEquals(false, c.parse(command));
    }

    @Test
    public void drawCanvasWithoutErrors() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "-----\r\n|   |\r\n|   |\r\n|   |\r\n|   |\r\n-----\r\n";
        Image image = new Image();
        Canvas c = new Canvas();
        c.parse("C 3 4");
        image.setCanvas(c);
        image.draw(c.execute());
        image.print();
        assertTrue(expectedOutput.equals(outContent.toString()));
    }
}
