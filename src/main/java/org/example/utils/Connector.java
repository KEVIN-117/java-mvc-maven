package org.example.utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class Connector {
    private String dbUser;
    private String dbPassword;
    private String dbName;
    private String dbHost = "localhost";
    private Integer dbPort = 5432;
    private String uri = "";

    private static Connector connector;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private Connector(String dbUser, String dbPassword, String dbName, String dbHost, Integer dbPort) {
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        this.dbName = dbName;
        this.dbHost = dbHost;
        this.dbPort = dbPort;
        this.uri = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;
        this.connection = null;
        this.statement = null;
        this.resultSet = null;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbHost() {
        return dbHost;
    }

    public void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }

    public Integer getDbPort() {
        return dbPort;
    }

    public void setDbPort(Integer dbPort) {
        this.dbPort = dbPort;
    }

    public static Connector getConnector() {
        return connector;
    }

    public static void setConnector(Connector connector) {
        Connector.connector = connector;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public void connect(){
        try {
            this.connection = DriverManager.getConnection(this.uri, this.dbUser, this.dbPassword);
            System.out.println("Connected to the PostgreSQL server successfully.");
            this.statement = this.connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error in connection");
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }

    public static Connector getInstance() throws SQLException {
        Dotenv dotenv = Dotenv.load();
        String dbUser = dotenv.get("DB_USER");
        String dbPassword = dotenv.get("DB_PASSWORD");
        String dbName = dotenv.get("DB_NAME");
        if (connector == null) {
            connector = new Connector(dbUser, dbPassword, dbName, "localhost", 5432);
        }
        return connector;
    }
}
