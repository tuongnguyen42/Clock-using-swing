import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;



public class StopWatchDial extends ClockFace{
	
	private ClockHand hand;
	private int handLength;

	private int x,y;
	private int width;
	private int r;
	
	

	
	public StopWatchDial(int x, int y, int width) {
		super(x,y,width);
		this.r = width/2;
		this.handLength = width/2;
		this.x = x;
	    this.y = y;
	    this.width = width;
	    hand = new ClockHand(width/2,width/2, width/2, handLength, 2, Color.RED);
	    this.setOpaque(false);
	    this.setPreferredSize(new Dimension(width, width));
	     

	     
	}
	
	
	
	




	

}
