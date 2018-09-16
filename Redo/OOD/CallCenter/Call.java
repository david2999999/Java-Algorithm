package Redo.OOD.CallCenter;

import ObjectOrientedDesign.CallCenter.Rank;

public class Call {
    private Caller caller;
    private Employee handler;
    private Rank rank;

    public Call(Caller caller) {
        this.caller = caller;
        this.rank = Rank.Responder;
    }

    public void setHandler(Employee employee) {}

    public void reply(String msg) {}

    public void incrementRank() {}

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void disconnect() {}
}
