package com.example.drawing.commands;

import com.example.drawing.tools.BucketFill;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alex on 16/12/2017.
 */
public class BucketFillTest {

    @Test
    public void acceptCorrectFormatBucketFillCommand() {

        String command = "B 10 3 o";
        BucketFill bf = new BucketFill();
        bf.parse(command);
        assertEquals(true, bf.parse(command));
    }

    @Test
    public void rejectUnsupportedFormatBucketFillCommand() {

        String command = "B 10 o";
        BucketFill bf = new BucketFill();
        bf.parse(command);
        assertEquals(false, bf.parse(command));
    }

    @Test
    public void acceptInvalidBucketFillCommand() {

        String command = "B -1 3 o";
        BucketFill bf = new BucketFill();
        bf.parse(command);
        assertEquals(false, bf.parse(command));
    }
}
