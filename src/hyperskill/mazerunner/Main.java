package hyperskill.mazerunner;

public class Main {

    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.run();
    }
}

class Maze{
    private final static int x = 10;
    private final static int y = 10;
    private int[][] map = new int[y][x];

    void run(){
        prepareSomeMaze();
        printMaze();
    }

    private void printMaze(){
        String wall = "\u2588\u2588";
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == 1){
                    System.out.print(wall);
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private void prepareSomeMaze(){
        map[0] = new int[]{1,1,1,1,1,1,1,1,1,1};
        map[1] = new int[]{0,0,1,0,1,0,1,0,0,1};
        map[2] = new int[]{1,0,1,0,0,0,1,0,1,1};
        map[3] = new int[]{1,0,0,0,1,1,1,0,0,0};
        map[4] = new int[]{1,0,1,0,0,0,0,0,1,1};
        map[5] = new int[]{1,0,1,0,1,1,1,0,1,1};
        map[6] = new int[]{1,0,1,0,1,0,0,0,1,1};
        map[7] = new int[]{1,0,1,0,1,1,1,0,1,1};
        map[8] = new int[]{1,0,1,0,0,0,1,0,0,1};
        map[9] = new int[]{1,1,1,1,1,1,1,1,1,1};
    }

}

// Prims algoritm - find minimum spanning tree
