import java.awt.*;

public class Background {
    private int width;
    private int height;

    public Background(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    void draw(final Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        g.setColor(new Color(0, 49, 0));
        g.fillRect(0, (int)(0.6 * this.height), this.width, (int)(0.4*this.height));

        g.setColor(new Color(0, 0, 110));
        g.fillRect(0, 0, this.width, (int)(0.6*this.height));

        g.setColor(Color.YELLOW);
        g.fillOval((int) (0.02 * this.width), (int) (0.01 * this.height), (int) (0.1 * this.width), (int) (0.1 * this.height));

        g.setColor(new Color(0, 0, 110));
        g.fillOval((int) (0.035 * this.width), 0, (int) (0.1 * this.width), (int) (0.1 * this.height));

    }
}
