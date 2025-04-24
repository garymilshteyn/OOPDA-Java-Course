import java.awt.*;

public class Polygon2D extends Shape2D {
    private int[] xPoints;
    private int[] yPoints;
    private int numPoints;

    public Polygon2D(int colorIndex, int x, int y, int[] xPoints, int[] yPoints) {
        super.SetPos(x, y);
        setFillColor(colorIndex);
        numPoints = xPoints.length;

        this.xPoints = xPoints;
        this.yPoints = yPoints;
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

        if (super.ShowOutline()) {
            g.setColor(super.GetOutlineColor());
            g.drawPolygon(drawX, drawY, numPoints);
        }
    }
}
