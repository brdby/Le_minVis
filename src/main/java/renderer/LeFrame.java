package renderer;

import map.Ant;
import map.Map;
import map.Node;
import map.Path;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class LeFrame extends JFrame {
    private LeMap jmap;

    public LeFrame(String name, Map map){
        super(name);
        jmap = new LeMap(map);
        add(jmap);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screensize = kit.getScreenSize();
        setSize(screensize.width/2, screensize.height/2);
        setVisible(true);

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            private long period = 1000;

            @Override
            public void run() {
                period += 10;

                if (map.getPaths().size() > 0){
                    while (map.getPaths().peek() != null && map.getPaths().peek().getTurn() <= period / 1000) {
                        Path nextPath = map.getPaths().poll();
                        moveAnt(map.getAnts().get(nextPath.getAnt()), nextPath.getNode(), period);
                    }
                }



                jmap.repaint();
            }
        }, 0, 10);
    }

    private void moveAnt(Ant ant, Node node, long period){
        if (period / 1000 == 0){
            ant.setCurrentNode(node);
            ant.setX(node.getX());
            ant.setY(node.getY());
        }

        ant.setX(ant.getX() + ((node.getX()-ant.getX())/100));
        ant.setY(ant.getY() + ((node.getY()-ant.getY())/100));
    }
}
