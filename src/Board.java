import java.awt.*;

public class Board {
    Color[][] boardArray;
    int xunits, yunits;
    Color[] possibleColors = {Color.RED, Color.blue, Color.green, Color.cyan, Color.yellow};
    Color selectedColor;
    int[][] checked;

    public Board(int x, int y) {
        this.boardArray = new Color[x][y];
        this.xunits = x;
        this.yunits = y;

        //setAll(feld.GESCHLOSSEN);

        shuffleColors();
        checked = new int[xunits][yunits];

    }

    public void set(int x, int y, Color c) {
        if (x < 0 || x > xunits - 1 || y < 0 || y > yunits - 1) {
            return;
        } else {
            this.boardArray[x][y] = c;
        }
    }

    public Color getColor(int x, int y) {
        if (x < 0 || x > xunits - 1 || y < 0 || y > yunits - 1) {
            return null;
        } else {
            return boardArray[x][y];
        }
    }

    public void setAll(Color c) {
        for (int xx = 0; xx < xunits; xx++) {
            for (int yy = 0; yy < yunits; yy++) {
                set(xx, yy, c);
            }

        }
    }

    public void shuffleColors() {
        for (int i = 0; i < xunits; i++) {
            for (int j = 0; j < yunits; j++) {
                set(i, j, getRandomColor());

            }
        }
        selectedColor = getColor(0, 0);
    }

    public Color getRandomColor() {
        //Color c = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        Color c = possibleColors[(int) (Math.random() * possibleColors.length)];
        return c;
    }

    public void click(int x, int y) {
        if (x < 0 || x > xunits - 1 || y < 0 || y > yunits - 1) {
            return;
        } else {
            Color clicked = getColor(x, y);
            selectedColor = clicked;
            check(0, 0);
            Game.getGame().run();

        }
    }

    public void check(int x, int y) {
        Color startColor = getColor(0, 0);
        int xx, yy;


        //rechts
        xx = x+1;
        yy = y;
        if (getColor(xx, yy) == startColor) {
            check(xx, yy);
        }

        //unten
        xx = x;
        yy = y+1;
        if (getColor(xx, yy) == startColor) {
            check(xx, yy);
        }



        set(x, y, selectedColor);
        check2(x,y);

    }

    public void check2(int x, int y) {
        Color startColor = getColor(0, 0);
        int xx, yy;


        //oben
        xx = x;
        yy = y-1;
        if (getColor(xx, yy) == startColor) {
            check2(xx, yy);
        }

        //links
        xx = x-1;
        yy = y;
        if (getColor(xx, yy) == startColor) {
            check2(xx, yy);
        }





        set(x, y, selectedColor);


    }


}



