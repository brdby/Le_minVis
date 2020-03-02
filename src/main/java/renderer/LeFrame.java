package renderer;

import map.Ant;
import map.Map;
import map.Node;
import map.Path;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;

public class LeFrame extends JFrame {

    private static final long TURN_TIME = 2000;

    private LeMap jmap;

    public LeFrame(String name, Map map){
        super(name);
        jmap = new LeMap(map);
        add(jmap);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screensize = kit.getScreenSize();
        setSize(screensize.width, screensize.height);
        setVisible(true);


        //simulating turns
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            private long period = TURN_TIME;
            HashSet<Path> paths = new HashSet<>();

            @Override
            public void run() {
                period += 10;

                paths.removeIf(path -> moveAnt(map.getAnts().get(path.getAnt()), path.getNode(), period));

                while (map.getPaths().peek() != null && map.getPaths().peek().getTurn() <= period / TURN_TIME) {
                        Path nextPath = map.getPaths().poll();
                        paths.add(nextPath);
                }


                jmap.repaint();
            }
        }, 0, 10);
    }

    private boolean moveAnt(Ant ant, Node node, long period){
        if (period % TURN_TIME == 0){
            ant.setCurrentNode(node);
            ant.setX(node.getX());
            ant.setY(node.getY());
            return true;
        }

        ant.setX(ant.getX() + ((node.getX()-ant.getCurrentNode().getX())/(TURN_TIME/10.0)));
        ant.setY(ant.getY() + ((node.getY()-ant.getCurrentNode().getY())/(TURN_TIME/10.0)));
        return false;
    }
}
