package drawing;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape implements Cloneable {
	
	protected Point origin;
	
	public void setOrigin(Point p)
	{
		origin = p;
	}
	
	public Point getOrigin() {
		return origin;
	}
	
	@Override
	public Shape clone() {
		Object o = null;
		
		try {
			o = super.clone();
		} catch(CloneNotSupportedException cnse) {
			cnse.printStackTrace(System.err);
		}
		return (Shape) o;
	}
	
	
	public abstract void paint(Graphics g);
	
	
	public abstract boolean isOn(Point p);

    int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
