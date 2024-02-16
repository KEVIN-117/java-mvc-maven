package org.example.view.layout;

import org.example.view.component.Input;
import org.example.view.component.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class InputArea extends JPanel{
    private String label;
    private String placeholder;
    private String value;
    private Input input;
    private Panel panel;


    public InputArea(String label, String placeholder, String value) {
        this.label = label;
        this.placeholder = placeholder;
        this.value = value;
        this.input = new Input(20);
        this.panel = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        init();
    }
    private void init() {
        JLabel label = new JLabel(this.label);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(100, 100, 300, 30);
        label.setForeground(new Color(255, 255, 255, 255));


        this.panel.setBackground(new Color(255, 255, 255, 173));
        this.input.setPlaceholder(this.placeholder);
        this.input.setBackground(new Color(255, 255, 255, 173));
        input.setFont(new Font("Arial", Font.PLAIN, 30));
        input.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {
                if (input.getText().equals(placeholder)) {
                    input.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (input.getText().isEmpty()) {
                    input.setText(placeholder);
                }
            }
        });
        this.panel.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        this.panel.setBackground(new Color(0, 0, 0, 0));
        this.panel.add(label);
        this.panel.add(this.input);
    }

    public JPanel getPanel() {
        this.panel.revalidate();
        this.panel.repaint();
        return this.panel;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }
}
