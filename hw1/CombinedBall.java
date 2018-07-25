import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CombinedBall extends Ball implements ActionListener
{
  protected double curvature = (5*Math.random()+15);
  
  public CombinedBall(int width, int height)
  {
    super(width,height);
  }
  public void move()
  {
    super.move();
    xvelocity -= yvelocity/curvature;
    yvelocity += xvelocity/curvature;
    curvature = (5*Math.random()+15);
    color = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
    diameter += (int)(40*Math.random())-20;
  }
}