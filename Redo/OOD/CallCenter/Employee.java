package Redo.OOD.CallCenter;

import ObjectOrientedDesign.CallCenter.Rank;

public class Employee {
    private Call currentCall = null;
    protected Rank rank;

    public Employee() {}

    public void receiveCall(Call call) {}

    public void answerCall(String msg) {}

    public void completeCall() {}

    public void escalateAndReassign() {}

    public boolean assignNewCall(Call call) {return true;}

    public boolean isAvaiable() {return true;}

    public Rank getRank() {
        return rank;
    }
}
