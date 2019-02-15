 public class TestBinarySearch {
     public static void main(String[] args) {
         int[] a = {22, 33, 44, 55, 66, 77, 88, 99};
         ch02.ex02.DuplicatingArrays.print(a);
         System.out.println("search(a, 44): " + search(a, 44));
         System.out.println("search(a, 50): " + search(a, 50));
         System.out.println("search(a, 77): " + search(a, 77));
         System.out.println("search(a, 100): " + search(a, 100));
     }
    
     public static int search(int[] a, int x) {
         // POSTCONDITIONS: returns i;
         // if i >= 0, then a[i] == x; otherwise i == -1;
         int lo = 0;
         int hi = a.length;
         
         while (lo < hi) { // step 1
             // INVARIANT: if a[j]==x then lo <= j < hi; // step 3
             int i = (lo + hi)/2; // step 4
             if (a[i] == x) {
                return i; // step 5
             } else if (a[i] < x) {
                lo = i+1; // step 6
             } else {
                hi = i; // step 7
             }
         }
         return -1; // step 2
     }
 }