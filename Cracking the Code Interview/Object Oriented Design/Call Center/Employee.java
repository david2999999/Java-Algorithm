package ObjectOrientedDesign.CallCenter;

abstract class Employee {
    private Call currentCall = null;
    protected Rank rank;

    public Employee(CallHandler callHandler) { }

    // start the conversation
    public void recieveCall(Call call) {}

    // the issue is resolved, finisht eh call
    public void callComplete() {}

    // the issue has not been resolved. Escalate the call, and assign a new call to the employee
    public void escalateAndReassign() { };

    // assign a new call to an employee, if the employee is free
    public boolean assignNewCall() {
        return true;
    }

    public boolean isFree() {
        return currentCall == null;
    }

    public Rank getRank() {
        return rank;
    }
}
