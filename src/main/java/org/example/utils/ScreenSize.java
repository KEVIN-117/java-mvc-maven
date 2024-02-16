package org.example.utils;

import java.awt.*;

public class ScreenSize {
    private int width;
    private int heigth;

    public ScreenSize() {
        this.width = 0;
        this.heigth = 0;
    }

    private void calculateScreenSize() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        this.width = screenSize.width;
        this.heigth = screenSize.height;
    }

    public int getWidth() {
        calculateScreenSize();
        return this.width;
    }
    public int getHeigth() {
        calculateScreenSize();
        return this.heigth;
    }

    public int getWidthM() {
        calculateScreenSize();
        return this.width / 2;
    }
    public int getHeigthM() {
        calculateScreenSize();
        return this.heigth / 2;
    }

    public Dimension getScreenSize() {
        calculateScreenSize();
        return new Dimension(this.width, this.heigth);
    }
}
