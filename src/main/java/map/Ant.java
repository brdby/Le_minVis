package map;

public class Ant {

    private double x;
    private double y;
    private Node currentNode;


    public Ant(double x, double y, Node currentNode) {
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

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

}
