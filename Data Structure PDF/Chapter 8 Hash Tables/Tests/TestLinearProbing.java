 public class TestLinearProbing {
     private static final int MASK = 0x7FFFFFFF; // 2^32-1
     private static final int CAPACITY = 11;
     private static int size = 0;
     private static boolean[] used = new boolean[CAPACITY];
    
     public static void main(String[] args) {
         printHash("Rad");
         printHash("Uhr");
         printHash("Ohr");
         printHash("Tor");
         printHash("Hut");
         printHash("Tag");
         printHash("Eis");
         printHash("Ast");
         printHash("Zug");
         printHash("Hof");
         printHash("Mal");
     }
    
     private static void printHash(String word) {
         System.out.printf("hash(%s) = %d, load = %d%%%n",
         word, hash(word), 100*size/CAPACITY);
     }
    
     private static int hash(Object object) {
         ++size;
         int h = (object.hashCode() & MASK) % CAPACITY;
         while (used[h]) {
             System.out.printf("%d, ", h);
             h = (h+1)%CAPACITY;
         }
         used[h] = true;
         return h;
     }
 }