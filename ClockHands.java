import java.awt.BasicStroke;
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
		this.secLength = radius/2 - 30;
		this.minLength = radius/2 -50;
		this.hrLength = radius/2 -85;
	    this.setOpaque(false);
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
		g2.setColor(Color.BLACK);
		draw(g2);
		
	}
	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		
		


			this.currentSec = Calendar.getInstance().get(Calendar.SECOND);
			this.currentMin = Calendar.getInstance().get(Calendar.MINUTE);
			this.currentHr = Calendar.getInstance().get(Calendar.HOUR);
			translate();
			g2.setColor(Color.RED);
			g2.setStroke(new BasicStroke(1));
			g2.drawLine(clockRadius/2, clockRadius/2, xSec, ySec);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(5));
			g2.drawLine(clockRadius/2, clockRadius/2, xMin, yMin);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(5));
			g2.drawLine(clockRadius/2, clockRadius/2, xHr, yHr);
			repaint();



	
		
	}
	
	public void drawSecHand(Graphics2D g2) {
		this.currentSec = Calendar.getInstance().get(Calendar.SECOND);
		translate();
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(1));
		g2.drawLine(clockRadius/2, clockRadius/2, xSec, ySec);
	}
	
	public void drawMinHand(Graphics2D g2) {
		translate();
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(clockRadius/2, clockRadius/2, xMin, yMin);
		repaint();
	}
	

	public void drawHrHand(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(clockRadius/2, clockRadius/2, xHr, yHr);
		repaint();
	}
	
	

	@Override
	public void translate() {
		// TODO Auto-generated method stub
		this.xSec = coor(currentSec,secLength).x;
		this.ySec = coor(currentSec,secLength).y;
		this.xMin = coor(currentMin,minLength).x;
		this.yMin = coor(currentMin,minLength).y;
		this.xHr = coor(currentHr*5 + getRelativeHr(currentMin),hrLength).x;
		this.yHr = coor(currentHr*5 + getRelativeHr(currentMin),+hrLength).y;
		
	}
	
	private int getRelativeHr(int min){
		return min/12;
		
	}
	

}
