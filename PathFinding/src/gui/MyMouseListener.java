package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Queue;

import Components.Coordinates;
import Components.CustomComponent;

class MyMouseListener extends MouseAdapter {
	int xPos;
	int yPos;
	GUIPathFinding gui;

    
	public MyMouseListener(GUIPathFinding gui) {
		this.gui = gui;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	   
	   super.mousePressed(e);
	   
	   CustomComponent source = (CustomComponent)e.getSource();
	   
       xPos = source.getGridX();
       yPos = source.getGridY();
       
	   if(!gui.getGrid().isObstacle(xPos, yPos)) {
		   ScheduledHover.erasePreviousState();
	       Queue<Coordinates> queue =  MouseEventQueue.getMouseQueue();
	       System.out.println("added to mouse queue");
	       queue.add(new Coordinates(xPos, yPos));
	   }
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseEntered(e);
       CustomComponent source = (CustomComponent)e.getSource();
       xPos = source.getGridX();
       yPos = source.getGridY();
       gui.renderBlock(xPos, yPos, "hover", null, "");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseReleased(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
	       CustomComponent source = (CustomComponent)e.getSource();
	       xPos = source.getGridX();
	       yPos = source.getGridY();
	       System.out.println("");
	       gui.renderBlock(xPos, yPos, source.getOriginalColor(),"");
	}
	
	public Coordinates getCoordAndWipe(){
		Coordinates coord  = new Coordinates(xPos,yPos);
		xPos = -1;
		yPos = -1;
		return coord;
	}
}