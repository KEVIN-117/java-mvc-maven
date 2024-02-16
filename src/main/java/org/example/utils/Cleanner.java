package org.example.utils;

import javax.swing.*;
import java.awt.*;

public class Cleanner {
    public static void cleaner(JPanel panel){
        if (panel.getComponents().length > 0){
            Component component = panel.getComponent(0);
            if (component != null){
                panel.remove(component);
                panel.revalidate();
                panel.repaint();
            }
        }

    }
}
