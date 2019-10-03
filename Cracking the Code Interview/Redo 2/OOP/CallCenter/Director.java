package OOP.CallCenter;

public class Director extends Employee {

    public Director(CallHandler handler) {
        super(handler);
        rank = Rank.Director;
    }
}
