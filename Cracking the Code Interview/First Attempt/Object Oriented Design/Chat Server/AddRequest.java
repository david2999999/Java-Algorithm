package ObjectOrientedDesign.ChatServer;

import java.util.Date;

public class AddRequest {
    private User fromUser;
    private User toUser;
    private Date date;
    RequestStatus status;

    public AddRequest(User fromUser, User toUser, Date date) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.date = date;
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
