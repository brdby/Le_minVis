package renderer;

import map.Map;

import java.awt.*;
import java.awt.geom.Line2D;

public class JEdge {

    private Map map;

    JEdge(Map map){
        this.map = map;
    }


    public void paintComponent(Graphics g){


        g.setColor(Color.RED);

    }
}
