package com.example.drawing.tools;

import com.example.drawing.Coords;

import java.util.Map;

/**
 * Created by Alex on 17/12/2017.
 */
public interface Action {

    boolean parse(String userInput);
    boolean validate();
    Map<Coords, String> execute();

}
