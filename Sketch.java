import processing.core.PApplet;
import java.util.Random;
/**
* A program that draws a house in a random location, a sun, grass, and a sky to the screen.
* Optomizes it so when window is resized, the image is not distorted
* Changes background colour based on where it is on the screen
* @author: Joel Menezes
*/
public class Sketch extends PApplet {
  
  // Defining Variables to be used globably
  int intHeight;
  int intWidth;

  public void settings() {
    
    // Window Size
    size(400, 400);

  }

  
  public void setup() {
    
    // Make Window Resizeable
    surface.setResizable(true);

    // Generate a new number & Updating global variables
    Random myRandom = new Random();
    intHeight = myRandom.nextInt((height/5) + 1);
    intWidth = myRandom.nextInt((width/5) + 1);

    // If Odd, Show on right side, if Even have it on left 
    if (intHeight % 2 == 1){
      intHeight = intHeight * -1;
    }
    if (intWidth % 2 == 1){
      intWidth = intWidth * -1;
    }

    if (intHeight <= 40 && intWidth >= 40){
      background(255, 3, 2); // Bright Red
    }
    else if (intHeight >= 40 && intWidth <= 40){ 
      background(3, 255, 2); // Lime Green
    }
    else{
      background(135, 206, 235); // Sky Blue
    }
  }

  public void draw() {
    
    // Yellow Sun
    fill(255, 213, 0);
    noStroke();
	  ellipse(Math.round(width), 0, Math.round(width/4), Math.round(height/4));

    // Grass
    fill(56, 128, 4); 
    rect(0, Math.round(height*0.875), Math.round(width), Math.round(height/8));
    
    // House
    noStroke();
    fill(202, 164, 114); // Base
    rect(Math.round(width/4) - intWidth, Math.round(height/1.6) - intHeight, Math.round(width/2), Math.round(0.375*height));
    fill(99, 70, 45); // Support beam
    rect(Math.round(width/4) - intWidth, Math.round(height/1.6) - intHeight, Math.round(width/2), Math.round(height*0.0475));
    fill(99, 70, 45); // Roof
    triangle(Math.round(width/4) - intWidth, Math.round(height/1.6) - intHeight, Math.round(width*0.75) - intWidth, Math.round(height/1.6) - intHeight, Math.round(width/2) - intWidth, Math.round(0.375*height) - intHeight);
    fill(164, 116, 73); // Top Panel
    triangle(Math.round(width*0.3125) - intWidth, Math.round(height/1.6) - intHeight, Math.round(width*0.6875) - intWidth, Math.round(height/1.6) - intHeight, Math.round(width/2) - intWidth, Math.round(height*0.4375) - intHeight);
    fill(64, 47, 29); // Door
    rect(Math.round(0.45625*width) - intWidth, Math.round(0.875*height) - intHeight, Math.round(0.0875*width), Math.round(height/8));
    fill(255, 213, 0); // Door Knob
    ellipse(Math.round(0.525*width) - intWidth, Math.round(0.9375*height) - intHeight, Math.round(width/160), Math.round(height/160));
    
    // Displays Time on Screen
    int intHours = hour();
    int intMinutes = minute();
    fill(255, 255, 255);
    textSize(30);
    text(intHours, Math.round(width/4), Math.round(height/4)); // Hours
    text(intMinutes, Math.round(width/4), Math.round(height/(800/225))); // Minutes
             
  }  
} 