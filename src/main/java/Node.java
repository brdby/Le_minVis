import javafx.scene.control.TreeSortMode;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Node {

    private final String name;
    private final int x;
    private final int y;

    private HashSet<Node> connectedNodes = new HashSet<>();

    public Node(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean addNode(Node n){
        return connectedNodes.add(n);
    }
}
