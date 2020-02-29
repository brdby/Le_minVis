import map.Map;
import parser.FileReader;
import parser.MapParser;
import renderer.LeFrame;

public class Main {

    public static void main(String[] args){
        Map map = MapParser.parseInput(FileReader.readFile("map"));
        System.out.println("Ok!");
        LeFrame vis = new LeFrame("Visualizer", map);
    }
}

