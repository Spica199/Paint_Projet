package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GroupButtonListener 
    implements ActionListener {

	Drawing drawing;
	
	public GroupButtonListener(Drawing drawing){
		this.drawing=drawing;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		drawing.gatherShape();
	}

}
