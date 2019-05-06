import java.util.LinkedList;

//This is where we're gonna do AStar
public class AStar {
    public static void main(String[] args){
        Location start = new Location(0,0);
        Location end = new Location(9, 9);
        Maze m = new Maze(10, 10, start, end);
        for(int i =0; i < 10; i++){
            for(int j =0; j < 10; j++){
                System.out.print(m.matrix[i][j]);
            }
            System.out.println();
        }
        long startTime = System.nanoTime();
        LinkedList path = m.aStar(0);
        long endtime = System.nanoTime();
        System.out.println("Time to process(ms) A*: " + (endtime-startTime)/100000);
        for(Node n : m.aStar(0)){
            System.out.println(n);
        }

    }
}
