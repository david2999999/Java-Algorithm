public class Consumer extends Thread {
    private IntBuffer buffer;

    public Consumer( IntBuffer buffer ){
        this.buffer = buffer;
    }

    public void run(){
        while ( true ){
            int num = buffer.remove();
            System.out.println( "Consumed " + num );
        }
    }
}