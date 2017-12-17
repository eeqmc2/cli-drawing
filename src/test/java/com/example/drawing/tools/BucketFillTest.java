package com.example.drawing.commands;

import com.example.drawing.Image;
import com.example.drawing.tools.BucketFill;
import com.example.drawing.tools.Canvas;
import com.example.drawing.tools.Rectangle;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 16/12/2017.
 */
public class BucketFillTest {

    @Test
    public void acceptValidFormatBucketFillCommand() {
        String command = "B 10 3 o";
        BucketFill bf = new BucketFill();
        bf.parse(command);
        assertTrue(bf.parse(command));

        command = "B 10 3 #";
        bf = new BucketFill();
        bf.parse(command);
        assertTrue(bf.parse(command));
    }


    @Test
    public void rejectInvalidBucketFillCommand() {
        String command = "B 10 o";
        BucketFill bf = new BucketFill();
        bf.parse(command);
        assertFalse(bf.parse(command));
    }

    @Test
    public void rejectBucketFillWithZeroCoords() {
        BucketFill bf = new BucketFill();
        String command = "B 0 5 o";
        assertFalse(bf.parse(command));

        bf = new BucketFill();
        command = "B 3 0 o";
        assertFalse(bf.parse(command));
    }

    @Test
    public void rejectBucketFillWithNegativeCoords() {
        BucketFill bf = new BucketFill();
        String command = "B -1 5 o";
        assertFalse(bf.parse(command));

        bf = new BucketFill();
        command = "B 3 -4 o";
        assertFalse(bf.parse(command));
    }

    @Test
    public void canBucketFillWithoutErrors() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "            \r\n" +
                                " ?????????? \r\n" +
                                " ?????????? \r\n" +
                                " ?????????? \r\n" +
                                " ?????????? \r\n" +
                                " ?????????? \r\n" +
                                "            \r\n";

        // Draw Rectangle
        Image image = new Image();
        BucketFill bf = new BucketFill();
        bf.parse("B 1 3 ?");
        image.draw(bf);
        image.print();
        assertEquals(expectedOutput, outContent.toString());
    }
}
