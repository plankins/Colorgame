import java.awt.*;
import java.awt.event.*;

public class InputHandler implements MouseListener, MouseMotionListener, KeyListener {

    Game game = Game.getGame();
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {



    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX() / game.size;
        int y = e.getY() / game.size;
        if (x < 0 || x > game.xunits - 1 || y < 0 || y > game.yunits - 1) {
            game.board.shuffleColors();
        } else {
            if (e.getButton() == MouseEvent.BUTTON1) {
                //TODO: maustastenabfrage in andere klasse
                Game.getGame().board.click(x, y);
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                game.board.set(x,y,Color.blue);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
