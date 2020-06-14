/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger.ApplicationLayer;

import messenger.utility.MySQLConnector;
import messenger.DatabaseLayer.UserRepository;
import messenger.DatabaseLayer.MessageRepository;
import messenger.ModelLayer.User;
import messenger.ModelLayer.Message;
import java.util.ArrayList;
import java.sql.*;
import messenger.DatabaseLayer.MessageMySqlRepository;
import messenger.DatabaseLayer.UserMySqlRepository;
import messenger.DatabaseLayer.UserArraylistRepository;
import messenger.DatabaseLayer.MessageArrayListRepository;

/**
 *
 * @author nozom4
 */
public class Messenger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            MySQLConnector connector = new MySQLConnector();
            UserMySqlRepository repo = new UserMySqlRepository(connector);
            UserArraylistRepository users = new UserArraylistRepository();
            MessageMySqlRepository repos = new MessageMySqlRepository(connector);
            MessageArrayListRepository messages = new MessageArrayListRepository();

            /*finaaaaaaaaaaaaaaaaaaaaaaaaaaaal*/
            User amr = new User("19", "amr");
            repo.addUser(amr);
            // repo.addUser("17", "khaled");
            //User mos3ad = new User("16", "mos3ad");
            //users.addUser(mos3ad);
            // users.addUser("20", "mostafa");
            //System.out.println(users.toString());
            Message message1 = new Message("12", "test 5", "1", "1");
            repos.addMessage(message1);
            // repos.addMessage("1", "from sender 4 ", "4", "2");
            //  repos.deleteMessage("7");
            //repos.addMessage("3", "job done", "1", "3");
            /*  ArrayList<Message> chat = repos.getMessageBetweenUsers("1", "1");
            for (int i = 0; i < chat.size(); i++) {
                System.out.println(chat.get(i));
             */
 /*  ArrayList<Message> mychat = repos.getMessageByUserId("1");
            for (int i = 0; i < mychat.size(); i++) {
                System.out.println(mychat.get(i));
            }*/
 /*
            messages.addMessage("1", "hello", "1", "2");
            messages.addMessage("2", "hi", "2", "1");
            messages.addMessage("3", "hello third user", "1", "3");
            messages.addMessage("4", "hello first user", "3", "1");
            Message message = new Message("5", "hello there", "4", "1");
            messages.addMessage(message);
            System.out.println(messages.toString());
            // messages.deleteMessage("5");
            ArrayList<Message> firstAndSecondUserMsgs = messages.getMessageBetweenUsers("1", "2");
            System.out.println(firstAndSecondUserMsgs);
            ArrayList<Message> firstUserMsgs = messages.getMessageByUserId("1");
            System.out.println(firstUserMsgs);
             */
            repo.getUserById("1");
            repo.getAllUsers();

        } catch (Exception e) {
            System.err.println("ERROR:");
            System.out.println(e.getMessage());
        }

    }
}
