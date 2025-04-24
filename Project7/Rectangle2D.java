import java.awt.*;
public class Rectangle2D extends Shape2D {
    private int width;
    private int height;

    public Rectangle2D(int colorIndex, int x, int y, int w, int h){
        super.SetPos(x, y);
        super.setFillColor(colorIndex);
        width = w;
        height = h;
    }

    @Override
    public void Draw(Graphics g){
        g.setColor(getFillColor());
        g.fillRect(GetX(), GetY(), width, height);

        if (super.ShowOutline()) {
            g.setColor(super.GetOutlineColor());
            g.drawRect(GetX(), GetY(), width, height);
        }
    }
}
