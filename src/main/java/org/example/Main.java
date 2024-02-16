package org.example;

import org.example.utils.Connector;
import org.example.view.App;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Runnable run = () ->{
            Connector connector = null;
            try {
                connector = Connector.getInstance();
                connector.connect();
                App app = new App();
                app.setVisible(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };

        SwingUtilities.invokeLater(run);

        /*Connector connector = null;
        try {
            connector = Connector.getInstance();
            connector.connect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         */;
    }
}