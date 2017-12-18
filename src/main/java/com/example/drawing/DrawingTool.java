package com.example.drawing;

import com.example.drawing.tools.Tool;

import java.util.Scanner;

import static com.example.drawing.Preferences.QUIT_COMMAND;

/**
 * Simple console version of a drawing program
 */
public class DrawingTool {

    private Image image;

    public DrawingTool() {
        this.image = new Image();
    }

    /**
     * Prompts the user for to input commands
     *
     * @return true when user enters the quit command
     */
    public boolean start() {

        String userInput = "";
        do {
            userInput = getUserCommand();
            boolean success = paint(userInput);
            if (success)
                image.print();
        } while (!QUIT_COMMAND.equals(userInput));

        /*
        while (!QUIT_COMMAND.equals(userInput))
        {
            userInput = getUserCommand();
            boolean success = paint(userInput);
            if (success) {
                image.print();
            }
        }*/
        return true;
    }

    /**
     *  Prompt users for command line input from console
     *
     * @return The user entered command in String
     */
    public String getUserCommand() {

        System.out.println("enter command: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    /**
     *  Validates string command
     *
     * @param userInput
     *
     * @return true if the command is a valid command, otherwise false
     */
    public boolean paint(String userInput) {

        for (Tool tool : Preferences.TOOLS) {
            if (tool.parse(userInput)) {
                image = tool.draw(image);
                return true;
            }
        }
        return false;
    }

    /**
     * Prints the Image to Console
     */
    public void print() {
        image.print();
    }

    public static void main(String[] args)  {

        DrawingTool dt = new DrawingTool();
        dt.start();
    }

}
