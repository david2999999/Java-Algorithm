import java.lang.Math; // headers MUST be above the first class
import java.util.*;

public class ReversingArrayOfCharacterString{

     public static void main(String []args){
        char[] characters = {'a', 'b', 'c', ' ', 'h', 'a', 'w', 
            ' ', 'a', 'o', 'i'};
            
        String str = new String(characters);
        
        String[] reversed = reverse(str.split(" "));
        
        ArrayList<Character> finalList = new ArrayList<>();
        
        for (int i = 0; i < reversed.length; i++) {
            String currentString = reversed[i];
            
            for (int j = 0; j < currentString.length(); j++) {
                finalList.add(currentString.charAt(j));
            }
            
            finalList.add(' ');
        }
        
       for (char c: finalList) {
       	System.out.print(c);
       }
     }
     
     public static String[] reverse(String[] x) {

        String[] d = new String[x.length];
    
    
        for (int i = 0; i < x.length; i++) {
            d[i] = x[x.length - 1 -i];
        }
        return d;
    }
}