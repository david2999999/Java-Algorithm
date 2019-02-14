public interface Fraction {
    Fraction plus(Fraction x);
    Fraction times(int n);
    Fraction times(Fraction x);
    Fraction reciprocal();
    double value();
}