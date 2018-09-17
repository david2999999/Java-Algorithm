package Redo.OOD.ChatServer;

import java.util.ArrayList;

public class PrivateChat extends Conversation{
    public PrivateChat(User user1, User user2) {
        participants = new ArrayList<>();
        participants.add(user1);
        participants.add(user2);
    }

    public User getOtherUser(User primaryUser) {
        int index = participants.indexOf(primaryUser);

        if (index == 0) {
            return participants.get(1);
        } else if (index == 1){
            return participants.get(0);
        } else {
            return null;
        }
    }
}
