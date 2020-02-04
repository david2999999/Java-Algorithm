public class Polynomial {
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