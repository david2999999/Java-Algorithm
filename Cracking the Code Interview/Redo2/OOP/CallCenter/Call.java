package OOP.CallCenter;

public class Call {
    private Rank rank;

    private Caller caller;

    private Employee handler;

    public Call(Caller caller) {
        this.caller = caller;
        rank = Rank.Responder;
    }

    public void setHandler(Employee handler) {
        this.handler = handler;
    }

    public void reply(String message) {}

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Rank incrementRank() {
        return rank;
    }

    public void disconnect() {}
}
