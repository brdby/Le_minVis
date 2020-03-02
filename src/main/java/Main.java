import map.Map;
import parser.FileReader;
import parser.MapParser;
import renderer.LeFrame;

import java.awt.*;

public class Main {

    public static void main(String[] args){
        Map map = MapParser.parseInput(FileReader.readFile("map"));
        System.out.println("Ok!");
        EventQueue.invokeLater(() -> {
            LeFrame vis = new LeFrame("Visualizer", map);
            vis.startSimulating();
        });
    }
}

