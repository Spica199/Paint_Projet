package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle 
    extends Shape {

	int width;
	int height;
	Color color;
	
	public Rectangle(Point origin, int width, int height, Color color){
		this.origin = origin;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public boolean isOn(Point p) {
		return(p.x > origin.x && p.x < origin.x+width && p.y > origin.y && p.y < origin.y+height);
	}

	public void paint(Graphics g) {
		int x1, y1, x2, y2;
		g.setColor(color);
		if(width > 0 && height > 0) {
			x1 = origin.x;
			y1 = origin.y;
		} else if(width > 0 && height < 0) {
			x1 = origin.x;
			y1 = origin.y + height;
		} else if(width < 0 && height > 0) {
			x1 = origin.x + width;
			y1 = origin.y;	
		} else {
			x1 = origin.x + width;
			y1 = origin.y + height;
		}
		x2 = Math.abs(width);
		y2 = Math.abs(height);
		g.fillRect(x1, y1, x2, y2);
		g.setColor(Color.BLACK);
		g.drawRect(x1, y1, x2, y2);
	}
}
