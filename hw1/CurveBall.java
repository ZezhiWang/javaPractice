import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CurveBall extends Ball implements ActionListener
{
  protected double curvature = (5*Math.random()+15);
  
  public CurveBall(int width, int height)
  {
    super(width,height);
  }
  public void move()
  {
    super.move();
    xvelocity -= yvelocity/curvature;
    yvelocity += xvelocity/curvature;
    curvature = (5*Math.random()+15);
  }
}