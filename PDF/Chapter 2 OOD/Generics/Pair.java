public class Pair<A, B> {
    A first;
    B second;
    
    public Pair(A a, B b) {
        first = a;
        second = b;
    }
    
    public A getFirst( ) { return first; }
    public B getSecond( ) { return second;}
}