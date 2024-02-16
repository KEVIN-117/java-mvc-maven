package org.example.view;

import javax.swing.*;
import javax.swing.SpringLayout;
import java.awt.*;

public class UserView {
    public static void main(String[] args) {
        JFrame frame = new JFrame("SpringLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Crear un JPanel con SpringLayout
        JPanel panel = new JPanel(new SpringLayout());
        Dimension sise = Toolkit.getDefaultToolkit().getScreenSize();
        panel.setBounds(0,0, sise.width, sise.height);
        // Crear componentes y añadirlos al panel
        panel.setBackground(Color.BLUE);
        JLabel label1 = new JLabel("Label 1:");
        JTextField textField1 = new JTextField(10);


        panel.add(label1);
        panel.add(textField1);

        JLabel label2 = new JLabel("Label 2:");
        JTextField textField2 = new JTextField(10);
        panel.add(label2);
        panel.add(textField2);

        // Definir constraints para los componentes
        SpringLayout layout = (SpringLayout) panel.getLayout();
        Spring xSpring = Spring.constant(5); // Espacio a la izquierda
        Spring ySpring = Spring.constant(5); // Espacio en la parte superior
        layout.putConstraint(SpringLayout.WEST, label1, xSpring, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label1, ySpring, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, textField1, xSpring, SpringLayout.EAST, label1);
        layout.putConstraint(SpringLayout.NORTH, textField1, ySpring, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, label2, xSpring, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label2, Spring.sum(ySpring, Spring.constant(label1.getPreferredSize().height)), SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, textField2, xSpring, SpringLayout.EAST, label2);
        layout.putConstraint(SpringLayout.NORTH, textField2, Spring.sum(ySpring, Spring.constant(label1.getPreferredSize().height)), SpringLayout.NORTH, panel);

        // Ajustar el tamaño preferido del panel
        SpringLayout.Constraints panelCons = layout.getConstraints(panel);
        panelCons.setConstraint(SpringLayout.EAST, xSpring);
        panelCons.setConstraint(SpringLayout.SOUTH, ySpring);

        // Añadir el panel al frame
        frame.add(panel);

        // Hacer visible el frame
        frame.setVisible(true);
    }
}
