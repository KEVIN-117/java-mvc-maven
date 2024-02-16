package org.example.view.component;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Panel extends JPanel {
    private Color color;
    private List<Component> components;
    private Dimension dimension;

    public Panel(LayoutManager layout) {
        super(layout);
    }

    public Panel(LayoutManager layout, List<Component> components, Dimension dimension) {
        super(layout);
        this.components = components;
        this.dimension = dimension;
        init();
    }

    public void init() {
        setPreferredSize(this.dimension);
        setSize(this.dimension);
        if (this.components != null) {
            for (Component component : this.components) {
                add(component);
            }
        }
    }
}
