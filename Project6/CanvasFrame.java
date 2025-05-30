/**
 * 2D Frame for 2D Graphics
 * 
 *
 * @author (Prof R)
 * @version (v1.0 11-17-22)
 */
import java.awt.*;
import javax.swing.*;

public class CanvasFrame 
{
    private JFrame frame;       // the actual frame(window) we'll be showing
    private CanvasPanel_P6 canvas; // the canvas we'll be drawing
    
    /**
     * Creates a new CanvasFrame object.
     */
    public CanvasFrame()
    {
        frame = new JFrame("Project 6 - Canvas Frame"); //make the JFrame, and set thw window bar title 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        canvas = new CanvasPanel_P6();  // CanvasPanel extends a JPanel
        
        // Use the canvasPanel size & borders to define window size
        canvas.setPreferredSize(new Dimension(2 * canvas.getCanvasXBorder() + canvas.getCanvasWidth(), 
                                              2 * canvas.getCanvasYBorder() + canvas.getCanvasHeight() ));
        frame.getContentPane().add(canvas); //put the canvas (JPanel) in the frame

        frame.pack();                       //make everything the preferred size
        frame.setVisible(true);             //show the frame
    }
}
