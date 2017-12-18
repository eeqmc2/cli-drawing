package com.example.drawing.tools;

import com.example.drawing.Coords;
import com.example.drawing.Image;

import java.util.Map;

/**
 * Created by Alex on 17/12/2017.
 */
public interface Tool {


    boolean parse(String userInput);
    boolean validate();
    Image execute(Image image);


}
