package Redo.OOD.CallCenter;

import java.util.List;

public class CallHandler {
    private final int LEVELS = 3;

    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGERS = 3;
    private final int NUM_DIRECTORS = 1;

    List<List<Employee>> employeeLevels;

    List<List<Call>> callQueue;

    public CallHandler(){ }

    public Employee getHandlerForCall(Call call) {return null;}

    public void dispatchCall(Caller caller) {
        Call call = new Call(caller);
        dispatchCall(call);
    }

    public void dispatchCall(Call call) {
        Employee emp = getHandlerForCall(call);

        if (emp != null) {
            emp.receiveCall(call);
            call.setHandler(emp);
        } else {
            call.reply("Wait a moment for the next employee");
            callQueue.get(call.getRank().getValue()).add(call);
        }
    }
}
