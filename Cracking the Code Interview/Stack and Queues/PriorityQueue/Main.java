package PriorityQueue;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Patient> patients = new PriorityQueue<Patient>();

        Patient dav = new Patient("dav", 0);
        Patient tim = new Patient("tim", 1);
        Patient josh = new Patient("josh", 2);
        Patient kim = new Patient("kim", 3);
        Patient simon = new Patient("simon", 4);
        Patient Lou = new Patient("Lou", 2);
        Patient Que = new Patient("Que", 2);

        patients.add(dav);
        patients.add(tim);
        patients.add(josh);
        patients.add(kim);
        patients.add(simon);
        patients.add(Lou);
        patients.add(Que);

        printQueue(patients);
    }

    private static void printQueue(PriorityQueue<Patient> queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.poll().getName());
        }
    }
}
