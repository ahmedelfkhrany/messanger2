/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger.ModelLayer;


public class Message {
    String id;
    String body;
    String senderId;
    String receiverId;

    public Message(String id, String body, String senderId, String receiverId) {
        this.id = id;
        this.body = body;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }
     
    public String toString() {
        return "id = " + id + " and body is " + body + " and sender id is " + senderId + " and receiver id is " + receiverId;
    } 
    
}
