/**
 * 2D CanvasPanel
 * 
 *
 * @author (Prof R)
 * @version (v1.0 11-17-22)
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CanvasPanel_Le11 extends JPanel
{
    private final static int X_CORNER = 25;
    private final static int Y_CORNER = 25;
    private final static int CANVAS_WIDTH = 600;
    private final static int CANVAS_HEIGHT = 600;

    // Indices of dynamic shapes
    private final static int Star_Shape_1 = 5;
    private final static int RED_CIRCLE = 6;
    private final static int BLUE_CIRCLE = 7;
    private final static int BLUE_RECT = 8;
    private final static int SONIC_SPRITE_1 = 10;

    List<Shape2D>   shapesList;
    boolean         action;
    private boolean jumpUp;    // for Sprite
    private boolean fallDown;  // for Sprite
    private int     frameNumber;


    public CanvasPanel_Le11()
    {   
        shapesList = new ArrayList<>();
        action     = false;
        
        // Mountain
        int [] xCoords = {25, 150, 200, 300, 400, 500, 625};
        int [] yCoords = {490, 390, 420, 350, 430, 300, 490};
        shapesList.add(new Polygon2D(Shape2D.BROWN, 0, 0, xCoords ,yCoords)); // Mountain,  shape 0
        
        // Grass and road
        shapesList.add(new Rectangle2D(Shape2D.GREEN, 25, 575, 600, 50));   // Green rectangle, shape 1
        shapesList.add(new Rectangle2D(Shape2D.BLACK, 25, 525, 600, 50));   // Black rectangle, shape 2
        shapesList.add(new Rectangle2D(Shape2D.WHITE, 25, 520, 600, 10));   // White rectangle, shape 3
        shapesList.add(new Rectangle2D(Shape2D.BLACK, 25, 490, 600, 30));   // Black rectangle, shape 4
        
        shapesList.add(new StarPoly2D(6, 200, 300));               // Star shape 5

        shapesList.add(new Circle2D());                            // Circle shape 6
        //                           color       xpos ypos diamater
        shapesList.add(new Circle2D(Shape2D.BLUE, 20, 20, 50));    // Circle shape 7

        shapesList.add(new Rectangle2D(Shape2D.BLUE, 100, 470, 100, 50));  // A blue reactangle, shape 8
        shapesList.get(6).SetOutline(true);
        shapesList.get(6).SetOutlineColor(Shape2D.WHITE);

        shapesList.add(new Oval2D(Shape2D.YELLOW, 400, 100, 40, 30)); // Yellow Oval shape 9
        
        // Sonic Sprite
        BufferedImage[] Sonic_Sprites = new BufferedImage[4];
        try {
            Sonic_Sprites[0] = ImageIO.read(new File("Sonic1.png"));
            Sonic_Sprites[1] = ImageIO.read(new File("Sonic2.png"));
            Sonic_Sprites[2] = ImageIO.read(new File("Sonic3.png"));
            Sonic_Sprites[3] = ImageIO.read(new File("Sonic4.png"));
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        shapesList.add(new Sprite2D(200, 515, Sonic_Sprites)); // shape 10

        // Callback from keyboard events
        this.setFocusable(true);
        this.addKeyListener(new myActionListener());
        System.out.println("keyboard event registered");

        // Create a render loop
        // Create a Swing Timer that will tick 30 times a second
        // At each tick the ActionListener that was registered via the lambda expression will be invoked
        Timer renderLoop = new Timer(30, (ActionEvent ev) -> {frameNumber++; Simulate(); repaint();}); // lambda expression for ActionListener implements actionPerformed
        renderLoop.start();
    }

    public void Simulate()
    {
        if (action)
        {
            Shape2D shape = null;

            // Two Spheres
            shapesList.get(RED_CIRCLE).Move(1, 2);  // move the shape along via a delta in x(1) and y(2)
            shapesList.get(BLUE_CIRCLE).Move(2, 1); // move the shape along via a delta in x(2) and y(1)

            // Blue Rectangle
            shape = shapesList.get(BLUE_RECT);
            shape.Move(2, 0);  // move car along road in x direction
            int x = shape.GetX();
            if (x > 800)
            {
                int y = shape.GetY();
                shape.SetPos(-50, y);
            }
            
            // Star_Shape_1
            shape = shapesList.get(Star_Shape_1);
            

            // Sonic_Sprite
            shape = shapesList.get(SONIC_SPRITE_1);
            shape.Move(8,0);
            if (shape.GetX() > 1020)
            {
                shape.SetPos(-50,shape.GetY());
            } 
            if (jumpUp) {
                shape.SetSpeed(0, -10);
                shape.Animate();
                if (shape.GetY() < 200)
                {
                    jumpUp = false;
                    fallDown = true;
                    shape.SetSpeed(0, 10);
                }
            }
            if (fallDown)
            {
                shape.Animate(); 
                if (shape.GetY() >= 515)
                {
                    fallDown = false;
                    shape.SetSpeed(0,0);
                }
            }
        }
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

        // Display frame number
        g.setColor(Color.white);   
        g.setFont(new Font("Consolas", Font.PLAIN, 30));
        g.drawString(Integer.toString(frameNumber), 300, 70);

        // Render all the shapes in the shapes list
        for (Shape2D shape : shapesList)
        {
            shape.Draw(g);
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
    public class myActionListener extends KeyAdapter 
    {
        public void keyPressed(KeyEvent e)
        {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_UP:
                    jumpUp = true;
                    break;
                case KeyEvent.VK_DOWN:
                    System.out.println("press down arrow");
                    break;
                case KeyEvent.VK_LEFT:
                    System.out.println("press left arrow");
                    break;
                case KeyEvent.VK_RIGHT:

                    break;
                case KeyEvent.VK_A:
                    action = true;
                    break;
                case KeyEvent.VK_S:
                    action = false;
                    break;
                default:
                    System.out.println("press some other key besides the arrow keys");
            }
        }

        public void keyReleased(KeyEvent e)
        {
            //System.out.println("released");
        }
    }
}
