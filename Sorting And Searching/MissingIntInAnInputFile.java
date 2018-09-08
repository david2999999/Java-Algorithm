package SortingAndSearching;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MissingIntInAnInputFile {
    long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
    byte[] bitfield = new byte[(int) (numberOfInts / 8)];
    String fileName = "FileName";

    private void findNumber() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(fileName));
        while (in.hasNextInt()) {
            int n = in.nextInt();
            bitfield[n/2] |= 1 << (n % 8);
        }

        for (int i = 0; i < bitfield.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((bitfield[i] & (1 << j)) == 0) {
                    System.out.println(i * 8 + j);
                    return;
                }
            }
        }
    }
}
