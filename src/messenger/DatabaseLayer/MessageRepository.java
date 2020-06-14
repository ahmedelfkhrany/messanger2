/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger.DatabaseLayer;

import messenger.ModelLayer.Message;
import java.util.ArrayList;

public abstract class MessageRepository {

    public abstract void addMessage(Message message);

    public abstract void addMessage(String id, String body, String senderId, String receiverId);

    public abstract void deleteMessage(String id);

    public abstract ArrayList<Message> getMessageBetweenUsers(String firstUser, String secondUser);
    

    public abstract ArrayList<Message> getMessageByUserId(String userId);
}
