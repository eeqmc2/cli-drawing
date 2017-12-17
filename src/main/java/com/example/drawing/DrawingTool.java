package com.example.drawing;

import com.example.drawing.tools.Tool;
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

    /**
     *  Prompt users for command line input from console
     *
     * @return The user entered command in String
     */
    public String getUserCommand() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("enter command: ");
        return scanner.nextLine().trim();
    }

    public void print() {
        image.print();
    }

    /**
     *  Validates string command
     *
     * @param userInput
     *
     * @return true if the command is a valid command, otherwise false
     */
    public boolean parse(String userInput) {

        for (Tool tool : Preferences.TOOLS) {
            if (tool.parse(userInput)) {
                image.draw(tool);
                return true;
            }
        }
        return false;
    }

    /**
     * Prompts the user for to input commands
     * @return true when user enters the quit command
     */
    public boolean start() {

        String userInput = "";
        while (!QUIT_COMMAND.equals(userInput))
        {
            userInput = getUserCommand();
            boolean success = parse(userInput);
            if (success) {
                image.print();
            } else {
                logger.warn(String.format(
                        "Unable to recognise command, please retry or type '%s' to quit",
                        Preferences.QUIT_COMMAND));
            }
        }
        return true;
    }

    public static void main(String[] args)  {

        DrawingTool dt = new DrawingTool();
        dt.start();
    }

}
