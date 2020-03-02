package map;

public class Ant {

    private final String name;
    private int x;
    private int y;
    private Node currentNode;


    public Ant(String name, int x, int y, Node currentNode) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.currentNode = currentNode;
    }

    public int getY() {
        return y*Map.getSCALE();
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x*Map.getSCALE();
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getName() {
        return name;
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

}
