# Simple Command Line Drawing Tool

## Problem Statements

You're given the task of writing a simple console version of a drawing program. 
At this time, the functionality of the program is quite limited but this might change in the future. 
In a nutshell, the program should work as follows:
 1. Create a new canvas
 2. Start drawing on the canvas by issuing various commands
 3. Quit


Command 		Description
C w h           Should create a new canvas of width w and height h.
L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
                horizontal or vertical lines are supported. Horizontal and vertical lines
                will be drawn using the 'x' character.
R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
                using the 'x' character.
B x y c         Should fill the entire area connected to (x,y) with "colour" c. The
                behaviour of this is the same as that of the "bucket fill" tool in paint
                programs.
Q               Should quit the program.

__Sample I/O__

Below is a sample run of the program. User input is prefixed with enter command:

enter command: C 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------

enter command: L 1 2 6 2
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------

enter command: L 6 3 6 4
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------

enter command: R 14 1 18 3
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------

enter command: B 10 3 o
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------

enter command: Q


## Assumptions

  Drawing program will:
  
  1. Apply a default 10 by 5 canvas if the user have not specify one
  Rationale:
  * Program was designed to be as least restrictive as possible, does not state specifically canvas must be set first.
  * This mimic closely the behavior with Windows paint (e.g. default white empty canvas)
  
  2. Program will attempt to draw objects even if spans outside of the canvas.  
  The resulting object will be truncated as it goes beyond the edge of the canvas
  Rationale:
  * Program was designed to be as least restrictive as possible
  

## Prerequisites

The code has been developed and tested using:

  JDK 1.8
  Apache Maven 3.5.0


## Quickstart

Build your project with:

	mvn clean package

Build your project skipping the tests:

	mvn clean package -DskipTests


To run the program:

	mvn exec:java -Dexec.mainClass=com.example.drawing.DrawingTool


  
  