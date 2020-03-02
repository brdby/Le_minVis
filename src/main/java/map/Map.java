package map;


import java.util.HashMap;
import java.util.LinkedList;

public class Map {

    private final Node start;
    private final Node end;
    private final HashMap<String, Node> nodes;
    private final int antsCounter;
    private static int SCALE = 1;
    private final HashMap<String, Ant> ants = new HashMap<>();
    private final LinkedList<Path> paths;

    public Map(Node start, Node end, HashMap<String, Node> nodes, int antsCounter, LinkedList<Path> paths){
        this.start = start;
        this.end = end;
        this.nodes = nodes;
        this.antsCounter = antsCounter;
        this.paths = paths;

        for (int i = 1; i <= this.antsCounter; i++){
            ants.put("L"+i, new Ant(start.getX(), start.getY(), start));
        }
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

    public int getAntsCounter() {
        return antsCounter;
    }

    public HashMap<String, Ant> getAnts() { return ants; }

    public static int getSCALE() {
        return SCALE;
    }

    public static void setSCALE(int SCALE) {
        Map.SCALE = SCALE;
    }

    public LinkedList<Path> getPaths() {
        return paths;
    }
}
