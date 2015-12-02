package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeparateButtonListener 
    implements ActionListener {

	Drawing drawing;
	
	public SeparateButtonListener(Drawing drawing){
		this.drawing=drawing;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		drawing.scatterShape();
	}

}
