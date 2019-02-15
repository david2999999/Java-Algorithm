public class RatioComparable implements Comparable {
    public int compareTo(Object object) {
        if (object==this) {
            return 0;
        } else if (!(object instanceof Ratio)) {
            throw new IllegalArgumentException("Ratio type expected");
        }
        
        Ratio that = (Ratio)object;
        normalize(this);
        normalize(that);
        return (this.num*that.den - that.num*this.den);
    }
    
    private static void normalize(Ratio x) {
        if (x.num == 0) { // x == Ratio.ZERO
            x.den = 1;
        } else if (x.den < 0) { // change sign of num and den:
            x.num *= -1;
        x.den *= -1;
        }
    }
}