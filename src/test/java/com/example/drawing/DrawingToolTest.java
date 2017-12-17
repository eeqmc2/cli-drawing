package com.example.drawing;


import org.junit.Test;
import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class DrawingToolTest {

    @Test
    public void acceptAllSampleCommands() {

        DrawingTool dt = new DrawingTool();
        String userCommand = "C 20 4";
        System.setIn(new ByteArrayInputStream(userCommand.getBytes()));
        assertEquals(userCommand, dt.getUserCommand());
    }

    @Test
    public void shouldAcceptValidCanvasCommand() {

        DrawingTool dt = new DrawingTool();
        String command = "C 20 4";
        assertEquals(true, dt.parse(command));
    }

    @Test
    public void shouldRejectInvalidCanvasCommand() {

        DrawingTool dt = new DrawingTool();
        String command = "C 20";
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
/*
    @Test
    public void shouldAcceptValidQuitCommand() {

        DrawingTool dt = new DrawingTool();
        String command = "Q";
        assertEquals(true, dt.parse(command));
    }
*/
    @Test
    public void shouldRejectInvalidQuitCommand() {

        DrawingTool dt = new DrawingTool();
        String command = "Q 10";
        assertEquals(false, dt.parse(command));
    }

    @Test
    public void canSetDrawings() {

        String initialCanvas = "-----\r\n|   |\r\n|   |\r\n|   |\r\n|   |\r\n-----\r\n";
        DrawingTool dt = new DrawingTool();
        //dt.setDrawing(initialCanvas);
        //assertEquals(initialCanvas, dt.getDrawing());
    }

    @Test
    public void canDrawOverTopOfDrawing() {

        DrawingTool dt = new DrawingTool();

        /*
        String userCommand = "C 20 4";
        dt.parse(userCommand);


        userCommand = "L 1 2 6 2";
        dt.parse(userCommand);

        userCommand = "L 6 3 6 4";
        dt.parse(userCommand);

        userCommand = "R 14 1 18 3";
        dt.parse(userCommand);

        //userCommand = "R 12 1 16 4";
        //dt.parse(userCommand);
*/
        String userCommand = "B 10 3 o";
        dt.parse(userCommand);

        dt.getImage().print();

    }

}
