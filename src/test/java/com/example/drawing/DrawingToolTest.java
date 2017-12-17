package com.example.drawing;


import com.example.drawing.tools.Canvas;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

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
        assertEquals(true, dt.parse(command));
    }

    @Test
    public void rejectInvalidCanvasCommand() {
        DrawingTool dt = new DrawingTool();
        String command = "C 20 14 5";
        assertEquals(false, dt.parse(command));
    }

    @Test
    public void shouldAcceptValidLineCommand() {

        DrawingTool dt = new DrawingTool();
        String command = "L 1 2 6 2";
        assertEquals(true, dt.parse(command));
    }

    @Test
    public void shouldRejectInvalidLineCommand() {

        DrawingTool dt = new DrawingTool();
        String command = "L 1 2 6";
        assertEquals(false, dt.parse(command));
    }

    @Test
    public void shouldAcceptValidBucketFillCommand() {

        DrawingTool dt = new DrawingTool();
        String command = "B 10 3 o";
        assertEquals(true, dt.parse(command));
    }

    @Test
    public void shouldRejectInvalidBucketFillCommand() {

        DrawingTool dt = new DrawingTool();
        String command = "B 10 3";
        assertEquals(false, dt.parse(command));
    }

    @Test
    public void shouldAcceptValidQuitCommand() {

        DrawingTool dt = new DrawingTool();
        String quitCommand = "Q";
        System.setIn(new ByteArrayInputStream(quitCommand.getBytes()));
        assertEquals(true, dt.start());

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
        String userCommand = "C 20 4";
        dt.parse(userCommand);

        userCommand = "L 1 2 6 2";
        dt.parse(userCommand);

        userCommand = "L 6 3 6 4";
        dt.parse(userCommand);

        userCommand = "R 14 1 18 3";
        dt.parse(userCommand);

        userCommand = "B 10 3 o";
        dt.parse(userCommand);

        dt.print();
        assertEquals(expectedOutput, outContent.toString());
    }

}
