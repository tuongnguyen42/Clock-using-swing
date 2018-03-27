import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;




public class ClockHand extends JPanel implements MoveableShape{
	int xStart, yStart, xEnd, yEnd, widthStroke;
	Color c;
	ClockHand(int xs, int ys, int xe, int ye, int strokeWidth, Color c){
		this.xStart = xs;
		this.yStart = ys;
		this.xEnd = xe;
		this.yEnd = ye;
		this.widthStroke = strokeWidth;
		this.c = c;
	}

	@Override
    public void draw(Graphics2D g2) {
        g2.setStroke(new BasicStroke(widthStroke));
        g2.setColor(c);
        g2.drawLine(xStart, yStart,xEnd,yEnd);
    }
	@Override
    public void translate(int dx, int dy) {
        xEnd = dx;
        yEnd = dy;
    }

	@Override
	public void translate() {
		// TODO Auto-generated method stub
		
	}
	
}
