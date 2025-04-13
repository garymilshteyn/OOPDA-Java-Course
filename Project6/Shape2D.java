import java.awt.*;

public abstract class Shape2D {
    public final static int RED = 0;
    public final static int GREEN = 1;
    public final static int BLUE = 2;
    public final static int BLACK = 3;
    public final static int GREY = 4;
    public final static int WHITE = 5;
    public final static int YELLOW = 6;
    public final static int CYAN = 7;
    public final static int MAGENTA = 8;
    public final static int BROWN = 9;

    public static final Color[] COLORS = {
        new Color (255, 0, 0),
        new Color (0, 255, 0),
        new Color (0, 0, 255),
        new Color (0, 0, 0),
        new Color (128, 128, 128),
        new Color (255, 255, 255),
        new Color (255, 255, 0),
        new Color (0, 255, 255),
        new Color (255, 0, 255),
        new Color (165, 42, 42)
    };

    private int xPos;
    private int yPos;
    private Color fillColor;
    
    public abstract void Draw(Graphics g);
    
    public void setX(int x){
        this.xPos = x;
    }
    public void setY(int y){
        this.yPos = y;
    }
    public void setFillColor(int colorIndex){
        this.fillColor = COLORS[colorIndex];
    }

    public int getX(){
        return xPos;
    }
    public int getY(){
        return yPos;
    }
    public Color getFillColor(){
        return fillColor;
    }

    
}
