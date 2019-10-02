public class IntBuffer {
    private int index;
    private int[] buffer = new int[8];

    public synchronized void add( int num ){
        while ( index == buffer.length ){
            try {
                wait();
            }
            catch( InterruptedException e ){
            }
        }
        buffer[index++] = num;
        notifyAll();
    }

    public synchronized int remove(){
        while ( index == 0 ){
            try {
                wait();
            }
            catch( InterruptedException e ){
            }
        }
        int ret = buffer[--index];
        notifyAll();
        return ret;
    }
}