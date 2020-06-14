/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger.DatabaseLayer;

import messenger.utility.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import messenger.ModelLayer.Message;
import messenger.ModelLayer.User;

/**
 *
 *
 */
public class UserMySqlRepository extends UserRepository {

    Statement statement;

    public UserMySqlRepository(MySQLConnector connector) {

        this.statement = connector.getStatement();
    }

    public void addUser(User user) {
        try {
            // String insertQuery = "INSERT INTO user(id,name) VALUES ('? ,?')";
            //  PreparedStatement prepareInsertStatement = connector.prepareStatement(insertQuery);
            String insertQuery = "INSERT INTO user(id,name) VALUES ('" + user.getId() + "','" + user.getName() + "')";
            statement.executeUpdate(insertQuery);

            System.out.println("users my sql repo succeed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addUser(String id, String name) {
        try {
            //  String insertQuery = "INSERT INTO user(id,name) VALUES ('? ,?')";
            String insertQuery = "INSERT INTO user(id,name) VALUES ('" + id + "','" + name + "')";
            statement.executeUpdate(insertQuery);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteUser(String id) {

        try {
            String insertQuery = "delete from user where id ='" + id + "'";
            statement.executeUpdate(insertQuery);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void getUserById(String id) {

        try {

            ResultSet messagesResultSet = statement.executeQuery("select * from user where id='" + id + "'");
            while (messagesResultSet.next()) {
                String _id = messagesResultSet.getString(1);
                String _body = messagesResultSet.getString(2);

                System.out.println("Id =" + _id);
                System.out.println("Name=" + _body);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void getAllUsers() {
        try {
        
            ResultSet usersResultSet = statement.executeQuery("select * from user");
            while (usersResultSet.next()) {
                String id = usersResultSet.getString(1);
                String name = usersResultSet.getString(2);
                System.out.println("id=" + id);
                System.out.println("name=" + name);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
