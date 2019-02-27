public class TestPolynomial {
    public static void main(String[] args) {
        Polynomial p = new Polynomial(3, -8, 0, 0, 2, 1);
        Polynomial q = new Polynomial(0, 5, 6, 9);
        System.out.println("p: " + p);
        System.out.println("p.degree(): " + p.degree());
        System.out.println("q: " + q);
        System.out.println("q.degree(): " + q.degree());
        System.out.println("p.plus(q): " + p.plus(q));
        System.out.println("q.plus(p): " + q.plus(p));
        System.out.println("p.plus(q).degree(): " + p.plus(q).degree());
        Polynomial z = new Polynomial(0);
        System.out.println("z: " + z);
        System.out.println("z.degree(): " + z.degree());
        System.out.println("p.plus(z): " + p.plus(z));
        System.out.println("z.plus(p): " + z.plus(p));
        System.out.println("p: " + p);
        Polynomial t = new Polynomial(8.88, 44);
        System.out.println("t: " + t);
        System.out.println("t.degree(): " + t.degree());
    }
}