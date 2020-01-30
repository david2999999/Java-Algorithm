public class Ratio implements Comparable {
    private int numerator;
    private int denominator;

    public int compareTo(Object object) {
        if (object == this) {
            return 0;
        } else if (!(object instanceof Ratio)) {
            throw new IllegalArgumentException("Ratio type expected");
        }

        Ratio that = (Ratio) object;
        normalize(this);
        normalize(that);
        return this.numerator * that.denominator - this.denominator * that.numerator;
    }

    private void normalize(Ratio ratio) {
        if (ratio.numerator == 0) {
            ratio.denominator = 0;
        } else if (ratio.denominator < 0) {
            ratio.numerator *= -1;
            ratio.denominator *= -1;
        }
    }
}