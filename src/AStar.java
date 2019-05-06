import java.util.ArrayList;
import java.util.LinkedList;

//This is where we're gonna do AStar
public class AStar {
    public static void main(String[] args){
        int row = 500;
        int col = 500;
        Location start = new Location(0,0);
        Location end = new Location(row-1, col-1);
        Maze m = new Maze(row, col, start, end);
//        for(int i =0; i < row; i++){
//            for(int j =0; j < col; j++){
//                System.out.print(m.matrix[i][j]);
//            }
//            System.out.println();
//        }
        long startTime = System.nanoTime();
        LinkedList path = m.aStar(0);
        long endtime = System.nanoTime();
        System.out.println("Time to process(ms) A*: " + (endtime-startTime)/100000);
//        for(Node n : m.aStar(0)){
//            System.out.println(n);
//        }

        long startTime2 = System.nanoTime();
        ArrayList<Node> path2 = m.dfs();
        long endtime2 = System.nanoTime();
        System.out.println("Time to process(ms) DFS: " + (endtime2-startTime2)/100000);
//        for(Node n : path2){
//            System.out.println(n);
//        }

    }
}
