package org.example.view.pages;

import org.example.view.component.Input;
import org.example.view.layout.InputArea;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Objects;

public class CreateClient extends JPanel {
    private InputArea name;
    private InputArea lastName;
    private InputArea address;

    private InputArea phone;

    private InputArea email;
    private InputArea birthDate;
    private InputArea gender;
    private JPanel panel, butonPanel;
    private JButton createButton, verificar;

    public CreateClient() {
        setLayout(new CardLayout());
        setBorder(BorderFactory.createEmptyBorder(50, 500, 50, 500));
        setBackground(new Color(0, 0, 0, 100));
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(8, 1, 10, 10));
        this.panel.setBackground(new Color(0, 0, 0, 200));

        this.butonPanel = new JPanel();
        this.butonPanel.setLayout(new GridLayout(1, 1, 10, 10));
        this.butonPanel.setBackground(new Color(74, 1, 254, 255));
        this.butonPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        this.name = new InputArea("Name", "Write your name", "");
        this.name.setBounds(10, 10, 100, 30);
        this.lastName = new InputArea("Last Name", "Write your last name", "");

        this.address = new InputArea("Address", "Write your address", "");
        this.phone = new InputArea("Phone", "Write your phone", "");
        this.email = new InputArea("Email", "Write your email", "");
        this.birthDate = new InputArea("Birth Date", "Write your birth date in the format (YYYY/MM/DD)", "");
        this.gender = new InputArea("Gender", "Write your gender (M/F)", "");

        this.createButton = new JButton("Create");
        this.createButton.setBackground(new Color(255, 255, 255, 255));

        this.verificar = new JButton("Verificar");
        this.verificar.setBackground(new Color(255, 255, 255, 255));


        this.butonPanel.add(this.verificar);


        this.verificar.addActionListener(e -> {
            Input[] fields = {name.getInput(), lastName.getInput(), address.getInput(),
                    phone.getInput(), email.getInput(), birthDate.getInput()};
            String[] fieldNames = {"Name", "Last Name", "Address", "Phone", "Email", "Birth Date"};
            StringBuilder emptyFields = new StringBuilder();
            boolean isEmpty = false;
            for (int i = 0; i < fields.length; i++) {
                String text = fields[i].getText();
                String placeholder = fields[i].getPlaceholder();
                if (text.isEmpty() || text.equals(placeholder)) {
                    isEmpty = true;
                    emptyFields.append(fieldNames[i]).append(",\n");
                }
            }
            if (!email.getInput().getText().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
                emptyFields.append("Email Invalido\n");
            }
            if (isEmpty) {
                emptyFields.delete(emptyFields.length() - 2, emptyFields.length()); // Eliminar la coma y el espacio final
                JOptionPane.showMessageDialog(null, "Por favor complete los siguientes campos: \n" + emptyFields);
            } else {
                this.butonPanel.add(this.createButton);
            }
        });

        this.panel.add(this.name.getPanel());
        this.panel.add(this.lastName.getPanel());
        this.panel.add(this.address.getPanel());
        this.panel.add(this.phone.getPanel());
        this.panel.add(this.email.getPanel());
        this.panel.add(this.birthDate.getPanel());
        this.panel.add(this.gender.getPanel());
        this.panel.add(this.butonPanel);
        add(this.panel);
    }


}
