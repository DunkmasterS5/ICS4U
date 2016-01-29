import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class demonstrates how to use the MouseListener interface in an Applet
 * Novembeer 28, 2007.
 * @author Sam Scott
 **/
public class MouseListenerDemo extends Applet implements MouseListener
{
    /**
     * counts the number of clicks so far
     **/
    int mouseClicks = 0;
    /**
     * true if the mouse button is down
     **/
    boolean mouseButtonDown = false;
    /**
     * true when mouse enters applet window
     **/
    boolean mouseInWindow = false;
    /**
     * the position at which the last mouse down event happened
     **/
    int x = -1, y = -1;

    /**
     * Activate the mouse listener
     **/
    public void init ()
    {
	addMouseListener (this);
    }


    /**
     * Display basic information from mouse listeners
     * @param g The graphics context
     **/
    public void paint (Graphics g)
    {
	g.drawString ("Clicks: " + mouseClicks, 50, 30);
	if (mouseButtonDown)
	    g.drawString ("Down", 50, 50);
	else
	    g.drawString ("Up", 50, 50);
	if (mouseInWindow)
	    g.drawString ("In", 50, 70);
	else
	    g.drawString ("Out", 50, 70);
	g.drawString ("Last Down Position: (" + x + "," + y + ")", 50, 90);
    }


    // THE METHODS BELOW ARE REQUIRED FOR THE MouseListener INTERFACE
    // You must always have these methods in any class that implements
    // MouseListener

    /**
     * called when mouse clicked and released
     * @param e The mouse event
     **/
    public void mouseClicked (MouseEvent e)
    {
	mouseClicks++;
	repaint ();
    }


    /**
     * called when mouse enters the applet screen
     * @param e The mouse event
     **/
    public void mouseEntered (MouseEvent e)
    {
	mouseInWindow = true;
	repaint ();
    }


    /**
     * called when mouse exits the applet screen
     * @param e The mouse event
     **/
    public void mouseExited (MouseEvent e)
    {
	mouseInWindow = false;
	repaint ();
    }


    /**
    * called when a mouse button is pressed
    * @param e The mouse event
    **/
    public void mousePressed (MouseEvent e)
    {
	mouseButtonDown = true;
	x = e.getX ();
	y = e.getY ();
	repaint ();
    }


    /**
    * called when a mouse button is released
    * @param e The mouse event
    **/
    public void mouseReleased (MouseEvent e)
    {
	mouseButtonDown = false;
	repaint ();
    }
} // EventListenerDemo class
