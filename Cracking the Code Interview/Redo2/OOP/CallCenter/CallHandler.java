package OOP.CallCenter;

import java.util.List;

public class CallHandler {
    private final int LEVELS = 3;

    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGERS = 4;
    private final int NUM_DIRECTORS = 2;

    List<List<Call>> callQueue;

    public CallHandler() { }

    public Employee gethandlerForCall(Call call) {
        // get the first available employee to handle the call
        return new Respondent(this);
    }

    public void dispatchCall(Caller caller) {
        Call call = new Call(caller);
        dispatchCall(call);
    }

    private void dispatchCall(Call call) {
        Employee emp = gethandlerForCall(call);
        if (emp != null) {
            emp.receiveCall(call);
            call.setHandler(emp);
        } else {
            call.reply("Please wait for free employee to reply");
            callQueue.get(call.getRank().getValue()).add(call);
        }
    }
}







