package OOP.CallCenter;

public class Respondent extends Employee{

    public Respondent(CallHandler handler) {
        super(handler);
        rank = Rank.Responder;
    }
}
