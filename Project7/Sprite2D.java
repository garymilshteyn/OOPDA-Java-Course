import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite2D extends Shape2D {
    private BufferedImage[] frames;
    private int currentFrame;
    private int frameCount;

    private int dx = 0;
    private int dy = 0;

    public Sprite2D(int x, int y, BufferedImage[] frames) {
        super.SetPos(x, y);
        this.frames = frames;
        this.frameCount = (frames != null) ? frames.length : 0;
        currentFrame = 0;
    }

    public void SetSpeed(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void Animate() {
        if (frameCount > 0) {
            currentFrame = (currentFrame + 1) % frameCount;
        }
        Move(dx, dy);
    }

    @Override
    public void Draw(Graphics g) {
        if (frames != null && frameCount > 0 && frames[currentFrame] != null) {
            g.drawImage(frames[currentFrame], GetX(), GetY(), null);
        } else {
            g.setColor(Color.RED);
            g.fillRect(GetX(), GetY(), 50, 50); // fallback
        }
    }
}
