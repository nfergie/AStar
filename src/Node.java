import java.util.ArrayList;
import java.util.Objects;

public class Node implements Comparable<Node>{
    Node parent;
    Location loc;

    //distance between curr and start
    private int g;

    //distance between curr and end (heuristic)
    private int h;

    //g + h;
    private int f;

    public Node(Node parent, Location loc){
        this.parent = parent;
        this.loc = loc;
    }

    public void setHeuristicD(Node end, int heuristic){
        switch (heuristic){
            case 0:
                this.h = this.euclidDistance(end);
                break;
            case 1:
                this.h = this.manhattanDistance(end);
                break;
        }
    }

    public int getH() {
        return h;
    }

    public void setG(int i){
        this.g = i;
    }

    public int getG() {
        return g;
    }

    public void setF() {
        this.f = this.g + this.h;
    }

    public int getF() {
        return f;
    }

    //get a list of neighbors of this node
    ArrayList<Node> getNeighbors(){
        ArrayList<Node> neighbors = new ArrayList<>();
        for(int i = -1; i <=1; i++){
            neighbors.add(new Node(this,
                    new Location(this.loc.row-1, this.loc.col + i)));
            neighbors.add(new Node(this,
                    new Location(this.loc.row+1, this.loc.col + i)));
            if(i != 0){
                neighbors.add(new Node(this,
                        new Location(this.loc.row, this.loc.col + i)));
            }
        }
        return neighbors;
    }


    //List of possible heuristics


    private int euclidDistance(Node end){
        double row = Math.pow(this.loc.row - end.loc.row, 2);
        double col = Math.pow(this.loc.col - end.loc.col, 2);
        return (int)(row+col);
    }

    private int manhattanDistance(Node end){
        return Math.abs(this.loc.row - end.loc.row) +
                Math.abs(this.loc.col - end.loc.col);
    }


    //overrrides

    @Override
    public int compareTo(Node o) {
        if(this.getF() > o.getF()){
            return 1;
        }else if(this.getF() < o.getF()){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(loc, node.loc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loc);
    }

}

