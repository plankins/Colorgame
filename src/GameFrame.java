import javax.swing.*;

public class GameFrame extends JFrame {
    int width, height, size;
    GamePanel panel;
    public GameFrame(int width, int height, int size){
        this.width = width;
        this.height = height;
        this.size = size;

        panel = new GamePanel(width, height, size);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.add(panel);
        this.pack();
    }
}
