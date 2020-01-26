public class Progression {
    protected long current;
    
    public Progression() {
        this(0);
    }
    
    public Progression(long start) {
        current = start;
    }
    
    public long nextValue() {
        long answer = current;
        advance();
        return answer;
    }
    
    protected void advance() {
        current++;
    }
    
    public void printProgression(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(nextValue());
        }
    }
}