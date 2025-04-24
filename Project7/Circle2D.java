import java.awt.*;
public class Circle2D extends Shape2D {
    private int diameter;

    public Circle2D(int colorIndex, int x, int y, int d){
        super.SetPos(x, y);
        super.setFillColor(colorIndex);
        diameter = d;
    }
    
    public Circle2D(){
        super.SetPos(0, 0);
        super.setFillColor(Shape2D.RED);
        diameter = 50;
    }

    @Override
    public void Draw(Graphics g){
        g.setColor(getFillColor());
        g.fillOval(GetX(), GetY(), diameter, diameter);

        if (super.ShowOutline()) {
            g.setColor(super.GetOutlineColor());
            g.drawOval(GetX(), GetY(), diameter, diameter);
        }
    }
}
