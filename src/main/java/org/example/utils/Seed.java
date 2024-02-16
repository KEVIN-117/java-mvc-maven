package org.example.utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Seed {

    public static void main(String[] args) {
        // Establecer la información de conexión
        Dotenv dotenv = Dotenv.load();
        String dbUser = dotenv.get("DB_USER");
        String dbPassword = dotenv.get("DB_PASSWORD");
        String dbName = dotenv.get("DB_NAME");
        String url = "jdbc:postgresql://localhost" + ":5432/" + dbName;;

        // Establecer la conexión
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword)) {
            // Crear un objeto Statement para ejecutar comandos SQL
            try (Statement stmt = conn.createStatement()) {
                // Ejecutar comandos SQL para insertar datos (seed)
                String createTable = "CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY,\n" +
                        "    name VARCHAR(255),\n" +
                        "    lastName VARCHAR(255),\n" +
                        "    address VARCHAR(255),\n" +
                        "    phone VARCHAR(20),\n" +
                        "    email VARCHAR(255),\n" +
                        "    birthDate DATE,\n" +
                        "    gender VARCHAR(10),\n" +
                        "    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
                String sql1 = "INSERT INTO users (name, lastName, address, phone, email, birthDate, gender) VALUES ('Alice', 'Johnson', '789 Oak St', '555-9876', 'alice@example.com', '1985-10-20', 'F')";
                String sql2 = "INSERT INTO users (name, lastName, address, phone, email, birthDate, gender) VALUES ('Jane', 'Smith', '456 Elm St', '555-5678', 'jane@example.com', '1995-05-15', 'F')";
                String sql3 = "INSERT INTO users (name, lastName, address, phone, email, birthDate, gender) VALUES ('John', 'Doe', '123 Main St', '555-1234', 'john@example.com', '1990-01-01', 'M')";
                // Ejecutar los comandos SQL
                stmt.execute(createTable);
                stmt.executeUpdate(sql1);
                stmt.executeUpdate(sql2);
                stmt.executeUpdate(sql3);

                // Imprimir mensaje de éxito
                System.out.println("Seed ejecutado correctamente.");
            }
        } catch (SQLException e) {
            // Manejar cualquier excepción que pueda ocurrir durante la ejecución
            e.printStackTrace();
        }
    }
}
