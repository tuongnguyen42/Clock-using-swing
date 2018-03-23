import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.JPanel;

public class ClockHands extends JPanel implements MoveableShape {
	int xSec, ySec, xMin, yMin, xHr, yHr;
	private int clockRadius;
	private int secLength, minLength, hrLength;
	int currentSec, currentMin, currentHr;
	
	
	ClockHands(int radius){
		this.clockRadius = radius;
		this.secLength = radius/2 - 50;
		this.minLength = radius/2 -75;
		this.hrLength = radius/2 -100;
	    this.setOpaque(true);
	    this.setPreferredSize(new Dimension(radius, radius));

	}
	
	private Point coor(int time, int handLen) {
		 double t = 2 * Math.PI * (time-15) / 60;
		 int x = (int)(clockRadius / 2 + handLen * Math.cos(t));
		 int y = (int)(clockRadius / 2 + handLen * Math.sin(t));
		return new Point(x,y);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		draw(g2);
	}
	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		
		

		for(;;) {
			this.currentSec = Calendar.getInstance().get(Calendar.SECOND);
			this.currentMin = Calendar.getInstance().get(Calendar.MINUTE);
			this.currentHr = Calendar.getInstance().get(Calendar.HOUR);
			translate();
			g2.setColor(Color.GREEN);
			g2.drawLine(clockRadius/2, clockRadius/2, xSec, ySec);
			g2.drawLine(clockRadius/2, clockRadius/2, xMin, yMin);
			g2.drawLine(clockRadius/2, clockRadius/2, xHr, yHr);
			repaint();
			

		}

	
		
	}

	@Override
	public void translate() {
		// TODO Auto-generated method stub
		this.xSec = coor(currentSec,secLength).x;
		this.ySec = coor(currentSec,secLength).y;
		this.xMin = coor(currentMin,minLength).x;
		this.yMin = coor(currentMin,minLength).y;
		this.xHr = coor(currentHr,hrLength).x;
		this.yHr = coor(currentHr,hrLength).y;
		
	}
	

}
