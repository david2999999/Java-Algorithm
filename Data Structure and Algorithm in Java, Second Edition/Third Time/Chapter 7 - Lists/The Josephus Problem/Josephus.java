public class Josephus {
    public static final int SOLDIERS = 8;
    public static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Ring<String> ring = new Ring<>();

        for (int i = 0; i < SOLDIERS; i++) {
            ring.add(ALPHA.substring(i, i + 1));
        }

        System.out.println(ring);

        Iterator<String> it = ring.iterator();
        String killer = it.next();

        while (ring.size() > 1) {
            String victim = it.next();
            System.out.println(killer + " killed " + victim);
            it.remove();
            killer = it.next();
        }

        System.out.println("Lone Survivor = " + killer);
    }
}