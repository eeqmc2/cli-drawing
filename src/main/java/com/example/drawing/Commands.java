package com.example.drawing;

import org.apache.commons.cli.*;

import java.util.Arrays;

/**
 * Created by Alex on 9/12/2017.
 */
public class Commands {

    public static Options constructOptions() {

        final Options options = new Options();

        options.addOption(Option.builder("C")
                .required(true)
                .hasArg(true)
                .longOpt("Canvas")
                .desc("Create a new canvas of width w and height h.")
                .build());

        options.addOption(Option.builder("L")
                .required(true)
                .hasArg(true)
                .longOpt("Line")
                .desc("Create a new line from (x1,y1) to (x2,y2).")
                .build());

        options.addOption(Option.builder("R")
                .required(true)
                .hasArg(true)
                .longOpt("Rectangle")
                .desc("Create a new rectangle, whose upper left corner is (x1,y1) " +
                        "and lower right corner is (x2,y2).")
                .build());

        options.addOption(Option.builder("B")
                .required(true)
                .hasArg(true)
                .longOpt("Bucketfill")
                .desc("Fill the entire area connected to (x,y) with \"colour\" c")
                .build());

        options.addOption(Option.builder("Q")
                .required(true)
                .hasArg(true)
                .longOpt("Quit")
                .desc("Quit the program")
                .build());

        return options;

    }

    public static CommandLine generateCommandLine(
            final Options options, final String[] commandLineArguments)
    {
        final CommandLineParser cmdLineParser = new DefaultParser();
        CommandLine commandLine = null;
        try
        {
            commandLine = cmdLineParser.parse(options, commandLineArguments);
        }
        catch (ParseException parseException)
        {
            System.err.println(
                    "ERROR: Unable to parse command-line arguments "
                            + Arrays.toString(commandLineArguments) + " due to: "
                            + parseException);
        }
        return commandLine;
    }


}
