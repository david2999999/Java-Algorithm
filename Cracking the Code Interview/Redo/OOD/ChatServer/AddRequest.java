package Redo.OOD.ChatServer;

import java.util.Date;

public class AddRequest {
    private User fromUser;
    private User toUser;
    private Date date;
    private RequestStatus status;

    public AddRequest(User fromUser, User toUser) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.date = new Date();
        this.status = RequestStatus.UNREAD;
    }

    public User getFromUser() {
        return fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public Date getDate() {
        return date;
    }

    public RequestStatus getStatus() {
        return status;
    }
}
