package org.example.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageDrawer{

    public static Image draw(String path, Dimension screenSize){
        Image image = new ImageIcon(path).getImage();
        return image.getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
    }

}
