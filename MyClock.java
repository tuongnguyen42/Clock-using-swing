import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MyClock extends JPanel implements ActionListener{
	private ClockFace face;
	private ClockHand secHand, minHand, hourHand;
	
	int xSec, ySec, xMin, yMin, xHr, yHr;
	private int width;
	private int secLength, minLength, hrLength;
	int currentSec, currentMin, currentHr;
	int x,y;
	
	
	MyClock(int x, int y,int width){
		
		
		this.x = x;
		this.y = y;
		this.width = width;
		calcHandLen();
		face = new ClockFace(0,0,width);
		this.setPreferredSize(new Dimension(width, width));
		secHand = new ClockHand(width/2,width/2,0,0,1, Color.RED);
		minHand = new ClockHand(width/2,width/2,0,0,2, Color.BLACK);
		hourHand = new ClockHand(width/2,width/2,0,0,3, Color.BLACK);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		face.draw(g2);

		this.currentSec = Calendar.getInstance().get(Calendar.SECOND);
		this.currentMin = Calendar.getInstance().get(Calendar.MINUTE);
		this.currentHr = Calendar.getInstance().get(Calendar.HOUR);
		calcCoor();
		

		secHand.draw(g2);
		minHand.draw(g2);
		hourHand.draw(g2);
		secHand.translate(xSec, ySec);
		minHand.translate(xMin, yMin);
		hourHand.translate(xHr, yHr);
	
        Timer time = new Timer(1000, this);
        time.start();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
	
	private int getRelativeHr(int min){
		return min/12;
		
	}
	
	private Point coor(int time, int handLen) {
		 double t = 2 * Math.PI * (time-15) / 60;
		 int x = (int)(width / 2 + handLen * Math.cos(t));
		 int y = (int)(width / 2 + handLen * Math.sin(t));
		return new Point(x,y);
	}
	
	private void calcHandLen() {
		this.secLength = width/2 - 30;
		this.minLength = width/2 -75;
		this.hrLength = width/2 -95;
	}
	
	private void calcCoor() {
		this.xSec = coor(currentSec,secLength).x;
		this.ySec = coor(currentSec,secLength).y;
		this.xMin = coor(currentMin,minLength).x;
		this.yMin = coor(currentMin,minLength).y;
		this.xHr = coor(currentHr*5 + getRelativeHr(currentMin),hrLength).x;
		this.yHr = coor(currentHr*5 + getRelativeHr(currentMin),+hrLength).y;
	}

	
}


