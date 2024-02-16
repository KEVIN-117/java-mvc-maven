package org.example.view.pages;

import org.example.controller.UserRepository;

import javax.swing.*;
import java.awt.*;

public class ListClient extends JPanel {
    private UserRepository repository;
    private JTable table;
    private JScrollPane scrollPane;


    public ListClient(UserRepository repository) {
        this.repository = repository;
        this.setLayout(new CardLayout());
        init();

    }

    private void init() {
        this.table = new JTable();
        this.scrollPane = new JScrollPane(this.table);
        
        this.add(this.scrollPane);
    }
}
