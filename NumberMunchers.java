import kareltherobot.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

public class NumberMunchers extends Robot implements KeyListener , Runnable 
{
   public boolean north = false, west = false, east = false , south = false , pick = false;
   
   
   public NumberMunchers(int s, int a, Direction d, int b, Color c)
   {
      super(s, a, d, b, c);
      World.setupThread(this);
      
   }
   
   public void move(){
      if (frontIsClear())
         super.move();
   }
   
   public void faceUp(){
      while(!facingNorth())
         turnLeft();
   }
   
   public void faceRight(){
      while (!facingEast())
         turnLeft();
   }
   
   public void faceDown(){
      while(!facingSouth())
         turnLeft();
   }
   
   public void faceLeft(){
      while(!facingWest())
         turnLeft();
   }

   
   
   public void numbMunch()
   {
      int i = 0;
      
    EasySound munch = new EasySound("blurp_x.wav");

      while(nextToABeeper()) 
      {
         pickBeeper();
         i++;
      }
      if(i%3!=0)
      {
         turnOff();
      }
      
   }
   public void register(RobotListener listener)
   {
      myListener = listener;
   }
    
    public boolean getPoints()
    {
      int i = 0;
      
      while(nextToABeeper()) 
      {
         pickBeeper();
         i++;
      }
      if(i%3!=0)
      {
         return false;
      }
      else{
      return true;
      }
    } 
  
   public void keyTyped(KeyEvent e) {
    
   }
   public void keyReleased(KeyEvent e){
    
   }
   public void keyPressed(KeyEvent e)
   {
      switch(e.getKeyCode()){
         case KeyEvent.VK_UP:
            faceUp();
            move();
            break;
         case KeyEvent.VK_DOWN:
            faceDown();
            move();
            break;
         case KeyEvent.VK_RIGHT:
            faceRight();
            move();
            break;
         case KeyEvent.VK_LEFT:
            faceLeft();
            move();
            break;
         case KeyEvent.VK_ENTER:
            numbMunch();
            myListener.action();
            break;
         default:
      }
   } 
   
   
   
   private RobotListener myListener = new NullListener();
   
   
      
   public void run()
   {
      World.worldCanvas().addKeyListener(this);
      while(true)
      {
        
      }
   }
   
   // public static void main(String args[])
//    {
//       World.setTrace(false);
//       World.showSpeedControl(true);
//       World.readWorld("NumbMunchBeta.kwld");
//       World.worldCanvas().setFocusable(true);  
//       World.setVisible(true);
//       World.setDelay(7);
//       
//       World.setWorldColor(Color.black);
//       World.setBeeperColor(Color.green);
//       World.setNeutroniumColor(Color.blue);
//       World.setStreetColor(Color.pink);
//       
//       
//       NumberMunchers jim = new NumberMunchers(3,3,East,0,Color.blue);
//       
//       
//       
//    }

   
}  


