

import java.awt.*;

public class Nlo {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Nlo(final int x, final int y, final int width, final int height, final Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    void draw(final Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        g.setColor(this.color);
        g.fillOval((int) (this.x + 0.3 * this.width), this.y, (int) (0.4 * this.width), (int) (0.1 * this.height));
        g.setColor(Color.BLACK);
        g.drawOval((int) (this.x + 0.3 * this.width), this.y, (int) (0.4 * this.width), (int) (0.1 * this.height));

        g.setColor(this.color);
        g.fillOval((int) (this.x + 0.2 * this.width), (int) (this.y + 0.04 *this.height), (int) (0.6 * this.width), (int) (0.1 * this.height));
        g.setColor(Color.BLACK);
        g.drawOval((int) (this.x + 0.2 * this.width), (int) (this.y + 0.04 *this.height), (int) (0.6 * this.width), (int) (0.1 * this.height));

        //light
        g.setColor(new Color(139, 241, 139));
        g.fillPolygon(new int[]{(int) (this.x + 0.52 * this.width), (int) (this.x +0.48 * this.width), (int) (this.x +0.3 * this.width), (int) (this.x +0.7 * this.width)},
                new int[]{(int) (this.y + 0.08 *this.height), (int) (this.y + 0.08 *this.height), (int) (this.y + 0.93 *this.height), (int) (this.y + 0.93 *this.height)}, 4);

        //windows
        g.setColor(Color.CYAN);
        g.fillOval((int) (this.x +0.319 * this.width), (int) (this.y + 0.034 * this.height), (int) (0.012 * this.width), (int) (0.012 * this.height));
        g.fillOval((int) (this.x +0.343 * this.width), (int) (this.y + 0.025 * this.height), (int) (0.017 * this.width), (int) (0.017 * this.height));
        g.fillOval((int) (this.x +0.375 * this.width), (int) (this.y + 0.014 * this.height), (int) (0.025 * this.width), (int) (0.025 * this.height));
        g.fillOval((int) (this.x +0.42 * this.width), (int) (this.y + 0.007 * this.height), (int) (0.03 * this.width), (int) (0.03 * this.height));
        g.fillOval((int) (this.x +0.47 * this.width), (int) (this.y + 0.005 * this.height), (int) (0.03 * this.width), (int) (0.03 * this.height));
        g.fillOval((int) (this.x +0.52 * this.width), (int) (this.y + 0.005 * this.height), (int) (0.03 * this.width), (int) (0.03 * this.height));
        g.fillOval((int) (this.x +0.57 * this.width), (int) (this.y + 0.009 * this.height), (int) (0.025 * this.width), (int) (0.025 * this.height));
        g.fillOval((int) (this.x +0.61 * this.width), (int) (this.y + 0.017 * this.height), (int) (0.02 * this.width), (int) (0.02 * this.height));
        g.fillOval((int) (this.x +0.645 * this.width), (int) (this.y + 0.025 * this.height), (int) (0.015 * this.width), (int) (0.015 * this.height));
        g.fillOval((int) (this.x +0.67 * this.width), (int) (this.y + 0.034 * this.height), (int) (0.01 * this.width), (int) (0.01 * this.height));
    }
}
