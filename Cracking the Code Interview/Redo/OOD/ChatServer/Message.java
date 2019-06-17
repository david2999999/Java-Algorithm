package Redo.OOD.ChatServer;

import java.util.Date;

public class Message {
    private String content;
    private Date date;

    public Message(String content) {
        this.content = content;
        this.date = new Date();
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }
}
