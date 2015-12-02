package drawing;

import java.awt.Color;

public class RectangleButtonListener extends ShapeButtonListener {

	public RectangleButtonListener(Drawing drawing){
		super(drawing);
	}
	
	@Override
	protected Shape createShape() {
		double width = destination.getX()-origin.getX();
		double height = destination.getY()-origin.getY();
		Rectangle r = new Rectangle(origin, (int)width, (int)height, Color.MAGENTA);
		return r;
	}

}
