public class MyPolynomial implements Polynomial {
    private double[] c; // coefficients
    
    public MyPolynomial(double[] a) { // a[i] = coeffficient of x^i
        int n = c.length;
        c = new double[n];
        System.arraycopy(a, 0, c, 0, n);
    }
    
    public int degree() {
        return c.length - 1;
    }
    
    public Polynomial derivative() {
        double da[] = new double[c.length-1];
        
        for (int i=0; i<da.length; i++) {
            da[i] = (i+1)*c[i+1];
        }
        
        return new MyPolynomial(da);
    }
    
    public boolean equals(Object object) {
        if (object==this) {
            return true;
        } else if (!(object instanceof MyPolynomial)) {
            return false;
        }
        
        MyPolynomial that = (MyPolynomial)object;
        return java.util.Arrays.equals(that.c, this.c);
    }
    
    public Polynomial sum(Polynomial p) {
        if (!(p instanceof MyPolynomial)) {
            throw new IllegalArgumentException("use a MyPolynomial object");
        }
        
        MyPolynomial that = (MyPolynomial)p;
        double[] pc = that.c;
        int n = Math.max(c.length, pc.length);
        MyPolynomial q = new MyPolynomial(new double[n]);
        
        for (int i=0; i<n; i++) {
            q.c[i] = c[i] + pc[i];
        }
        return q;
    }
    public String toString() {
        StringBuilder buf = new StringBuilder();
        int n = c.length;
        if (n > 0 && c[0] != 0.0) {
            buf.append(c[0]);
        }
        if (n > 1 && c[1] != 0.0) {
            buf.append(String.format(" + %.2f", c[1]));
        }
        for (int i=2; i<n; i++) {
            if (c[i] != 0.0) {
                buf.append(String.format(" + %.2f^%d", c[i], i));
            }
        }
        return buf.toString();
    }
    public double valueAt(double x) {
        double y = 0.0;
        
        for (int i=0; i<c.length; i++) {
            y += c[i]*Math.pow(x, i);
        }
        return y;
    }
}