import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class demonstrates how to use the MouseMotionListener interface in an Applet
 * Novembeer 28, 2007.
 * @author Sam Scott
 **/
public class MouseMotionListenerDemo extends Applet implements MouseMotionListener
{
    /**
     * the position at which the last mouse down event happened
     **/
    int x = -1, y = -1;

    /**
     * Set to true if it's a mouse dragged event
     **/
    boolean filled = false;
    
    /**
     * Activate the mouse listener
     **/
    public void init ()
    {
 addMouseMotionListener (this);
    }


    /**
     * Display basic information from mouse listeners
     * @param g The graphics context
     **/
    public void paint (Graphics g)
    {
 g.drawString ("Last Known Location: (" + x + "," + y + ")", 50, 90);
 if (filled)
   g.fillOval(x,y,50,50);
 else
   g.drawOval(x,y,50,50);
    }


    // THE METHODS BELOW ARE REQUIRED FOR THE MouseMotionListener INTERFACE
    // You must always have these methods in any class that implements
    // MouseListener

    /**
     * called when mouse is moved in the window
     * @param e The mouse event
     **/
    public void mouseMoved (MouseEvent e)
    {
 filled = false;
 x = e.getX ();
 y = e.getY ();
 repaint ();
    }


    /**
      * called when mouse is dragged in the window
      * @param e The mouse event
      **/
    public void mouseDragged (MouseEvent e)
    {
 filled = true;
 x = e.getX ();
 y = e.getY ();
 repaint ();
    }
} // EventListenerDemo class
