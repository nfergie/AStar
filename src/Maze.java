import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Maze {
    int rows;
    int cols;
    int [][] matrix;
    Location start;
    Location end;

    Maze(int rows, int cols, Location start, Location end){
        this.rows = rows;
        this.cols = cols;
        this.start = start;
        this.end = end;
        this.matrix = this.createMatrix();
    }

    private int[][] createMatrix(){
        int[][] matrix = new int[rows][cols];
        for(int i =0; i < rows; i++){
            for(int j =0; j < rows; j++){
                if((start.row == i && start.col == j)
                || (end.row == i && end.col == j)){
                    matrix[i][j] = 0;
                }else{
                    if(Math.random() < 0.2){
                        matrix[i][j] = 1;
                    }else{
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        return matrix;
    }

    LinkedList<Node> aStar(int heur){
        Node startN = new Node(null, start);
        Node endN = new Node(null, end);

        startN.setG(0);
        startN.setHeuristicD(endN, heur);
        startN.setF();

        HashMap<Location, Integer> distances = setDistances();

        LinkedList<Node> path = new LinkedList<>();
        PriorityQueue<Node> open = new PriorityQueue<>();

        open.add(startN);

        while(!open.isEmpty()){
            Node curr = open.poll();
            if(curr.equals(endN)){
                return path;
            }
            for(Node n : curr.getNeighbors()){
                if(isSafeMove(n)){
                    if(!open.contains(n) && !path.contains(n)
                    || curr.getG()+1 < distances.get(n.loc)){
                        n.setG(curr.getG()+1);
                        n.setHeuristicD(endN, heur);
                        n.setF();
                        if(path.contains(n)){
                            path.remove(n);
                        }
                        if(!open.contains(n)){
                            open.add(n);
                        }
                    }
                }
            }
            path.add(curr);
        }

        return path;
    }

    HashMap<Location, Integer> setDistances(){
        HashMap<Location, Integer> distances = new HashMap<>();
        for(int i =0; i < rows; i++){
            for(int j =0; j < cols; j++){
                if(start.row == i && start.col == j){
                    distances.put(new Location(i, j), 0);
                }else{
                    Location l = new Location(i,j);
                    distances.put(l, Integer.MAX_VALUE);
                }
            }
        }

        return distances;
    }

    boolean isSafeMove(Node move){
        return (move.loc.row < rows && move.loc.row >=0)
                && (move.loc.col < cols && move.loc.col >=0)
                && matrix[move.loc.row][move.loc.col] != 1;
    }
}
