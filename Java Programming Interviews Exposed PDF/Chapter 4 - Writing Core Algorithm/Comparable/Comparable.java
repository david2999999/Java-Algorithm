// By convention, the Comparable interface is used for natural ordering
public class Comparable {
    @Test
    public void sortInts() {
        final int[] numbers = {-3, -5, 1, 7, 4, -2};
        final int[] expected = {-5, -3, -2, 1, 4, 7};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void sortObjects() {
        final String[] strings = {"z", "x", "y", "abc", "zzz", "zazzy"};
        final String[] expected = {"abc", "x", "y", "z", "zazzy", "zzz"};
        Arrays.sort(strings);
        assertArrayEquals(expected, strings);
    }

    // It is not possible to use the Collections.sort method because the compiler expects the type of the
    // parameter to be an implementation of Comparable. The method signature is:
    // public static <T extends Comparable<? super T>> void sort(List<T> list)
    private static class NotComparable {
        private int i;
        private NotComparable(final int i) {
            this.i = i;
        }
    }

    @Test
    public void sortNotComparable() {
        final List<NotComparable> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(new NotComparable(i));
        }
        try {
            Arrays.sort(objects.toArray());
        } catch (Exception e) {
            // correct behavior – cannot sort
            return;
        }
        fail();
    }
}
// The String class implements the Comparable interface, so the sorting works as you would expect.
//If the type being sorted does not implement Comparable