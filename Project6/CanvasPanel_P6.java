/**
 * 2D CanvasPanel
 * 
 *
 * @author Gary Milshteyn
 * @version 4.13.25
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class CanvasPanel_P6 extends JPanel
{
    private final static int X_CORNER = 25;
    private final static int Y_CORNER = 25;
    private final static int CANVAS_WIDTH = 800;
    private final static int CANVAS_HEIGHT = 800;
    private int frameNumber = 0;
    private List<Shape2D> shapes;
    private Timer renderLoop;
    
    
    public CanvasPanel_P6()
    {
        // Create some shapes, they should be in a List
        shapes = new ArrayList<>();
        shapes.add(new Rectangle2D(2, 145, 50, 100, 140));
        shapes.add(new Rectangle2D(7, 185, 120, 20, 20));
        shapes.add(new Oval2D(6, 200, 90, 40, 20));
        shapes.add(new Oval2D(6, 150, 90, 40, 20));
        shapes.add(new Rectangle2D(0, 165, 150, 60, 20));
        shapes.add(new Circle2D(3, 160, 93, 15));
        shapes.add(new Circle2D(3, 215, 93, 15));
        
        // Create a render loop
        // Create a Swing Timer that will tick 30 times a second
        // At each tick the ActionListener that was registered via the lambda expression will be invoked
        // lambda expression for ActionListener implements actionPerformed method
        renderLoop = new Timer(30, (ActionEvent ev) -> {
            frameNumber++;
            Simulate();
            repaint();
        }); // lambda expression for ActionListener implements actionPerformed
        renderLoop.start();
    }
    
    public void Simulate()
    {
    }

    // This method is called by renderloop
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Set window background to black
        g.setColor(Color.BLACK);
        g.fillRect(0,0,CANVAS_WIDTH + 2 * X_CORNER, CANVAS_HEIGHT + 2 * Y_CORNER); //draw the black border
        
        // Set canvas background to grey
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(X_CORNER, Y_CORNER, CANVAS_WIDTH, CANVAS_HEIGHT); //make the canvas white

        // Need to make draw polymorphic and in a List
        for (Shape2D s : shapes){
            s.Draw(g);
        }  
    }
    
    public static int getCanvasWidth()
    {
        return CANVAS_WIDTH;
    }

    public static int getCanvasHeight()
    {
        return CANVAS_HEIGHT;
    }

    public static int getCanvasXBorder()
    {
        return X_CORNER;
    }

    public static int getCanvasYBorder()
    {
        return Y_CORNER;
    }
    
}
