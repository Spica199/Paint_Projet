package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DuplicateButtonListener 
    implements ActionListener {

	Drawing drawing;
	
	public DuplicateButtonListener(Drawing drawing){
		this.drawing=drawing;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		drawing.duplicateShape();
	}

}
