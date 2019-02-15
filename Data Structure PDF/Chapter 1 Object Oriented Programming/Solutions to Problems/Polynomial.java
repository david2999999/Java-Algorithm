public interface Polynomial {
    public int degree();
    public Polynomial derivative();
    public boolean equals(Object object);
    public Polynomial sum(Polynomial polynomial);
    public String toString();
    public double valueAt(double x);
}