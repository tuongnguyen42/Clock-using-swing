import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
*/
public class ClockTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      JPanel panel = new JPanel();
      MyClock clock = new MyClock(0,0,CLOCK_RADIUS);
      MyStopWatch stopwatch  = new MyStopWatch(0,0,CLOCK_RADIUS-50);
      
      

      JButton b = new JButton("Stopwatch");
      panel.add(clock);
      
      frame.setLayout(new BorderLayout());


      frame.add(panel, BorderLayout.CENTER);
      frame.add(b, BorderLayout.NORTH);
     
      b.addActionListener(e ->{
    	  if (b.getActionCommand().equals("Stopwatch")) {
    		  b.setText("Clock");
    		  b.setActionCommand("Clock");
    		  panel.remove(clock);
    		  panel.add(stopwatch);
    		  frame.repaint();
    		  
 
    	  } else if(b.getActionCommand().equals("Clock")){
    		  b.setText("Stopwatch");
    		  b.setActionCommand("Stopwatch");
    		  panel.remove(stopwatch);
    		  panel.add(clock);
    		  frame.repaint();


    	  }
      });

      

 

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      
   }

   private static final int CLOCK_RADIUS = 500;


}
