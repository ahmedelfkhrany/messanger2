
package messenger.DatabaseLayer;

import java.util.ArrayList;
import messenger.ModelLayer.Message;

/**
 *
 */
public class MessageArrayListRepository extends MessageRepository {

    ArrayList<Message> messages = new ArrayList<Message>();

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void addMessage(String id, String body, String senderId, String receiverId) {
        messages.add(new Message(id, body, senderId, receiverId));
    }

    public void deleteMessage(String id) {
        for (int i = 0; i < messages.size(); i++) {

            Message msg = messages.get(i);
            String msgId = msg.getId();

            Boolean equalId = id == msgId;

            if (equalId) {
                messages.remove(i);
            }
        }

    }

    public ArrayList<Message> getMessageBetweenUsers(String me, String theOtherUser) {
        ArrayList<Message> msgs = new ArrayList<Message>();

        for (int i = 0; i < messages.size(); i++) {

            Message msg = messages.get(i);

            if ((msg.getSenderId() == me && msg.getReceiverId() == theOtherUser)
                    || (msg.getReceiverId() == me && msg.getSenderId() == theOtherUser) // (msg.senderId == senderId || msg.senderId == receiverId) &&
                    // (msg.receiverId == senderId || msg.receiverId == receiverId) &&
                    // (msg.senderId != msg.receiverId)
                    ) {
                msgs.add(msg);
            }

        }

        return msgs;
    }

    public ArrayList<Message> getMessageByUserId(String userId) {
        ArrayList<Message> msgs = new ArrayList<Message>();

        for (int i = 0; i < messages.size(); i++) {

            Message msg = messages.get(i);
            String senId = msg.getSenderId();
            String recId = msg.getReceiverId();

            if (userId == senId || userId == recId) {
                msgs.add(msg);
            }

        }
        return msgs;
    }

    @Override
    public String toString() {
        String fullString = "";
        for (Message message : messages) {
            fullString += message + "\n";
        }
        return fullString;
    }

}
