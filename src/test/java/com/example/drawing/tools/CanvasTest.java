package com.example.drawing.tools;


import com.example.drawing.Image;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 16/12/2017.
 */
public class CanvasTest {

    @Test
    public void acceptValidCanvasCommand() {
        Canvas c = new Canvas();
        String command = "C 20 14";
        assertTrue(c.parse(command));
    }

    @Test
    public void rejectInvalidCanvasCommand() {
        Canvas c = new Canvas();
        String command = "C 20 14 5";
        assertFalse(c.parse(command));
    }

    @Test
    public void rejectCanvasWithNegativeWidth() {
        Canvas c = new Canvas();
        String command = "C -12 4";
        assertFalse(c.parse(command));
    }

    @Test
    public void rejectCanvasWithNegativeHeight() {
        Canvas c = new Canvas();
        String command = "C 10 -4";
        assertFalse(c.parse(command));
    }

    @Test
    public void canDrawCanvasWithoutErrors() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "-----\r\n" +
                                "|   |\r\n" +
                                "|   |\r\n" +
                                "|   |\r\n" +
                                "|   |\r\n" +
                                "-----\r\n";

        // Draw Canvas
        Image image = new Image();
        Canvas c = new Canvas();
        c.parse("C 3 4");
        image.draw(c);
        image.print();
        assertEquals(expectedOutput, outContent.toString());
    }
}
