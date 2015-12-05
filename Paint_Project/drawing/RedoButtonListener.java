package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RedoButtonListener 
implements ActionListener {

	Drawing drawing;
	
	public RedoButtonListener(Drawing drawing){
		this.drawing=drawing;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		drawing.redoWork();
	}

}