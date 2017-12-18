package com.example.drawing;


import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DrawingToolTest {

    @Test
    public void shouldTrimLeadingTrailingSpacesInCommand() {

        DrawingTool dt = new DrawingTool();
        String actualCommand = " C 20 4 ";
        String expectedCommand = "C 20 4";
        System.setIn(new ByteArrayInputStream(actualCommand.getBytes()));
        assertEquals(expectedCommand, dt.getUserCommand());
    }

    @Test
    public void acceptValidCanvasCommand() {
        DrawingTool dt = new DrawingTool();
        String command = "C 20 14";
        assertTrue(dt.paint(command));
    }

    @Test
    public void rejectInvalidCanvasCommand() {
        DrawingTool dt = new DrawingTool();
        String command = "C 20 14 5";
        assertFalse(dt.paint(command));
    }

    @Test
    public void shouldAcceptValidLineCommand() {

        DrawingTool dt = new DrawingTool();
        String command = "L 1 2 6 2";
        assertTrue(dt.paint(command));
    }

    @Test
    public void shouldRejectInvalidLineCommand() {

        DrawingTool dt = new DrawingTool();
        String command = "L 1 2 6";
        assertFalse(dt.paint(command));
    }

    @Test
    public void shouldAcceptValidBucketFillCommand() {

        DrawingTool dt = new DrawingTool();
        String command = "B 6 3 o";
        assertTrue(dt.paint(command));
    }

    @Test
    public void shouldRejectInvalidBucketFillCommand() {

        DrawingTool dt = new DrawingTool();
        String command = "B 10 3";
        assertFalse(dt.paint(command));
    }

    @Test
    public void shouldAcceptValidQuitCommand() {

        DrawingTool dt = new DrawingTool();
        String quitCommand = "Q";
        System.setIn(new ByteArrayInputStream(quitCommand.getBytes()));
        assertTrue(dt.start());

    }

    @Test
    public void canDrawMultipleShapes() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "----------------------\r\n" +
                                "|oooooooooooooxxxxxoo|\r\n" +
                                "|xxxxxxooooooox   xoo|\r\n" +
                                "|     xoooooooxxxxxoo|\r\n" +
                                "|     xoooooooooooooo|\r\n" +
                                "----------------------\r\n";
        DrawingTool dt = new DrawingTool();
        dt.paint("C 20 4");
        dt.paint("L 1 2 6 2");
        dt.paint("L 6 3 6 4");
        dt.paint("R 14 1 18 3");
        dt.paint( "B 10 3 o");
        dt.print();
        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    public void canDrawMultipleShapesWithDefaultCanvas() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "------------\r\n" +
                                "|          |\r\n" +
                                "|xxxxxx    |\r\n" +
                                "|   xxxxxx |\r\n" +
                                "|   x    x |\r\n" +
                                "|   xxxxxx |\r\n" +
                                "------------\r\n";

        DrawingTool dt = new DrawingTool();
        dt.paint("L 1 2 6 2");
        dt.paint("R 4 3 9 5");
        dt.print();
        assertEquals(expectedOutput, outContent.toString());

    }

    @Test
    public void shouldTruncateHorizonLineThatBreachOutOfCanvas() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "------------\r\n" +
                                "|          |\r\n" +
                                "|      xxxx|\r\n" +
                                "|          |\r\n" +
                                "|          |\r\n" +
                                "|          |\r\n" +
                                "------------\r\n";
        DrawingTool dt = new DrawingTool();
        dt.paint("C 10 5");
        dt.paint("L 7 2 14 2");
        dt.print();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void shouldTruncateVerticalLineThatBreachOutOfCanvas() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "------------\r\n" +
                                "|          |\r\n" +
                                "|      x   |\r\n" +
                                "|      x   |\r\n" +
                                "|      x   |\r\n" +
                                "|      x   |\r\n" +
                                "------------\r\n";
        DrawingTool dt = new DrawingTool();
        dt.paint("C 10 5");
        dt.paint("L 7 2 7 21");
        dt.print();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void shouldTruncateRectangleThatBreachOutOfCanvas() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "------------\r\n" +
                                "|          |\r\n" +
                                "|     xxxxx|\r\n" +
                                "|     x    |\r\n" +
                                "|     x    |\r\n" +
                                "|     x    |\r\n" +
                                "------------\r\n";
        DrawingTool dt = new DrawingTool();
        dt.paint("C 10 5");
        dt.paint("R 6 2 14 6");
        dt.print();
        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    public void shouldNotErrorWhenLineIsCompletelyOutOfCanvas() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "-----------------\r\n" +
                                "|               |\r\n" +
                                "|               |\r\n" +
                                "|               |\r\n" +
                                "|               |\r\n" +
                                "|               |\r\n" +
                                "-----------------\r\n";
        DrawingTool dt = new DrawingTool();
        dt.paint("C 15 5");
        dt.paint("L 3 6 10 6");
        dt.print();
        assertEquals(expectedOutput, outContent.toString());
    }
}
