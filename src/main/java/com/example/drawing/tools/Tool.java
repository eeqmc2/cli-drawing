package com.example.drawing.tools;

import com.example.drawing.Image;

/**
 * Interface class of all the Drawing Tools
 */
public interface Tool {

    /**
     * Method that validates the format of the command
     * @param userInput
     * @return true if the userInput matches the required
     *         format of the respective tool
     */
    boolean parse(String userInput);

    /**
     * Method that validates the dimension of the parameters
     * @return true if the parameters are valid for
     *          respective tool
     */
    boolean validate();

    /**
     * Method that adds the new image provided in the paremter
     * @param image is the new image to be added
     * @return the resulting image
     */
    Image draw(Image image);

}
