package Redo.OOD.ChatServer;

import java.util.ArrayList;

public class GroupChat extends Conversation {
    public GroupChat(ArrayList<User> participants) {
        this.participants = participants;
    }

    public boolean removeParticipant(User user) {
        return this.participants.remove(user);
    }

    public boolean addUser(User user) {
        return this.participants.add(user);
    }
}
