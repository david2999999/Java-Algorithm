package ObjectOrientedDesign.ChatServer;

public class PrivateChat extends Conversation{
    private User user1;
    private User user2;

    public PrivateChat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public User getOtherParticipant(User user) {
        return user == user1 ? user2 : user1;
    }
}
