package org.example.view.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Button extends JButton {
    public Button(String text, Dimension dimension) {
        super(text);
        this.setSize(dimension);
    }
}
