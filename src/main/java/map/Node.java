package map;

import java.util.HashSet;

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

    public HashSet<Node> getConnectedNodes(){
        return connectedNodes;
    }
}
