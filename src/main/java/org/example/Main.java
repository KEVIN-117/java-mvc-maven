package org.example;

import org.example.utils.Connector;
import org.example.view.component.Button;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Connector connector = null;
        try {
            connector = Connector.getInstance();
            connector.connect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}