package com.example.drawing.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 10/12/2017.
 */
public class LineTest {

/*
    @Test
    public void checkLineCommandFormat() {
        Line l = new Line();
        assertEquals("[L]\\s\\d+\\s\\d+\\s\\d+\\s\\d+", l.getCommand());
    }

    @Test
    public void acceptUserInputWithCorrectFormat() {
        Line l = new Line();
        String command = "L 1 2 6 2";
        assertEquals(true, l.initialise(command));
    }

    @Test
    public void rejectUserInputWithIncorrectFormat() {
        Line l = new Line();
        String command = "L 1 2 6 2 3";
        assertEquals(false, l.initialise(command));
    }

    @Test
    public void acceptValidUserInput() {
        Line l = new Line();
        String command = "L 1 3 4 3";
        assertEquals(true, l.initialise(command));
    }

    @Test
    public void rejectLineWithZeroXCoord() {
        Line l = new Line();
        String command = "L 0 2 6 2";
        assertEquals(false, l.initialise(command));
    }

    @Test
    public void rejectLineWithNegativeYCoord() {
        Line l = new Line();
        String command = "L 1 -1 4 -1";
        assertEquals(false, l.initialise(command));
    }
*/
    /*
    @Test
    public void canDrawWithoutErrors() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "";
        Line l = new Line();
        String command = "L 1 2 3 2";
        l.initialise(command);
        l.process();
        assertTrue(expectedOutput.equals(outContent.toString()));
    }*/
}
