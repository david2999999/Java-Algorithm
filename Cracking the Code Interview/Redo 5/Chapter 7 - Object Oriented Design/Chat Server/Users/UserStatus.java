public class UserStatus {
    private String message;
    private UserStatusType type;

    public UserStatus(UserStatusType type, String message) {}

    public String getMessage() {
        return message;
    }

    public UserStatusType getType() {
        return type;
    }
}