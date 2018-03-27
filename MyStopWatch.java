import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;


public class MyStopWatch extends JPanel implements ActionListener{
	StopWatchDial outter, inner;
	Timer timer;
	private int xEndInner;
	private int yEndInner;
	private int xEndOutter;
	private int yEndOutter;
	private long start;
	private long ellapsedSec = 0;
	private long ellapsedMin = 0;
	
	ClockHand innerHand;
	ClockHand outterHand;
	int innerLength, outterLength;
	
	
	
	int x, y, width, radius;
	
	MyStopWatch(int x, int y,int width){
		setLayout(new BorderLayout());
		this.width = width;
		this.radius = width/2;
		this.x = x;
		this.y = y;
		this.outterLength = width/2 -30;
		this.innerLength = width/4 ;
		
	
		this.setPreferredSize(new Dimension(width,width +50));
		this.setOpaque(false);
	    outterHand = new ClockHand(width/2,width/2, width/2, outterLength, 2, Color.RED);
		outter = new StopWatchDial(x,y,width);
		inner = new StopWatchDial(width/4,width/4, width/2);
	    innerHand = new ClockHand(width/2,width/2, width/2, innerLength, 2, Color.RED);
		
		
		
		

		timer = new Timer(1000,this);
		
		 // set up buttons

         JButton b = new JButton("Start");
        JPanel box = new JPanel();
        box.setOpaque(false);
        box.add(b);

        add(box, BorderLayout.SOUTH);

        
        b.addActionListener(e -> {
        	if (b.getActionCommand().equals("Start")){
            	start = System.currentTimeMillis();
            	ellapsedSec = 0;
            	ellapsedMin = 0;
            	timer.start();
            	b.setText("Stop");
            	b.setActionCommand("Stop");
        	}
        	
        	else if (b.getActionCommand().equals("Stop")){
        		timer.stop();
        		b.setText("Start");
        		b.setActionCommand("Start");
        	}
        			
        });

		
	}

	
	
	private void ellapsedTime () {
		long current = System.currentTimeMillis();
		this.ellapsedSec = (current - start)/1000;
		if(ellapsedSec%60 == 0 && ellapsedSec > 0)
			this.ellapsedMin++;
	}
	

	private Point coor(long time, int handLen) {
		 double t = 2 * Math.PI * (time-15) / 60;
		 int x = (int)(width / 2 + handLen * Math.cos(t));
		 int y = (int)(width / 2 + handLen * Math.sin(t));
		return new Point(x,y);
	}
	
	private void calcCoor() {
		this.xEndOutter = coor(ellapsedSec,outterLength).x;
		this.yEndOutter = coor(ellapsedSec,outterLength).y;
		this.xEndInner = coor(ellapsedMin,innerLength).x;
		this.yEndInner = coor(ellapsedMin,innerLength).y;
		

	}

	
	public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);

        outter.drawFace(g2);
        outterHand.draw(g2);
        inner.drawFace(g2);
        innerHand.draw(g2);


        calcCoor();

        innerHand.translate(xEndInner, yEndInner);
        outterHand.translate(xEndOutter, yEndOutter);

        

        
        


    }


	@Override
	public void actionPerformed(ActionEvent e) {
        ellapsedTime();
		repaint();

		
	}
	

	
 
	
	
	
	
}

 
