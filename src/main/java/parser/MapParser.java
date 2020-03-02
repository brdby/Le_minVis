package parser;

import map.Map;
import map.Node;
import map.Path;
import renderer.LeMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapParser {

    private static boolean nextStart;
    private static boolean nextEnd;

    public static Map parseInput(String input){
        int ants = 0;
        Node start = null, end = null;
        HashMap<String, Node> nodes = new HashMap<>();
        LinkedList<Path> pathsList = new LinkedList<>();

        String[] strings = input.split("\n");
        int strCounter = 0;

        for (String str : strings){
            strCounter++;
            if (str.matches("")) break;

            else if (str.matches("[0-9]+"))  ants = Integer.parseInt(str);

            else if (str.length() >= 2 && str.substring(0, 2).equals("##")){
                parseCommandUtil(str.substring(2));
            }

            else if (str.matches("[a-zA-Z0-9]+ [0-9]+ [0-9]+")){
               Node node = parseNodeUtil(str);
               if (node == null) return null;
               else {
                   nodes.put(node.getName(), node);
                   if (nextEnd) {
                       end = node;
                       nextEnd = false;
                   }
                   else if (nextStart){
                       start = node;
                       nextStart = false;
                   }
               }
            }
            else if (str.matches("[a-zA-Z0-9]+-[a-zA-Z0-9]+")){
                if (!parseEdgeUtil(nodes, str)) return null;
            }
        }

        int turn = 0;
        for (int i = strCounter; i < strings.length; i++){
            turn++;
            String str = strings[i];
            if (!parsePathUtil(str, nodes, pathsList, turn)) return null;
        }

        return new Map(start, end, nodes, ants, pathsList);
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

        if (match.find()) {
            x = Integer.parseInt(match.group());
        }
        else return null;

        if (match.find()){
            y = Integer.parseInt(match.group());
        }
        else return null;

        return new Node(name, x, y);
    }

    private static boolean parseEdgeUtil(HashMap<String, Node> nodes, String edge){
        Pattern regex = Pattern.compile("[a-zA-Z0-9]+");
        Matcher match = regex.matcher(edge);
        String node1Name, node2Name;

        if (match.find()){
            node1Name = match.group();
        }
        else return false;

        if (match.find()){
            node2Name = match.group();
        }
        else return false;

        Node node1 = nodes.get(node1Name);
        Node node2 = nodes.get(node2Name);

        node1.addEdge(node2);
        node2.addEdge(node1);

        //Setting scale for map in case when coordinates are too close
        while (Math.sqrt(
                (node2.getX() - node1.getX())*(node2.getX() - node1.getX()) +
                (node2.getY() - node1.getY())*(node2.getY() - node1.getY()))
                < LeMap.ROOM_SIZE) {
            Map.setSCALE(Map.getSCALE()+10);
            }
        return true;
    }

    private static boolean parsePathUtil(String pathes, HashMap<String, Node> nodes,  LinkedList<Path> pathsList, int turn){
        Pattern regex = Pattern.compile("L[a-zA-Z0-9]+-[a-zA-Z0-9]+");
        Matcher match = regex.matcher(pathes);

        while (match.find()){
            String path = match.group();
            String ant, node2;

            Pattern node1reg = Pattern.compile("L[a-zA-Z0-9]+");
            Matcher node1match = node1reg.matcher(path);

            if (node1match.find()){
                ant = node1match.group();
            } else return false;

            Pattern node2reg = Pattern.compile("-[a-zA-Z0-9]+");
            Matcher node2match = node2reg.matcher(path);

            if (node2match.find()){
                node2 = node2match.group().substring(1);
            } else return false;

            pathsList.add(new Path(ant, nodes.get(node2), turn));
        }

        return true;
    }

}
