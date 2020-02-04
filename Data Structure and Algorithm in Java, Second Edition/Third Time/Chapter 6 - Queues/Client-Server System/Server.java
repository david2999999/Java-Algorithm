public class Server {
    private Client client;
    private int id;
    private int stopTime = -1;
    private double meanServiceTime;
    private ExpRandom random;

    public Server(int id, double meanServiceTime) {
        this.id = id;
        this.meanServiceTime = meanServiceTime;
        this.random = new ExpRandom(meanServiceTime);
    }

    public double getMeanServiceTime() {
        return meanServiceTime;
    }

    public int getStopTime() {
        return stopTime;
    }

    public boolean isIdle() {
        return client == null;
    }

    public void startServing(Client client, int time) {
        this.client = client;
        this.client.setStartTime(time);
        this.stopTime = time + random.nextInt();
        System.out.printf("%s started serving client %s at time %d.%n",
                this, client, time);
    }

    public void stopServing(int time) {
        System.out.printf("%s stopped serving client %s at time %d.%n",
                this, client, time);
        client = null;
    }

    public String toString() {
        return "Server " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(id);
    }
}