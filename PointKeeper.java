import kareltherobot.*;

public class PointKeeper extends UrRobot implements Runnable, RobotListener
{
   public PointKeeper(int s, int a, Direction d, int b)
   {  
      super(s,a,d,b);
      World.setupThread(this);
   }

  public void action()
   {
      turnLeft();
      move();
      putBeeper();
      turnLeft();
      turnLeft();
      move();
      turnLeft();  
   }
   
  
 
   
                 
     
   
     
}