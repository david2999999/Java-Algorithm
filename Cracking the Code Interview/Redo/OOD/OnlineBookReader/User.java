package Redo.OOD.OnlineBookReader;

public class User {
    private int userId;
    private String detail;
    private int accountType;

    public void renewMemberShip() {}

    public User(int userId, String detail, int accountType) {
        this.userId = userId;
        this.detail = detail;
        this.accountType = accountType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }
}
