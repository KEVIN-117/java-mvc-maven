package org.example.view.pages;

import org.example.utils.ImageDrawer;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image image;
    private String path;
    private Dimension screenSize;

    public ImagePanel(String path, Dimension screenSize) {
        this.path = path;
        this.screenSize = screenSize;
        this.image = ImageDrawer.draw(this.path, this.screenSize);
    }


    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        this.repaint();
        this.revalidate();
        g.drawImage(image, 0, 0, null);
    }

    public JPanel getPanel() {
        this.revalidate();
        this.repaint();
        return this;
    }
}
