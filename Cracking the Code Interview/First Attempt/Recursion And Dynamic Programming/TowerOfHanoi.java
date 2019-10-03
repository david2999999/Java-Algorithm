package RecursionAndDynamicProgramming;

import java.util.Stack;

public class TowerOfHanoi {
    public static void main(String[] args) {

        Tower[] towers = new Tower[3];
        for (int i = 0; i < towers.length; i++) {
            towers[i] = new Tower(i);
        }

        for (int i = 4; i >= 0; i--) {
            towers[0].add(i);
        }

        towers[0].moveDisks(towers.length, towers[2], towers[1]);

    }

    private static class Tower{
        private int index;
        private Stack<Integer> disks;

        public Tower(int index) {
            this.index = index;
            this.disks = new Stack<>();
        }

        public int index() {
            return index;
        }

        public void add(int d) {
            if (!disks.isEmpty() && disks.peek() <= d) {
                System.out.println("Not allowed to place disk");
            } else {
                this.disks.push(d);
            }
        }

        public void moveTopTo(Tower t) {
            int top = disks.pop();
            t.add(top);
        }

        public void moveDisks(int n, Tower destination, Tower buffer) {
            if (n > 0) {
                moveDisks(n - 1, buffer, destination);
                moveTopTo(destination);
                buffer.moveDisks(n - 1, destination, this);
            }
        }


    }
}
