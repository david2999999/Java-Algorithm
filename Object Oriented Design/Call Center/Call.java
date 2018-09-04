package ObjectOrientedDesign.CallCenter;

public class Call {
    private Rank rank;
    private Caller caller;
    private Employee Handler;

    public Call(Caller caller) {
        this.rank = Rank.Responder;
        this.caller = caller;
    }

    public void setHandler(Employee handler) {
        Handler = handler;
    }

    public void reply(String message) {}

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Rank incrementRank() {
        if (this.rank == Rank.Responder) {
            return Rank.Manager;
        } else if (this.rank == Rank.Manager) {
            return Rank.Director;
        } else {
            return Rank.Responder;
        }
    }

    public void disconnect() {}
}
