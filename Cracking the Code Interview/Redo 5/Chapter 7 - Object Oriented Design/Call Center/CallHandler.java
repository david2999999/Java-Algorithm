public class CallHandler {
    private final int LEVELS = 3;

    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGERS = 4;
    private final int NUM_DIRECTORS = 2;

    List<List<Employee>> employeeLevels;

    List<List<Call>> callQueues;

    public CallHandler() { }

    public Employee getHandlerForCall(Call call) { }

    public void dispatchCall(Caller caller) {
        Call call = new Call(caller);
        dispatchCall(call);
    }

    public void dispatchCall(Call call) {
        Employee emp = getHandlerForCall(call);
        if (emp != nUll) {
            emp.receiveCall(call);
            call.setHandler(emp);
        } else {
            call.reply("Please wait for free employee to reply");
            caIIQueues.get(call.getRank().getvalue().add(call);
        }
    }

    public boolean assignCall(Employee emp) { }
}