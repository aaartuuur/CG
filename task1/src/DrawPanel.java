import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DrawPanel extends JPanel implements ActionListener {
    private Timer timer;
    private int ticksFromStart = (int) (0.9 * Main.HEIGHT);
    private float ticksSize = 1;
    private boolean isSpacePressed = false;

    private Background background;
    private Human human;
    private Nlo nlo;

    public DrawPanel(final int timerDelay) {
        timer = new Timer(timerDelay, this);
        timer.stop();

        this.human = new Human(
                (int) (Main.WIDTH/2), ticksFromStart,
                (int) (100 * ticksSize), (int) (340 * ticksSize), Color.blue);
        this.nlo = new Nlo(0, 0, Main.WIDTH, Main.HEIGHT, Color.GRAY);
        this.background = new Background(Main.WIDTH, Main.HEIGHT);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (!isSpacePressed) {
                        isSpacePressed = true;
                        timer.start();
                    }
                }
            }
        });

        this.setFocusable(true);
    }

    @Override
    public void paint(final Graphics gr) {
        super.paint(gr);
        background.draw(gr);
        nlo.draw(gr);
        human.setY(ticksFromStart);
        human.setHeight((int) (human.getHeight() * ticksSize));
        human.setWidth((int) (human.getWidth() * ticksSize));
        human.draw(gr);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
            ticksFromStart -= 25;
            ticksSize *= 0.99;
        }
    }
}