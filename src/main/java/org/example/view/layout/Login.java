package org.example.view.layout;

import org.example.view.component.Button;
import org.example.view.component.Input;

import javax.swing.*;
import java.awt.*;

public class Login {
    private JPanel panel;
    private Button cancel, login;
    public Login(Dimension screenSize) {
        panel = new JPanel();
        panel.setSize(screenSize);
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        this.cancel = new Button("Cancel", new Dimension(50, 30));
        this.login = new Button("Login", new Dimension(50, 30));
        init();
    }


    public void init(){
        InputArea inputArea = new InputArea("Username", "Enter your username", "");
        InputArea passwordArwa = new InputArea("Password", "Enter your Password", "");

        this.panel.add(inputArea.getPanel());
        this.panel.add(passwordArwa.getPanel());
        this.panel.add(this.login);
        this.panel.add(this.cancel);
    }

    public JPanel getPanel() {
        this.panel.revalidate();
        this.panel.repaint();
        return this.panel;
    }

}
