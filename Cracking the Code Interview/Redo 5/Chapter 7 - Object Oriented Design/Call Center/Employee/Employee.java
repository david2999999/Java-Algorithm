public abstract class Employee {
    private Call currentCal1 = null;
    protected Rank rank;

    public Employee(CallHandler handler) { }

    public void receiveCall(Call call) { }

    public void caIICompleted() { }

    public void escalateAndReassign() { }

    public boolean assignNewCall() { }

    public boolean isFree() {
        return currentCal1 == null;
    }

    public Rank getRank() {
        return rank;
    }
}