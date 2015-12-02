package drawing;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class ShapeButtonListener implements ActionListener, MouseListener {

	Drawing drawing;
	Point origin;
	Point destination;
	
	public ShapeButtonListener(Drawing drawing){
		this.drawing = drawing;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		drawing.addMouseListener(this);
	}
	
	
	public void mouseReleased(MouseEvent arg0) {
		destination = arg0.getPoint();
		Shape s = createShape();
		drawing.addShape(s);
		drawing.removeMouseListener(this);
	}
	
	
	public void mousePressed(MouseEvent arg0) {
		origin = arg0.getPoint();
	}
	

	protected  abstract Shape createShape();

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}


}
