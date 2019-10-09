public class Triangle{
    public int triangle(int n) {
        if (n == 1) return 1;
        else {
            return n + triangle(n - 1);
        }
    }
}