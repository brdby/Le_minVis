package renderer;

import map.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class LeMap extends JComponent {

    private Map map;
    public final static int ROOM_SIZE = 100;

    LeMap(Map map){
        this.map = map;
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.RED);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //rendering edges
        map.getNodes().forEach((name, node) -> node.getConnectedNodes().forEach(
                (nodeN) -> g2.draw(new Line2D.Double(
                        node.getX() + (ROOM_SIZE / 2.0),
                        node.getY() + (ROOM_SIZE / 2.0),
                        nodeN.getX() + (ROOM_SIZE / 2.0),
                        nodeN.getY() + (ROOM_SIZE / 2.0)))
        ));


        //rendering nodes
        map.getNodes().forEach((name, node) -> g2.draw(new Ellipse2D.Double(node.getX(), node.getY(), ROOM_SIZE, ROOM_SIZE) {
        }));

        //rendering ants
        g.setColor(Color.black);
        map.getAnts().forEach((name , ant) -> g.fillOval((int)ant.getX()+(ROOM_SIZE / 4),
                (int)ant.getY()+(ROOM_SIZE / 4), ROOM_SIZE/2, ROOM_SIZE/2));
    }

}
