import javafx.css.Match;

import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapParser {

    private static boolean nextStart;
    private static boolean nextEnd;

    public static Map parseInput(String input){
        int ants = 0;
        Node start = null, end = null;
        HashMap<String, Node> nodes = new HashMap<>();

        String[] strings = input.split("\n");

        for (String str : strings){
            if (str.matches("[0-9]+"))  ants = Integer.parseInt(str);

            else if (str.substring(0, 2).equals("##")){
                parseCommandUtil(str.substring(2));
            }

            else if (str.matches("[a-zA-Z0-9]+ [0-9]+ [0-9]+")){
               Node node = parseNodeUtil(str);
               if (node == null) return null;
               else nodes.put(node.getName(), node);
               if (nextEnd) end = node;
               else if (nextStart) start = node;
            }
            else if (str.matches("[a-zA-Z0-9]+-[a-zA-Z0-9]+")){
                if (!parseEdgeUtil(nodes, str)) return null;
            }
        }

        return new Map(start, end, nodes, ants);
    }

    private static void parseCommandUtil(String command){
        if (command.equals("start")) nextStart = true;
        else if (command.equals("end")) nextEnd = true;
    }

    private static Node parseNodeUtil(String node){
        Pattern regex = Pattern.compile("[a-zA-Z0-9]+");
        Matcher match = regex.matcher(node);

        String name;
        int x, y;

        if (match.find()) name = match.group();
        else return null;

        if (match.find()) x = Integer.parseInt(match.group());
        else return null;

        if (match.find()) y = Integer.parseInt(match.group());
        else return null;

        return new Node(name, x, y);
    }

    private static boolean parseEdgeUtil(HashMap<String, Node> nodes, String edge){
        Pattern regex = Pattern.compile("[a-zA-Z0-9]+");
        Matcher match = regex.matcher(edge);
        String node1, node2;

        if (match.find()){
            node1 = match.group();
        }
        else return false;

        if (match.find()){
            node2 = match.group();
        }
        else return false;

        nodes.get(node1).addNode(nodes.get(node2));
        nodes.get(node2).addNode(nodes.get(node1));
        return true;
    }

}
