public class SquaringTechnique {
    public static double power(double x, int n) {
        if (n == 0) return 1;
        
        double partial = power (x, n / 2);
        double result = partial * partial;
        
        if (n % 2 == 1) 
            result * x;
            
        return result;
    }
}