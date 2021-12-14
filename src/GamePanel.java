import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    int width, height, size, xunits, yunits;
    Board board;
    Game game = Game.getGame();
    InputHandler inputHandler;

    public GamePanel(int width, int height, int size) {
        this.width = width;
        this.height = height;
        this.size = size;
        this.xunits = width / size;
        this.yunits = height / size;
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(width + size, height + size));
        inputHandler = new InputHandler();
        this.addMouseListener(inputHandler);
        board = Game.game.getBoard();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw((Graphics2D) g);
    }

    public void draw(Graphics2D g) {
    /*
    geöffnete Mine: 3
    geschlossene Mine: 2
    geöffnet: 1
    geschlossen: 0
    */
        for (int x = 0; x < xunits; x++) {
            for (int y = 0; y < yunits; y++) {
                drawRect(g, board.getColor(x,y), x, y, size);
                // } else if(board.isClosedMine(x,y)){
                //weißes viereck

            }

        }


        g.setColor(Color.black);
        for (int i = 0; i <= xunits; i++) {
            g.drawLine(size * i, 0, size * i, height);
        }
        for (int i = 0; i <= yunits; i++) {
            g.drawLine(0, size * i, width, size * i);
        }

    }


    public void drawCross(Graphics2D g, Color c, int x, int y, int size) {
        Color prevCol = g.getColor();
        g.setColor(c);
        g.setStroke(new BasicStroke(2));
        g.drawLine(x * size, y * size, x * size + size, y * size + size);
        g.drawLine(x * size + size, y * size, x * size, y * size + size);
        g.setColor(prevCol);
    }

    public void drawRect(Graphics g, Color c, int x, int y, int size) {
        Color prevCol = g.getColor();
        g.setColor(c);
        g.fillRect(x * size, y * size, size, size);
        g.setColor(prevCol);
    }

    public void drawCenteredString(Graphics g, Color c, String text, int x, int y) {
        Color prevCol = g.getColor();
        Font font = new Font("TimesRoman", Font.BOLD, 40);
        FontMetrics metrics = g.getFontMetrics(font);
        int xx = x + (size - metrics.stringWidth(text)) / 2;
        int yy = y + ((size - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setFont(font);
        g.setColor(c);
        g.drawString(text, xx, yy);
        g.setColor(prevCol);
    }

}
