package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UndoButtonListener implements ActionListener {

	Drawing drawing;
	
	public UndoButtonListener(Drawing drawing){
		this.drawing=drawing;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		drawing.cancelWork();
	}

}