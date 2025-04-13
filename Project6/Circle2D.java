import java.awt.*;
public class Circle2D extends Shape2D {
    private int diameter;

    public Circle2D(int colorIndex, int x, int y, int d){
        setX(x);
        setY(y);
        setFillColor(colorIndex);
        this.diameter = d;
    }

    public void Draw(Graphics g){
        g.setColor(getFillColor());
        g.fillOval(getX(), getY(), diameter, diameter);
    }
}
