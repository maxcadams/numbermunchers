/*

NumberMunchers by Max Adams

To Play:
Set control to resume and slide speed to right
Move robot with arrow keys and press enter when you are on a beeper pile that is divisible by 3 to earn points
If you press enter on a beeper bile that is not divisible by 3 your robot will turn off and you will need to restart your game

Points are shown in the top right corner of the map

Good luck!

*/



import kareltherobot.*;
import java.awt.Color;

public class NumberMunchersGame implements Directions
{
    public static void main(String args[])
   {
      World.setTrace(false);
      World.showSpeedControl(true);
      World.readWorld("NumberMunchersALPHAWORLD.kwld");
      World.worldCanvas().setFocusable(true);  
      World.setVisible(true);
      World.setDelay(7);
      
      World.setWorldColor(Color.black);
      World.setBeeperColor(Color.green);
      World.setNeutroniumColor(Color.blue);
      World.setStreetColor(Color.pink);
      
      
      NumberMunchers jim = new NumberMunchers(3,3,East,0,Color.blue);
      PointKeeper jerry = new PointKeeper(13,12,South,infinity);
      
      
     jim.register(jerry);
      
      
      
   }
}