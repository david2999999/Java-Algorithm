package OOP.CallCenter;

public class Manager extends Employee {
    public Manager(CallHandler handler) {
        super(handler);
        rank = Rank.Manager;
    }
}
