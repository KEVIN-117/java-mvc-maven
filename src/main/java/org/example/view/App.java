package org.example.view;

import org.example.controller.UserRepository;
import org.example.model.UserModel;
import org.example.utils.Cleanner;
import org.example.utils.ImgDrawer;
import org.example.utils.ScreenSize;
import org.example.utils.getFields;
import org.example.view.component.Panel;
import org.example.view.layout.Login;
import org.example.view.pages.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class App extends JFrame {
    private ScreenSize screenSize;
    private JPanel northPanel, southPanel, centerPanel, westPanel, eastPanel;
    private UserRepository repository;



    private ImagePanel imagePanel;
    private JButton closeButton, create, list, update, delete;
    public App() {
        this.repository = new UserRepository();
        this.setLayout(null);
        this.screenSize = new ScreenSize();
        setTitle("App");
        setSize(this.screenSize.getWidth(), this.screenSize.getHeigth());
        setLocationRelativeTo(null);
        setTitle("App Register");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        initBtns();
        init();
        initPanel();
        eventManager();

    }

    private void initBtns() {
        this.closeButton = new JButton("Exit");
        this.create = new JButton("Create");
        this.delete = new JButton("Delete");
        this.update = new JButton("Update");
        this.list = new JButton("List");

        this.closeButton.setBackground(Color.red);
        this.create.setBackground(new Color(0, 0, 0, 100));
        this.delete.setBackground(new Color(0, 0, 0, 100));
        this.update.setBackground(new Color(0, 0, 0, 100));
        this.list.setBackground(new Color(0, 0, 0, 100));

        this.closeButton.setForeground(Color.white);
        this.create.setForeground(Color.white);
        this.delete.setForeground(Color.white);
        this.update.setForeground(Color.white);
        this.list.setForeground(Color.white);




    }

    private void init() {
        imagePanel = new ImagePanel("C:\\Users\\MSI\\IdeaProjects\\java-mvc-maven\\src\\main\\resources\\images\\arch.jpg", this.screenSize.getScreenSize());
        imagePanel.setSize(this.screenSize.getScreenSize());
        imagePanel.setLayout(new BorderLayout());

        this.closeButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                closeButton.setBackground(Color.red);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                closeButton.setBackground(Color.red);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                closeButton.setBackground(Color.red);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                closeButton.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                closeButton.setBackground(Color.red);
            }
        });


        this.add(imagePanel);
    }

    private void initPanel(){
        this.northPanel = new JPanel(new GridLayout(0, 5, 10, 10));
        this.southPanel = new JPanel();
        this.centerPanel = new JPanel(new CardLayout(20, 20));
        this.westPanel = new JPanel();
        this.eastPanel = new JPanel();

        this.northPanel.setBackground(new Color(0, 0, 0, 0));
        this.southPanel.setBackground(new Color(0, 0, 0, 0));
        this.centerPanel.setBackground(new Color(0, 0, 0, 0));
        this.westPanel.setBackground(new Color(0, 0, 0, 0));
        this.eastPanel.setBackground(new Color(0, 0, 0, 0));

        this.northPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        this.southPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        this.centerPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        this.westPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        this.eastPanel.setBorder(BorderFactory.createLineBorder(Color.blue));



        this.imagePanel.add(this.northPanel, BorderLayout.NORTH);
        this.imagePanel.add(this.southPanel, BorderLayout.SOUTH);
        this.imagePanel.add(this.centerPanel, BorderLayout.CENTER);
        this.imagePanel.add(this.westPanel, BorderLayout.WEST);
        this.imagePanel.add(this.eastPanel, BorderLayout.EAST);

        this.northPanel.add(this.closeButton);
        this.northPanel.add(this.create);
        this.northPanel.add(this.list);
        this.northPanel.add(this.update);
        this.northPanel.add(this.delete);

    }

    private void eventManager(){
        this.closeButton.addActionListener(e ->{
            eventController("exit");
        });
        this.create.addActionListener(e ->{
            eventController("create");
        });
        this.list.addActionListener(e ->{
            eventController("list");
        });
        this.update.addActionListener(e ->{
            eventController("update");
        });
        this.delete.addActionListener(e ->{
            eventController("delete");
        });
    }

    private void eventController(String event){
        Component component = null;
        Cleanner.cleaner(this.centerPanel);
        switch (event){
            case "create":
                component = new CreateClient();
                this.centerPanel.add(component);
                break;
            case "list":
                component = new ListClient(repository);
                this.centerPanel.add(component);
                break;
            case "update":
                component = new Updateclient();
                this.centerPanel.add(component);
                break;
            case "delete":
                component = new DeleteClent();
                this.centerPanel.add(component);
                break;
            case "exit":
                System.exit(0);
                break;

        }
    }

}
