package map;

public class Ant {

    private final String name;
    private double x;
    private double y;
    private Node currentNode;


    public Ant(String name, double x, double y, Node currentNode) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.currentNode = currentNode;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
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
