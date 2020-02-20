public class Tower {
    private Stack<Integer> disks;
    private int index;

    public Tower(int index) {
        this.disks = new Stack<>();
        this.index = index;
    }

    public int index() {
        return index;
    }

    public void add(int disk) {
        if (!disks.isEmpty() && disk.peek() <= d) {
            throw new IllegalArgumentException("Unable to place larger disk on top of smaller disk");
        } else {
            disks.push(disk);
        }
    }

    public void moveTopTo(Tower tower) {
        int top = disks.pop();
        tower.add(top);
    }

    public void moveDisks(int numOfDisk, Tower destination, Tower buffer) {
        if (numOfDisk > 0) {
            moveDisks(numOfDisk - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }
}