package com.example.drawing.tools;

import com.example.drawing.DrawingTool;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

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
        Line l1 = new Line();
        String command1 = "L 0 2 6 2";
        assertFalse(l1.parse(command1));

        Line l2 = new Line();
        String command2 = "L 6 0 6 1";
        assertFalse(l2.parse(command2));
    }

    @Test
    public void rejectLineWithNegativeCoord() {
        Line l1 = new Line();
        String command1 = "L -1 3 4 3";
        assertFalse(l1.parse(command1));

        Line l2 = new Line();
        String command2 = "L 3 -1 3 6";
        assertFalse(l2.parse(command2));
    }

    @Test
    public void canDrawLineWithoutErrors() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "------------\r\n" +
                                "|          |\r\n" +
                                "|  xxxxx   |\r\n" +
                                "|          |\r\n" +
                                "|          |\r\n" +
                                "|          |\r\n" +
                                "------------\r\n";
        // Draw Line
        DrawingTool dt = new DrawingTool();
        dt.paint("L 3 2 7 2");
        dt.print();
        assertEquals(expectedOutput, outContent.toString());
    }
}
