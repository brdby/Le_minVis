package map;

import java.util.HashMap;
import java.util.HashSet;

public class Map {

    private final Node start;
    private final Node end;
    private final HashMap<String, Node> nodes;
    private final int ants;
    private static int SCALE = 1;

    public Map(Node start, Node end, HashMap<String, Node> nodes, int ants){
        this.start = start;
        this.end = end;
        this.nodes = nodes;
        this.ants = ants;
    }


    public Node getEnd() {
        return end;
    }

    public Node getStart() {
        return start;
    }

    public HashMap<String, Node> getNodes() {
        return nodes;
    }

    public int getAnts() {
        return ants;
    }

    public static int getSCALE() {
        return SCALE;
    }

    public static void setSCALE(int SCALE) {
        Map.SCALE = SCALE;
    }
}
