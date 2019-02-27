public class Polynomial {
    private List<Term> list = new LinkedList<Term>();
    public static final Polynomial ZERO = new Polynomial();
    
    private Polynomial() { // default constructor
    }
    
    public Polynomial(double coef, int exp) {
        if (coef != 0.0) {
            list.add(new Term(coef, exp));
        }
    }
    
    public Polynomial(Polynomial p) { // copy constructor
        for (Term term : p.list) {
            this.list.add(new Term(term));
        }
    }
    
    public Polynomial(double... a) {
        for (int i=0; i<a.length; i++) {
            if (a[i] != 0.0) {
                list.add(new Term(a[i], i));
            }
        }
    }
    
    public int degree() {
        if (list.isEmpty()) {
            return -1;
        } else {
            return list.get(list.size()-1).exp;
        }
    }
    
    public boolean isZero() {
        return list.isEmpty();
    }
    
    public Polynomial plus(Polynomial p) {
        if (this.isZero()) {
            return new Polynomial(p);
        }
        if (p.isZero()) {
            return new Polynomial(this);
        }
        
        Polynomial q = new Polynomial();
        ListIterator<Term> it = list.listIterator();
        ListIterator<Term> itp = p.list.listIterator();
        while (it.hasNext() && itp.hasNext()) {
            Term term = it.next();
            Term pTerm = itp.next();
            if (term.exp < pTerm.exp) {
                q.list.add(new Term(term));
                itp.previous();
            } else if (term.exp == pTerm.exp) {
                q.list.add(new Term(term.coef + pTerm.coef, term.exp));
            } else { // (term.exp > pTerm.exp)
                q.list.add(new Term(pTerm));
                it.previous();
            }
        }
        while (it.hasNext()) {
            q.list.add(new Term(it.next()));
        }
        while (itp.hasNext()) {
            q.list.add(new Term(itp.next()));
        }
        return q;
    }
    
    public String toString() {
        if (this.isZero()) {
            return "0";
        }
        Iterator<Term> it = list.iterator();
        StringBuilder buf = new StringBuilder();
        boolean isFirstTerm = true;
        while (it.hasNext()) {
            Term term = it.next();
            double c = term.coef;
            int e = term.exp;
            if (isFirstTerm) {
                buf.append(String.format("%.2f", c));
                isFirstTerm = false;
            } else {
                if (term.coef < 0) {
                    buf.append(String.format(" - %.2f", -c));
                } else {
                    buf.append(String.format(" + %.2f", c));
                }
            }
            if (e == 1) {
                buf.append("x");
            } else if (e > 1) {
                buf.append("x^" + e);
            }
        }
        return buf.toString();
    }
    
    private static class Term {
        private double coef;
        private int exp;
        
        public Term(double coef, int exp) {
            if (coef == 0.0 || exp < 0) {
                throw new IllegalArgumentException();
            }
            this.coef = coef;
            this.exp = exp;
        }
        
        public Term(Term that) { // copy constructor
            this(that.coef, that.exp);
        }
    }
}