package ObjectOrientedDesign.CallCenter;

import java.util.List;

public class CallHandler {
    private final int LEVELS = 3;

    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGERS = 4;
    private final int NUM_DIRECTORS = 2;

    List<List<Employee>> employeeLevels;
    List<List<Call>> callQueues;

    public CallHandler() { }

    public Employee getEmployeeForCall(Call call) {
        return new Respondent(this);
    }

    public void dispatchCall(Caller caller) {
        Call call = new Call(caller);
        dispatchCall(call);
    }


    public void dispatchCall(Call call) {
        Employee employee = getEmployeeForCall(call);
        if (employee != null) {
            employee.recieveCall(call);
            call.setHandler(employee);
        } else {
            call.reply("Please wait for free employee to reply");
            callQueues.get(call.getRank().getValue()).add(call);
        }
    }
}
