package Chapter2;

import java.util.ArrayList;
import java.util.List;

public class IntentionalRevealingNames {
    private List<int[]> theList;

    public List<int[]> geThem() {
        List<int[]> list1 = new ArrayList<>();
        for(int[] x : theList) {
            if (x[0] == 4)
                list1.add(x);
        }

        return list1;
    }

}
