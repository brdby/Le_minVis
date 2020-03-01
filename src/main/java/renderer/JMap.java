package renderer;

import map.Map;
import map.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

import static java.awt.RenderingHints.*;

public class JMap extends JComponent {

    private Map map;
    public final static int ROOM_SIZE = 20;
    private int CURRENTX = 0;
    private int CURRENTY = 0;

    JMap(Map map){
        this.map = map;
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.RED);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //rendering edges
        map.getNodes().forEach((name, node) -> {
                    node.getConnectedNodes().forEach(
                            (nodeN) -> {
                                g2.draw(new Line2D.Double(
                                        node.getX() + (ROOM_SIZE / 2.0),
                                        node.getY() + (ROOM_SIZE / 2.0),
                                        nodeN.getX() + (ROOM_SIZE / 2.0),
                                        nodeN.getY() + (ROOM_SIZE / 2.0)));
                            }
                    );
                });


        //rendering nodes
        map.getNodes().forEach((name, node) -> {
            g.fillOval(node.getX(), node.getY(), ROOM_SIZE, ROOM_SIZE);
        });

        //rendering ants
        Node start = map.getStart();
        g.setColor(Color.black);
        g.fillOval(start.getX()+(ROOM_SIZE / 4)+CURRENTX, start.getY()+(ROOM_SIZE / 4)+CURRENTY, 10, 10);
    }

    public void moveAnt(int x, int y){
        CURRENTX += x;
        CURRENTY += y;
    }


}
