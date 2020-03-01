package map;

import java.util.HashSet;

public class Node {

    private final String name;
    private int x;
    private int y;

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
        return x*Map.getSCALE();
    }

    public int getY() {
        return y*Map.getSCALE();
    }

    public void setX(int x){this.x = x;}

    public void setY(int y){this.y = y;}

    public boolean addEdge(Node n){
        return connectedNodes.add(n);
    }

    public HashSet<Node> getConnectedNodes(){
        return connectedNodes;
    }
}
