package org.example.view.component;

import javax.swing.*;

public class Input extends JTextField {
    private String value;
    private String placeholder;

    public Input(int columns) {
        super(columns);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void clear() {
        this.setText("");
    }



    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        this.setText(placeholder);
    }

    public String getPlaceholder() {
        return placeholder;
    }
}
