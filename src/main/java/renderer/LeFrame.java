package renderer;

import map.Map;
import map.Node;

import javax.swing.*;

public class LeFrame extends JFrame {

    public LeFrame(String name, Map map){
        super(name);
        add(new JNode(map));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920,1080);
        setVisible(true);
    }

}
