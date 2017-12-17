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
public class LineTest {

    @Test
    public void acceptValidLineCommand() {
        Line l = new Line();
        String command = "L 1 2 6 2";
        assertTrue(l.parse(command));
    }

    @Test
    public void rejectInvalidLineCommand() {
        Line l = new Line();
        String command = "L 1 2 6 2 3";
        assertFalse(l.parse(command));
    }

    @Test
    public void rejectLineWithZeroCoords() {
        Line l = new Line();
        String command = "L 0 2 6 2";
        assertFalse(l.parse(command));

        l = new Line();
        command = "L 6 0 6 1";
        assertFalse(l.parse(command));
    }

    @Test
    public void rejectLineWithNegativeCoord() {
        Line l = new Line();
        String command = "L -1 3 4 3";
        assertFalse(l.parse(command));

        l = new Line();
        command = "L 3 -1 3 6";
        assertFalse(l.parse(command));
    }

    @Test
    public void canDrawLineWithoutErrors() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "            \r\n" +
                                "            \r\n" +
                                "   xxxxx    \r\n" +
                                "            \r\n" +
                                "            \r\n" +
                                "            \r\n" +
                                "            \r\n";

        // Draw Line
        Image image = new Image();
        Line l = new Line();
        l.parse("L 3 2 7 2");
        image.draw(l);
        image.print();
        assertEquals(expectedOutput, outContent.toString());
    }
}
