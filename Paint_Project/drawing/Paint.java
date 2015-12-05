package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

public class Paint 
    implements Observer {

	private JFrame frame;
	private JButton clearButton;
	private JButton circleButton;
	private JButton rectangleButton;
	private JButton gatterButton;
	private JButton scatterButton;
	private JButton duplicateButton;
        
        private JButton undoButton;
	private JButton redoButton;

	private JPanel statusPanel;
	private JPanel buttonsPanel;
	private JPanel bottomPanel;
	private JPanel mainPanel;
        
        private JPanel createPanel;
	private JPanel interactPanel;
        
	private JLabel status;
	private Drawing drawing;
	private final int WIDTH = 800;
	
	public void run(){
		frame = new JFrame("Paint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel(new BorderLayout());
		
		drawing = new Drawing();
		drawing.addObserver(this);
		drawing.setBackground(Color.WHITE);
		clearButton = new JButton("Clear");
		circleButton = new JButton("Circle");
		rectangleButton = new JButton("Rectangle");
                duplicateButton = new JButton("Duplicate");
		gatterButton = new JButton("Gather");
		scatterButton = new JButton("Scatter");
                undoButton = new JButton(" <== ");
		redoButton = new JButton(" ==> ");
	
		bottomPanel = new JPanel(new BorderLayout());
		
		statusPanel = new JPanel();
		status = new JLabel("Status Bar",JLabel.CENTER);
                status.setFont(new Font("ROMAN", Font.ROMAN_BASELINE, 13));
		statusPanel.add(status);
		status.setPreferredSize(new Dimension(WIDTH, 30));
		status.setText("Number of Forms: <<\"0\">>");
                statusPanel.setBorder(new EtchedBorder (EtchedBorder.LOWERED));
		
                
		buttonsPanel = new JPanel();
		buttonsPanel.add(clearButton);
		buttonsPanel.add(circleButton);
		buttonsPanel.add(rectangleButton);
		buttonsPanel.add(gatterButton);
		buttonsPanel.add(scatterButton);
		buttonsPanel.add(duplicateButton);
                buttonsPanel.add(undoButton);
		buttonsPanel.add(redoButton);
		
		bottomPanel.add(statusPanel, BorderLayout.NORTH);
		bottomPanel.add(buttonsPanel, BorderLayout.SOUTH);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		mainPanel.add(drawing, BorderLayout.CENTER);
		
		clearButton.addActionListener(new ClearButtonListener(drawing));
		circleButton.addActionListener(new CircleButtonListener(drawing));
		rectangleButton.addActionListener(new RectangleButtonListener(drawing));
		gatterButton.addActionListener(new GroupButtonListener(drawing));
		scatterButton.addActionListener(new SeparateButtonListener(drawing));
		duplicateButton.addActionListener(new DuplicateButtonListener(drawing));
                
                undoButton.addActionListener(new UndoButtonListener(drawing));
		redoButton.addActionListener(new RedoButtonListener(drawing));
		
		DrawingMouseListener l = new DrawingMouseListener(drawing);
		drawing.addMouseListener(l);
		drawing.addMouseMotionListener(l);

		frame.getContentPane().add(mainPanel);
		frame.setSize(WIDTH,580);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		Paint app = new Paint();
		app.run();
	}
	
	@Override
	public void update(int val) {
		status.setText("Number of Forms: <<"+ Integer.toString(val)+">>");
	}
}
