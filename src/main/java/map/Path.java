package map;

public class Path {

    private final String ant;
    private final Node node;
    private final int turn;

    public Path(String ant, Node node, int turn) {
        this.ant = ant;
        this.node = node;
        this.turn = turn;
    }

    public String getAnt() {
        return ant;
    }

    public Node getNode() {
        return node;
    }

    public int getTurn() {
        return turn;
    }
}
