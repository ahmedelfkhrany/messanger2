/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger.DatabaseLayer;

import messenger.utility.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import messenger.ModelLayer.Message;

/**
 *
 * @author AL MASRIA 4 COMP
 */
public class MessageMySqlRepository extends MessageRepository {

    Statement statement;

    public MessageMySqlRepository(MySQLConnector connector) {
        this.statement = connector.getStatement();
    }

    @Override
    public void addMessage(Message message) {
        /*
        String insertQuery = "INSERT INTO message(id,body,senderId,receiverId) VALUES ('" + message.getId() + "','" + message.getBody()
        + "' , '" + message.getSenderId() + "' ,'" + message.getReceiverId() + "' )";
        
        statement.executeUpdate(insertQuery);*/
        
        this.addMessage(message.getId(), message.getBody(), message.getSenderId(), message.getReceiverId());

    }

    @Override
    public void addMessage(String id, String body, String senderId, String receiverId) {
        try {

            String insertQuery = "INSERT INTO message(id,body,senderId,receiverId) VALUES ('" + id + "','" + body + "','" + senderId + "','" + receiverId + "')";

            statement.executeUpdate(insertQuery);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteMessage(String id) {
        try {
            String deleteQuery = "DELETE FROM message WHERE id = '" + id + "' ";
            statement.executeUpdate(deleteQuery);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Message> getMessageBetweenUsers(String firstUser, String secondUser) {
        ArrayList<Message> msgs = new ArrayList<Message>();
        ResultSet messagesResultSet;
        try {

            messagesResultSet = statement.executeQuery("SELECT * FROM message where (senderId = '" + firstUser + "' and ReceiverId ='" + secondUser + "') or (senderId = '" + secondUser + "' and ReceiverId ='" + firstUser + "')");
            while (messagesResultSet.next()) {
                String id = messagesResultSet.getString(1);
                String body = messagesResultSet.getString(2);
                String SenderId = messagesResultSet.getString(3);
                String ReceiverId = messagesResultSet.getString(4);
                Message message = new Message(id, body, SenderId, ReceiverId);
                msgs.add(message);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return msgs;
    }

    @Override
    public ArrayList<Message> getMessageByUserId(String userId) {
        ArrayList<Message> msgs = new ArrayList<Message>();
        ResultSet messagesResultSet;
        try {

            messagesResultSet = statement.executeQuery("SELECT * FROM message where (senderId = '" + userId + "' or ReceiverId ='" + userId + "')");
            while (messagesResultSet.next()) {
                String id = messagesResultSet.getString(1);
                String body = messagesResultSet.getString(2);
                String SenderId = messagesResultSet.getString(3);
                String ReceiverId = messagesResultSet.getString(4);
                Message message = new Message(id, body, SenderId, ReceiverId);
                msgs.add(message);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return msgs;
    }

}
