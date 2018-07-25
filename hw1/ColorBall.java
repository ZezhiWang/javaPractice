import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorBall extends Ball implements ActionListener
{
  
  public ColorBall(int width, int height)
  {
    super(width,height);
  }
  
  public void move()
  {
    super.move();
    color=new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
  }
}