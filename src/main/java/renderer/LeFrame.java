package renderer;

import map.Map;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class LeFrame extends JFrame {

    public LeFrame(String name, Map map){
        super(name);
        JMap jmap = new JMap(map);
        add(jmap);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screensize = kit.getScreenSize();
        setSize(screensize.width/2, screensize.height/2);
        setVisible(true);

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                jmap.moveAnt(1, 1);
                jmap.repaint();
            }
        }, 1000, 100);
    }
}
