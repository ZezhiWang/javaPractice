/*
 Ball -- represents one ball in the Ball World application
 
 author: John Donaldson
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Ball implements ActionListener
{
   // the Ball's properties

   private int canvasWidth, canvasHeight;
   private int xpos,ypos;
   private double mass;
   private double radius;
   protected double xvelocity,yvelocity;
   protected int diameter;
   protected Color color;

   // the Ball constructor
   // parameters are the width and height of the canvas
   public Ball(int width, int height){
      canvasWidth = width;
      canvasHeight = height;
      
      // the diameter is a random int between 50 and 100 
      diameter = (int)(50*Math.random())+50;
      
      // the velocity components 
      xvelocity = ((int)(4*Math.random())+3)*((int)(Math.random()*2))*2-1;
      yvelocity = ((int)(4*Math.random())+3)*((int)(Math.random()*2))*2-1;
      
      // the initial (x,y) position of the ball
      xpos=(int)(canvasWidth*Math.random());
      ypos=(int)(canvasHeight*Math.random());
      
      // pick a random color
      color=new Color((float)Math.random(),(float)Math.random(),(float)Math.random());

      radius = this.diameter/2;
      
      mass = radius*radius;
   }

   // how the ball moves
   public void move(){
      int xmax = canvasWidth;
      int ymax = canvasHeight;
      
      // update the x position
      xpos+=xvelocity;
      // if past the right boundary, bounce back to the left
      if(xpos+diameter > xmax)
      {
         xpos = xpos - 2*(xpos+diameter-xmax);
         xvelocity = -xvelocity;
      }
      // if past the left boundary, bounce back to the right
      if(xpos < 0)
      {
         xpos = -xpos;
         xvelocity = -xvelocity;
      }
      
      // update the y position      
      ypos+=yvelocity;
      // if past the bottom boundary, bounce back up
      if(ypos+diameter > ymax)
      {
         ypos = ypos - 2*(ypos+diameter-ymax);
         yvelocity = -yvelocity;
      }
      // if past the upper boundary, bounce back down
      if(ypos < 0)
      {
         ypos = -ypos;
         yvelocity = -yvelocity;
      }
   }

   // how to draw this ball
   public void draw(Graphics g)
   {
      g.setColor(color);
      g.fillOval(xpos,ypos,diameter,diameter);
   }

   // how the ball responds to a timer tick
   public void actionPerformed(ActionEvent e)
   {
      move();
   }
   
   public double Distance(double x1, double y1, double x2, double y2)
   {
      double dx = x2-x1;
      double dy = y2-y1;
      return Math.sqrt(dx*dx + dy*dy);
   }
   
   public boolean intersect(Ball other)
   {
     double distance = Distance(this.xpos+this.radius, this.ypos+this.radius, other.xpos+other.radius, other.ypos+other.radius);
     double temp = this.radius + other.radius - distance;
     return (temp >= 0);
   }

   public void collide(Ball other)
   {
      double dist = Distance(this.xpos,this.ypos,other.xpos,other.ypos);
      double forcethis = (2*other.mass)/(this.mass+other.mass)*((other.xpos-this.xpos)*(other.xvelocity-this.xvelocity)+(other.ypos-this.ypos)*(other.yvelocity-this.yvelocity))/dist;
      double forceother = (2*this.mass)/(other.mass+this.mass)*((this.xpos-other.xpos)*(this.xvelocity-other.xvelocity)+(this.ypos-other.ypos)*(this.yvelocity-other.yvelocity))/dist;
      
      if((other.xpos-this.xpos)*(this.xvelocity-other.xvelocity) > 0)
      {
         this.xvelocity += forcethis * (other.xpos-this.xpos)/dist;
         other.xvelocity += forceother * (this.xpos-other.xpos)/dist;
      }
      if((other.ypos-this.ypos)*(this.yvelocity-other.yvelocity) > 0)
      {
         this.yvelocity += forcethis * (other.ypos-this.ypos)/dist;
         other.yvelocity += forceother * (this.ypos-other.ypos)/dist;
      }
   }
}