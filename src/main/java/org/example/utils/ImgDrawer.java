package org.example.utils;

import javax.swing.*;
import java.awt.*;

public class ImgDrawer {
    private String path;
    private Dimension screenSize;

    public ImgDrawer(String path, Dimension screenSize) {
        this.path = path;
        this.screenSize = screenSize;
    }

    public ImageIcon draw(){
        ImageIcon icon = new ImageIcon(this.path);

        Image image = icon.getImage();

        Image temp = image.getScaledInstance(this.screenSize.width, this.screenSize.height, Image.SCALE_SMOOTH);

        return new ImageIcon(temp);
    }
}
