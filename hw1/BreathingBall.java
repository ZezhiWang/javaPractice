import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BreathingBall extends Ball implements ActionListener
{
  
  public BreathingBall(int width, int height)
  {
    super(width,height);
  }
  
  public void move()
  {
    super.move();
    diameter += (int)(40*Math.random())-20;
  }
}