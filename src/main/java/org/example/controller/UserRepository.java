package org.example.controller;

import org.example.model.UserModel;
import org.example.utils.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements Repository<UserModel>{
    private Statement statement;
    private Connector connector;
    private ResultSet resultSet;

    public UserRepository() {
        this.connector = null;
        this.statement = null;
        this.resultSet = null;
    }


    private Connector connect() throws SQLException {
        return Connector.getConnector();
    }


    @Override
    public List<UserModel> findAll() {
        List<UserModel> users = new ArrayList<>();
        try {
            this.statement = this.connect().getConnection().createStatement();
            this.resultSet = this.statement.executeQuery("SELECT * FROM users");
            while (this.resultSet.next()){
                UserModel user = new UserModel(
                        this.resultSet.getString("id"),
                        this.resultSet.getString("name"),
                        this.resultSet.getString("lastName"),
                        this.resultSet.getString("address"),
                        this.resultSet.getString("phone"),
                        this.resultSet.getString("email"),
                        this.resultSet.getDate("birthDate"),
                        this.resultSet.getString("gender"),
                        this.resultSet.getString("createdAt")
                );
                users.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Failed to get users from database.");
        }
        return users;
    }

    @Override
    public UserModel findById(String id) {
        UserModel user = null;

        try {
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement preparedStatement = this.connect().getConnection().prepareStatement(query);
            this.resultSet = preparedStatement.executeQuery();
            if (this.resultSet.next()){
                user = new UserModel(
                        this.resultSet.getString("id"),
                        this.resultSet.getString("name"),
                        this.resultSet.getString("lastName"),
                        this.resultSet.getString("address"),
                        this.resultSet.getString("phone"),
                        this.resultSet.getString("email"),
                        this.resultSet.getDate("birthDate"),
                        this.resultSet.getString("gender"),
                        this.resultSet.getString("createdAt"));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Failed to get user from database.");
        }
        return user;
    }

    @Override
    public void save(UserModel data) {
        try {
            String query = "INSERT INTO users (id, name, lastName, address, phone, email, birthDate, gender, createdAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = this.connect().getConnection().prepareStatement(query);

            statement.setString(1, data.getId());
            statement.setString(2, data.getName());
            statement.setString(3, data.getLastName());
            statement.setString(4, data.getAddress());
            statement.setString(5, data.getPhone());
            statement.setString(6, data.getEmail());
            statement.setDate(7, new java.sql.Date(data.getBirthDate().getTime()));
            statement.setString(8, data.getGender());
            statement.setString(9, data.getCreatedAt());

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Failed to save user to database.");
        }
    }

    @Override
    public void update(String id, UserModel userModel) {

    }

    @Override
    public void delete(String id) {
        try {
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement statement = this.connect().getConnection().prepareStatement(query);
            statement.setString(1, id);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Failed to delete user from database.");
        }
    }
}
