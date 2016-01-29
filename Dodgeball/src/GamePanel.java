
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is the beginning of a simple game. You should expand it into a dodgeball
 * game, where the user controls an object with the mouse or keyboard, and tries
 * to avoid the balls flying around the screen. If they get hit, it's game over.
 * If they survive for 20 seconds (or some other fixed time), they go on to the
 * next level. <br>
 * <br>
 * Should be run at around 500x300 pixels.<br>
 * <br>
 * @version Nov. 2015
 * 
 * @author Christina Kemp adapted from Sam Scott
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, MouseMotionListener  {


	int width = 500;
	int height = 300;
	
	int squareX =1;
	int squareY=1 ; 
	
	/**
	 * The number of balls on the screen.
	 */
	final int numBalls = 6;
	/**
	 * The pause between repainting (should be set for about 30 frames per
	 * second).
	 */
	final int pauseDuration = 50;
	/**
	 * An array of balls.
	 */
	FlashingBall[] ball = new FlashingBall[numBalls];
	PlayerSquare player;
	
	/**
	 * The timer will count down to 0
	 */
	 int timer=500;

	/** main program (entry point) */
	public static void main(String[] args) {

		// Set up main window (using Swing's Jframe)
		JFrame frame = new JFrame("Dodgeball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 300));
		frame.setAutoRequestFocus(false);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		c.add(new GamePanel());
		frame.pack();

	}

	public GamePanel(){
		// Start the ball bouncing (in its own thread)
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.WHITE);

		for (int i = 0; i < numBalls; i++) {
			ball[i] = new FlashingBall(50, 50, 0, width, 0, height);
			ball[i].setXSpeed(Math.random() * 20-18);
			ball[i].setYSpeed(Math.random() * 20-18);
			ball[i].setColor(new Color((int) (Math.random() * 256), (int) (Math
					.random() * 256), (int) (Math.random() * 256)));
		}

		player = new PlayerSquare(15,15,0,width,0,height);
		addMouseMotionListener (this);
		
		Thread gameThread = new Thread(this);
		gameThread.start();

	}

	/**
	 * Repaints the frame periodically.
	 */
	public void run() {
		while (timer>0) {
			repaint();
			timer--;	
			try {
				Thread.sleep(pauseDuration);				
			} catch (InterruptedException e) {
			}
		}
	}

	/**
	 * Clears the screen and paints the balls.
	 * @param touched 
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Timer: "+timer,12,12);
		player.setX(squareX);
		player.setY(squareY);
		player.draw(g);
		if(timer==0){
			g.drawString("GAME OVER!", 10, 25);
			squareX=225;
			squareY=160;
			removeMouseMotionListener(this);
		}
		for (int i = 0; i < numBalls; i++) {
			ball[i].draw(g);
		}
	}


	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		squareX=e.getX();
		squareY=e.getY();
		for (int i = 0;i<numBalls;i++){
			if (squareX-29<=ball[i].getX()&&squareX+29>=ball[i].getX()&&squareY-29<=ball[i].getY()&&squareY>=ball[i].getY()){
				player.isTouched();
			}

		}

	}

}
