package com.example.drawing.tools;

import com.example.drawing.DrawingTool;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by Alex on 16/12/2017.
 */
public class RectangleTest {

    @Test
    public void acceptValidRectangleCommand() {
        Rectangle rect = new Rectangle();
        String command = "R 14 1 18 3";
        assertTrue(rect.parse(command));
    }

    @Test
    public void rejectInvalidRectangleCommand() {
        Rectangle rect = new Rectangle();
        String command = "R 14 1 18";
        assertFalse(rect.parse(command));
    }

    @Test
    public void rejectRectangleWithZeroCoords() {
        Rectangle rect = new Rectangle();
        String command = "R 14 0 18 3";
        assertFalse(rect.parse(command));

        rect = new Rectangle();
        command = "R 0 1 5 3";
        assertFalse(rect.parse(command));
    }

    @Test
    public void rejectRectangleWithNegativeCoord() {
        Rectangle rect = new Rectangle();
        String command = "R -1 1 6 3";
        assertFalse(rect.parse(command));

        rect = new Rectangle();
        command = "R 14 -1 18 3";
        assertFalse(rect.parse(command));
    }

    @Test
    public void canDrawRectangleWithoutErrors() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "------------\r\n" +
                                "|          |\r\n" +
                                "|    xxxxx |\r\n" +
                                "|    x   x |\r\n" +
                                "|    x   x |\r\n" +
                                "|    xxxxx |\r\n" +
                                "------------\r\n";

        // Draw Rectangle
        DrawingTool dt = new DrawingTool();
        dt.paint("R 5 2 9 5");
        dt.print();
        assertEquals(expectedOutput, outContent.toString());
    }
}
