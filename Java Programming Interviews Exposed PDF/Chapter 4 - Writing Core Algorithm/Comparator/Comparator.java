public class Comparator {
    @Test
    public void customSorting() {
        final List<Integer> numbers = Arrays.asList(4, 7, 1, 6, 3, 5, 4);
        final List<Integer> expected = Arrays.asList(7, 6, 5, 4, 4, 3, 1);
        Collections.sort(numbers, new ReverseNumericalOrder());
        assertEquals(expected, numbers);
    }
}