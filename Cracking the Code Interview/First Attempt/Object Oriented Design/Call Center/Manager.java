package ObjectOrientedDesign.CallCenter;

public class Manager extends Employee{
    public Manager(CallHandler callHandler) {
        super(callHandler);
        rank = Rank.Manager;
    }
}
