import java.awt.*;
public class Rectangle2D extends Shape2D {
    private int width;
    private int height;

    public Rectangle2D(int colorIndex, int x, int y, int w, int h){
        setX(x);
        setY(y);
        setFillColor(colorIndex);
        this.width = w;
        this.height = h;
    }

    public void Draw(Graphics g){
        g.setColor(getFillColor());
        g.fillRect(getX(), getY(), width, height);
    }
}
