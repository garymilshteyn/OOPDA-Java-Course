import java.awt.*;
public class Oval2D extends Shape2D {
    private int width;
    private int height;

    public Oval2D(int colorIndex, int x, int y, int w, int h){
        super.SetPos(x,y);
        super.setFillColor(colorIndex);
        width = w;
        height = h;
    }

    @Override
    public void Draw(Graphics g){
        g.setColor(getFillColor());
        g.fillOval(GetX(), GetY(), width, height);

        if (super.ShowOutline()) {
            g.setColor(super.GetOutlineColor());
            g.drawOval(GetX(), GetY(), width, height);
        }
    }
}