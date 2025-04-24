import java.awt.*;

public class StarPoly2D extends Shape2D {
    private int[] xPoints;
    private int[] yPoints;
    private int numPoints;

    public StarPoly2D(int colorIndex, int x, int y) {
        super.SetPos(x, y);
        super.setFillColor(colorIndex);
    }

    @Override
    public void Draw(Graphics g) {
        g.setColor(getFillColor());

        int[] drawX = new int[numPoints];
        int[] drawY = new int[numPoints];

        for (int i = 0; i < numPoints; i++) {
            drawX[i] = GetX() + xPoints[i];
            drawY[i] = GetY() + yPoints[i];
        }

        g.fillPolygon(drawX, drawY, numPoints);

    }
}
