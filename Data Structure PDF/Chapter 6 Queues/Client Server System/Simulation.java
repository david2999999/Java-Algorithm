 public class Simulation {
     private static final int SERVERS = 3;
     private static final int CLIENTS = 20;
     private static final double MEAN_SERVICE_TIME = 25;
     private static final double MEAN_ARRIVAL_TIME = 4;
     private static Queue<Client> queue = new ArrayDeque<Client>();
     private static ExpRandom randomService = new ExpRandom(MEAN_SERVICE_TIME);
     private static ExpRandom randomArrival = new ExpRandom(MEAN_ARRIVAL_TIME);
     private static Server[] servers = new Server[SERVERS];
     private static Client[] clients = new Client[CLIENTS];
    
     public Simulation() {
         String fmt = "%-27s %6d%n";
         System.out.printf(fmt, "Number of servers:", SERVERS);
         System.out.printf(fmt, "Number of clients:", CLIENTS);
         System.out.printf(fmt, "Mean service time:", MEAN_SERVICE_TIME);
         System.out.printf(fmt, "Mean interarrival time:", MEAN_ARRIVAL_TIME);
         
         for (int i=0; i<SERVERS; i++) {
             double meanServiceTime = randomService.nextDouble();
             servers[i] = new Server(i, meanServiceTime);
             System.out.printf("Mean service time for %s: %4.1f%n",
             servers[i], servers[i].getMeanServiceTime());
         }
         int nextArrivalTime = 0;
         for (int t=0, clientId=0; clientId < CLIENTS; t++) {
             if (t == nextArrivalTime) {
                 nextArrivalTime = t + randomArrival.nextInt();
                 Client client = clients[clientId] = new Client(++clientId, t);
                 queue.add(client);
                 System.out.println("\tClient queue: " + queue);
             }
             for (Server server : servers) {
                 if (t == server.getStopTime()) {
                    server.stopServing(t);
                 }
                 if (server.isIdle() && !queue.isEmpty()) {
                     Client client = (Client)queue.remove();
                     System.out.println("\tClient queue: " + queue);
                     server.startServing(client,t);
                 }
             }
         }
     }
    
     public static void main(String[] args) {
        new Simulation();
     }
 }