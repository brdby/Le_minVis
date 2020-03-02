package map;

import java.util.HashSet;

public class Node {

    private final String name;
    private double x;
    private double y;

    private HashSet<Node> connectedNodes = new HashSet<>();

    public Node(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x*Map.getSCALE();
    }

    public double getY() {
        return y*Map.getSCALE();
    }

    public boolean addEdge(Node n){
        return connectedNodes.add(n);
    }

    public HashSet<Node> getConnectedNodes(){
        return connectedNodes;
    }
}
