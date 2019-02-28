public class TestHanoiTowers {
    public static void main(String[] args) {
        HanoiTowers(3, 'A', 'B', 'C');
    }
    
    public static void HanoiTowers(int n, char x, char y, char z) {
        if (n==1) { // basis
            System.out.printf("Move top disk from peg %c to peg %c.%n", x, z);
        } else {
            HanoiTowers(n-1, x, z, y); // recursion
            HanoiTowers(1, x, y, z); // recursion
            HanoiTowers(n-1, y, x, z); // recursion
        }
    }
}