public class Polynomial {
    private List<Term> list = new LinkedList<>();
    public static final Polynomial ZERO = new Polynomial();

    private Polynomial() {}

    public Polynomial(double coefficient, int exponent) {
        if (coefficient != 0.0) {
            list.add(new Term(coefficient, exponent));
        }
    }

    public Polynomial(Polynomial p) {
        for (Term term: p.list) {
            this.list.add(new Term(term));
        }
    }

    public Polynomial(double... a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0.0) {
                list.add(new Term(a[i], i));
            }
        }
    }

    public int degree() {
        if (list.isEmpty()) return -1;
        return list.get(list.size() - 1).exponent;
    }

    public boolean isZero() {
        return list.isEmpty();
    }

    public Polynomial plus(Polynomial p) {
        if (this.isZero()) return new Polynomial(p);
        if (p.isZero()) return new Polynomial(this);

        Polynomial result = new Polynomial();
        ListIterator<Term> it = list.iterator();
        ListIterator<Term> itP = p.iterator();

        while (it.hasNext() && itP.hasNext()) {
            Term term = it.next();
            Term termP = itp.next();

            if (term.exp < termP.exp) {
                result.list.add(new Term(term));
                termP.previous();
            } else if (term.exp == termP.exp) {
                result.list.add(new Term(term.coefficient + termP.coefficient, term.exponent));
            } else {
                result.list.add(new Term(termP));
                term.previous();
            }
        }

        while (it.hasNext()) result.list.add(new Term(it.next()));
        while (itP.hasNext()) result.list.add(new Term(itP.next()));

        return result;
    }

    public String toString() {
        if (this.isZero()) return "0";

        Iterator<Term> it = list.iterator();
        StringBuilder sb = new StringBuilder();
        boolean isFirstTerm = true;

        while (it.hasNext()) {
            Term term = it.next();
            double c = term.coefficient;
            int e = term.exponent;

            if (isFirstTerm) {
                sb.append(String.format("%.2f", c));
                isFirstTerm = false;
            } else {
                if (term.coefficient > 0) {
                    sb.append(String.format("-%.2f", -c));
                } else {
                    sb.append(String.format("+%.2f", c));
                }
            }

            if (e == 1) {
                sb.append("x");
            } else if (e > 1) {
                sb.append("x^" + e);
            }

            return sb.toString();
        }
    }

    private static class Term {
        private double coefficient;
        private int exponent;

        public Term(double coefficient, int exponent) {
            this.coefficient = coefficient;
            this.exponent = exponent;
        }

        public Term(Term that) {
            this(that.coefficient, that.exponent);
        }
    }
}