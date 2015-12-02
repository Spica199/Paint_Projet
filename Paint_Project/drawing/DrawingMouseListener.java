package drawing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Point;

public class DrawingMouseListener 
implements MouseMotionListener, MouseListener {

	Drawing drawing;
	Shape selectedShape = null;
	
	public DrawingMouseListener(Drawing d){
		drawing = d;
	}
	
	
	public void mouseDragged(MouseEvent e) {
		if(selectedShape != null){
			if(e.getModifiers() == MouseEvent.BUTTON1_MASK) {
				selectedShape.setOrigin(e.getPoint());
				drawing.repaint();
			} else {
				if(e.getModifiers() == MouseEvent.BUTTON3_MASK) {
					for(Shape s : drawing.gatheredShapes){
                                            if(s.isOn(e.getPoint())){
						for(Shape sh : drawing.gatheredShapes){
                                                    Point p = new Point(e.getPoint());
							sh.setOrigin(p);
							drawing.repaint();
							}
						}
					}
				}
			}
		}
	}
	
	public void mousePressed(MouseEvent e) {
		for(Shape s : drawing){
			if(s.isOn(e.getPoint())){
				drawing.selectedShape = s;
				selectedShape = s;
				break;
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		selectedShape = null;
	}
	public void mouseMoved(MouseEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
}
