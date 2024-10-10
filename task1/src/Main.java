

import javax.swing.*;

public class Main {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        window.setVisible(true);
    }
}
