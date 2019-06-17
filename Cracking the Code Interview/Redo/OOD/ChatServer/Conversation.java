package Redo.OOD.ChatServer;

import java.util.ArrayList;

public abstract class Conversation {
    protected ArrayList<User> participants;
    protected ArrayList<Message> messages;
    protected int id;

    public void addMessage(Message msg) {
        if (msg == null) return;

        this.messages.add(msg);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public int getId() {
        return id;
    }
}
