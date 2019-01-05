package RecursionAndDynamicProgramming.TowerOfHanoi;

import java.util.Stack;

// The classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can
// slide onto any tower. The disks are sorted in ascending order of size from top to bottom
// 1) Only one disk can be moved at a time
// 2) A disk is slid off the top of one tower onto another tower
// 3) A disk cannot be placed on top of a smaller disk
public class Tower {
    // we will first construct the tower class for each of the 3 towers
    private Stack<Integer> disks;    // all of the disks in this tower
    private int index;              // the index of the tower, 0, 1, or 2

    public Tower(int index) {
        disks = new Stack<>();
        this.index = index;
    }

    public int index() {
        return index;
    }

    public void add(int d) {
        // if there are disks on the stack
        // and if the top of the tower is smaller than or equal to the current disk
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("error placing disk " + d);
        } else {
            disks.push(d);  // add the disk to the tower
        }
    }

    // move the top disk to another tower
    public void moveToTop(Tower t) {
        int top = disks.pop();
        t.add(top);
    }

    // move n number of disks
    public void moveDisks(int n, Tower destination, Tower buffer) {
        if (n > 0) {
            // move n - 1 disks from this tower to buffer using destination as a buffer
            moveDisks(n - 1, buffer, destination);
            moveToTop(destination); // move the largest disk to destination tower
            // move n - 1 disks from the buffer tower to the destination using this tower as a buffer
            buffer.moveDisks(n - 1, destination, this);
        }
    }
}















