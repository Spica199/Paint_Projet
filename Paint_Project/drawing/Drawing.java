package drawing;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Drawing 
    extends JPanel implements Iterable<Shape> {

	private static final long serialVersionUID = 1L;
	int nbForms = 0;
	ArrayList<Shape> shapes;
	ArrayList<Shape> gatheredShapes;
	Shape selectedShape = null;
	private Vector<Observer> observers = new Vector<>();

	
	
	public Drawing(){
		super();
		shapes = new ArrayList<Shape>();
		gatheredShapes = new ArrayList<Shape>();
              
	}
	
	public void addObserver(Observer obs){
		observers.add(obs);
	}
	
	public void removeObserver(Observer obs){
		observers.remove(obs);
	}
	
	private void notifyObservers(){
		for (Observer obs : observers) {
			obs.update(nbForms);
		}
	}
	
	public Iterator<Shape> iterator(){
		return shapes.iterator();
	}
	
	public void addShape(Shape s){
		shapes.add(s);
		this.repaint();
		nbForms++;
		notifyObservers();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Shape s : shapes){
			s.paint(g);
		}
	}
	
	public void clear() {
		shapes.clear();
		gatheredShapes.clear();
		this.repaint();
		nbForms = 0;
                notifyObservers();
	}
	
	//Groupe la shape selectionnee dans la liste.
	
	public void gatherShape() {
		if(selectedShape != null && !(gatheredShapes.contains(selectedShape))) {
			gatheredShapes.add(selectedShape);
			notifyObservers();
		}
	}
	
	//Degroupe la shape selectionnee dans la liste.
	
	public void scatterShape() {
		if(selectedShape != null && !(gatheredShapes.contains(selectedShape))) {
			gatheredShapes.remove(selectedShape);
			notifyObservers();
		}
	}
	
	public void duplicateShape() {
		if(selectedShape != null) {
                        
			Shape s = selectedShape.clone();
                        this.addShape(s);
                        notifyObservers();
		}
	}
      
   
        
}
