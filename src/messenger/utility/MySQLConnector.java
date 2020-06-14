/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger.utility;

import java.sql.*;

/**
 *
 *
 */
public class MySQLConnector {
    
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    public MySQLConnector() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/messenger", "root", "");
            statement = connection.createStatement();
            System.out.println("sql connection succeed");

            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception ex) {
            System.out.print("Connection failed with: " + ex.getMessage());
        }

    }
   // this.PreparedStatement = connection.

    public Statement getStatement() {
        return statement;
    }
;
}
