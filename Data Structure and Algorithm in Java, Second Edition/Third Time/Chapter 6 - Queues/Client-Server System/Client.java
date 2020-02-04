public class Client {
    private int id;
    private int startTime;

    public Client(int id, int time) {
        this.id = id;
        System.out.printf("%s arrived at time %d.%n", this, time);
    }

    public void setStartTime(int time) {
        startTime = time;
    }

    public String toString() {
        return "#" + id;
    }
}