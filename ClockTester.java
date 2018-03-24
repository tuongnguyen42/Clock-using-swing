import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
   This program implements an animation that moves
   a car shape.
*/
public class ClockTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      JPanel glass = (JPanel) frame.getGlassPane();

      ClockFace icon = new ClockFace(0, 0, CLOCK_RADIUS);
      ClockHands hands = new ClockHands(CLOCK_RADIUS);
      
      frame.setLayout(new BorderLayout());
      frame.add(icon, BorderLayout.CENTER);
      frame.add(hands, BorderLayout.CENTER);

     

      
      JPanel topNav = new JPanel(new FlowLayout());
      topNav.add(new JButton("clock"));
      topNav.add(new JButton("stopwatch"));
      frame.add(topNav, BorderLayout.NORTH);
      icon.repaint();

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      
   }

   private static final int CLOCK_RADIUS = 500;
}
