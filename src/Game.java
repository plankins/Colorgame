public class Game {
    int width, height, size, xunits, yunits, mineCount;
    GameFrame frame;
    public Board board;

    private double delta;
    private boolean running = false;

    long startTime;
    static Game game;

    public Game(int size, int width, int height){
        game = this;

        this.width = width;
        this.height = height;
        this.size = size;
        this.xunits = width/size;
        this.yunits = height/size;
        this.mineCount = mineCount;

        this.board = new Board(xunits,yunits);

        this.frame = new GameFrame(width, height, size);



        run();
    }

    public void run(){
        running = true;
        long lastloop = System.nanoTime();
        startTime = (lastloop / 1000000);


        while (running) {
            long now = System.nanoTime();

            if((now-lastloop)/1000000 >= 10){
                frame.repaint();

                lastloop = now;
            }
        }
    }

    public static Game getGame(){
        return game;
    }

    public Board getBoard(){
        return board;
    }
}
