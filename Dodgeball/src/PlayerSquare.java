import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * The player square which the player can control via mouse movement 
 * the objective is to attempt to touch a flashing ball
 * @author 322211632
 *
 */

public class PlayerSquare extends MovingObject {
	/**
	 * The size of the square
	 */
	private int size;
	
	/**
	 * States true or false depending on if the player square has touched a circle
	 */
	private boolean touched;
	
	/**
	 * Counts how many times a player square has touched a circle
	 */
	private int count;
	
	/**
	 * Constructor inherited from super class Moving Object
	 * @param x
	 * @param y
	 * @param left
	 * @param right
	 * @param top
	 * @param bottom
	 */
	public PlayerSquare(double x, double y, int left, int right, int top,int bottom) {
		super(x, y, left + 10, right - 10, top + 10, bottom - 10);
		size = 29;
		touched = false;
		count=0;
	}	
	
	@Override
	public void animateOneStep(){		
	}
	
	
	public boolean isTouched(){
		touched=true;
		return touched;
	}
	
	public boolean isNotTouched(){
		touched=false;
		return touched;
	}

	/**
	 * Draws the player square
	 * @param g
	 */
	@Override
	public void draw(Graphics g) {
		int drawX = (int) getX() - size;
		int drawY = (int) getY() - size;		
		
		g.setColor(Color.blue);
		g.fillRect(drawX, drawY, size , size);
		g.setColor(Color.black);
		g.drawString("count= "+count, 245, 150);
		if (touched){
			count++;
			g.setColor(Color.black);
			g.drawString("count="+count, 245, 150);
		    g.setColor(Color.white);
			g.fillRect(drawX+size/2, drawY+size/2, size/2, size/2);		
		}
		touched=false;
	}
	
	
	
}