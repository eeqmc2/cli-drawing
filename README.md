# Simple Command Line Drawing Tool

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


## Assumptions

  Drawing program will:
  
  1. Apply a default 20 by 10 canvas if the user have not specify one
  Rationale:
  * Program was designed to be as user-accomodating as possible, does not state specifically canvas must be set first.
  * This mimic closely the behavior with Windows paint (e.g. default white empty canvas)
  
  2. Program will attempt to draw objects even if spans outside of the canvas.  
  The resulting object will be truncated as it goes beyond the edge of the canvas
  Rationale:
  * Program was designed to be as user-accomodating as possible

  
  