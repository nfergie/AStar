import java.util.Objects;

public class Node {
    Node parent;
    Location loc;
    int g;
    int h;
    int f;

    public Node(Node parent, Location loc){
        this.parent = parent;
        this.loc = loc;
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

