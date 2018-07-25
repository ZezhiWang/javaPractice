/*
  Ballworld
 
  A simple animation program which displays a set of bouncing balls.
  author: John Donaldson
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Ballworld extends JFrame // appears in a GUI window
   implements ActionListener { // responds to Timer events

   // program variables
   private ArrayList<Ball> ballList = new ArrayList<Ball>();
   private javax.swing.Timer timer= new javax.swing.Timer(50,this);
   private JPanel drawingPanel;
   
   public void handleCollisions(ArrayList<Ball> ballList){
      ArrayList<Ball> temp = new ArrayList<Ball>();
      for (Ball a : ballList){  
         for (Ball b : ballList){  
            if (a.intersect(b)){
              if(temp.contains(a) && temp.contains(b)){
                continue;
              }
              else{
                a.collide(b);
                temp.add(a);
                temp.add(b);
              }
            }
         }
      }
   }
   // respond to timer events
   public void actionPerformed(ActionEvent e){
     handleCollisions(ballList);
     drawingPanel.repaint();
   }



   // constructor
   // sets up the GUI frame and then exits
   Ballworld() 
   {
      // Set the frame attributes
      setSize(1000,700);
      setLocation(50,50);
      setTitle("Ballworld");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
      
      // Get a reference to the frame's content pane
      Container contentPane = getContentPane();

      // Set up the GUI components within the frame
      JPanel buttonPanel = new JPanel(); // a panel for buttons at the bottom
      contentPane.add("South",buttonPanel); 
      
      // three buttons in the button panel
      JButton addButton1 = new JButton("Add Ball");
      buttonPanel.add(addButton1);

      JButton addButton2 = new JButton("Add CurveBall");
      buttonPanel.add(addButton2);
      
      JButton addButton3 = new JButton("Add ColorBall");
      buttonPanel.add(addButton3);
      
      JButton addButton4 = new JButton("Add CombinedBall");
      buttonPanel.add(addButton4);
            
      JButton clearButton = new JButton("Delete all Balls");
      buttonPanel.add(clearButton);
      
      JButton closeButton = new JButton("Close Window");
      buttonPanel.add(closeButton);

      // the drawing panel
      drawingPanel = new JPanel(){
         // this method describes how to draw the panel
         public void paintComponent(Graphics g){
            super.paintComponent(g); // redraw the panel         
            for(Ball b : ballList){ // redraw the balls
               b.draw(g);
            }
         }
      };
      drawingPanel.setBackground(Color.lightGray);
      contentPane.add("Center",drawingPanel);
      
      // Set up the action listeners for the buttons
      addButton1.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            // instantiate a Ball
            Ball ball = new Ball(drawingPanel.getWidth(),drawingPanel.getHeight());
            // the ball responds to timer ticks
            timer.addActionListener(ball);
            // add it to the Ball list
            ballList.add(ball);
         }

      });

      addButton2.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            // instantiate a Ball
            CurveBall curveball = new CurveBall(drawingPanel.getWidth(),drawingPanel.getHeight());
            // the ball responds to timer ticks
            timer.addActionListener(curveball);
            // add it to the Ball list
            ballList.add(curveball);
         }
      });
      
      addButton3.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            // instantiate a Ball
            ColorBall colorball = new ColorBall(drawingPanel.getWidth(),drawingPanel.getHeight());
            // the ball responds to timer ticks
            timer.addActionListener(colorball);
            // add it to the Ball list
            ballList.add(colorball);
         }
      });
      
      addButton4.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            // instantiate a Ball
            CombinedBall combinedball = new CombinedBall(drawingPanel.getWidth(),drawingPanel.getHeight());
            // the ball responds to timer ticks
            timer.addActionListener(combinedball);
            // add it to the Ball list
            ballList.add(combinedball);
         }
      });
      
      clearButton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            ballList.clear();
         }
      });
      
      closeButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            System.exit(0);
         }
      });


      
      setVisible(true); // make the frame visible on the screen
      timer.start();
   }

   // the main method
   public static void main(String args[])
   {
      // instantiate the frame
      new Ballworld();
   }
   
}

