package map;

public class Path {

    private final Node node1;
    private final Node node2;
    private final int turn;

    public Path(Node node1, Node node2, int turn) {
        this.node1 = node1;
        this.node2 = node2;
        this.turn = turn;
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }

    public int getTurn() {
        return turn;
    }
}
