package com.example.drawing;

import com.example.drawing.tools.Action;
import com.example.drawing.tools.BucketFill;
import com.example.drawing.tools.Canvas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static com.example.drawing.Preferences.QUIT_COMMAND;

/**
 * Simple console version of a drawing program
 */
public class DrawingTool {

    private final static Logger logger = LoggerFactory.getLogger(DrawingTool.class);

    private Image image;

    public DrawingTool() {
        this.image = new Image();
    }


    public Image getImage() {
        return image;
    }

    /**
     *  Prompt users for command line input from console
     *
     * @return The user entered command in String
     */
    public String getUserCommand() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("enter command: ");
        return scanner.nextLine();
    }

    /**
     *  Validates string command
     *
     * @param userInput
     *
     * @return true if the command is valid command, otherwise false
     */
    public boolean parse(String userInput) {

        for (Action action : Preferences.FUNCTIONS) {
            if (action.parse(userInput)) {
                if (action instanceof Canvas) {
                    image.setCanvas((Canvas)action);
                    image.draw(action.execute());
                } else if (action instanceof BucketFill) {
                    BucketFill bf = new BucketFill(userInput);
                    bf.setImage(image);
                    image.draw(bf.execute(bf.getPt(), bf.getMarker()));
                } else
                    image.draw(action.execute());
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)  {

        DrawingTool dt = new DrawingTool();
        String userInput = "";
        while (!QUIT_COMMAND.equals(userInput))
        {
            userInput = dt.getUserCommand().trim();
            boolean success = dt.parse(userInput);
            if (success) {
                dt.getImage().print();
            } else {
                logger.warn("Unable to recognise command");
            }
        }
    }
}
