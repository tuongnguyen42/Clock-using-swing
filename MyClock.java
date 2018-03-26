import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MyClock extends JPanel implements ActionListener{
	private ClockFace face;
	private ClockHands hands;
	
	MyClock(int Radius){
		face = new ClockFace(0,0,Radius);
		hands = new ClockHands(Radius);
		this.setPreferredSize(new Dimension(Radius, Radius));
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		face.draw(g2);
		hands.draw(g2);
		
        Timer time = new Timer(1000, this);
        time.start();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
}

/////zzzzz
