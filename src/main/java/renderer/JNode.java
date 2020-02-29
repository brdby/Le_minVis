package renderer;

import map.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class JNode extends JComponent {

    private Map map;

    JNode(Map map){
        this.map = map;
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.RED);
        Graphics2D g2 = (Graphics2D) g;

        map.getNodes().forEach((name, node) -> {
            node.getConnectedNodes().forEach( (nodeN) -> g2.draw( new Line2D.Double(node.getX(), node.getY(),
                    nodeN.getX(), nodeN.getY())));

        });

        map.getNodes().forEach((name, node) -> {
            g.fillOval(node.getX(), node.getY(), 50, 50);
        });
    }

}
