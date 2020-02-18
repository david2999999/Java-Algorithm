public class Call {
    private Rank rank;
    private Caller caller;
    private Employee handler;

    public Call(Caller c) {
        rank = Rank.Responder;
        caller = c;
    }

    public void setHandler(Employee e) {
        handler = e;
    }

    public void reply(String message) { }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank r) {
        rank = r;
    }

    public Rank incrementRank() { }

    public void disconnect() { }
}