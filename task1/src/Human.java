

import java.awt.*;

public class Human{
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Human(final int x, final int y, final int width, final int height, final Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth(){
        return this.width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight(){
        return this.height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    void draw(final Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        // legs
        g.setColor(Color.BLACK);
        g.fillRect((int) (this.x + 0.1 * this.width), (int)(this.y - 0.5 * this.height),
                (int) (0.25 * this.width), (int)(0.5*this.height));
        g.fillRect((int) (this.x - 0.35 * this.width), (int)(this.y - 0.5 * this.height),
                (int) (0.25 * this.width), (int)(0.5*this.height));

        //body
        g.setColor(this.color);
        g.fillRect((int) (this.x - 0.4 * this.width), (int)(this.y - 0.8 * this.height),
                (int) (0.8 * this.width), (int)(0.35*this.height));

        //hands
        g.fillRect((int) (this.x - 0.6 * this.width), (int)(this.y - 0.8 * this.height),
                (int) (0.2 * this.width), (int)(0.1*this.height));
        g.fillRect((int) (this.x + 0.4 * this.width), (int)(this.y - 0.8 * this.height),
                (int) (0.2 * this.width), (int)(0.1*this.height));

        g.setColor(new Color(253, 144, 35));
        g.fillRect((int) (this.x - 0.55 * this.width), (int)(this.y - 0.7 * this.height),
                (int) (0.1 * this.width), (int)(0.3*this.height));
        g.fillRect((int) (this.x + 0.45 * this.width), (int)(this.y - 0.7 * this.height),
                (int) (0.1 * this.width), (int)(0.3*this.height));

        //head
        g.fillRect((int) (this.x - 0.07 * this.width), (int)(this.y - 0.85 * this.height),
                (int) (0.14 * this.width), (int)(0.05*this.height));
        g.fillOval((int) (this.x - 0.3 * this.width), (this.y - this.height),
                (int) (0.6 * this.width), (int)(0.17*this.height));
    }
}
