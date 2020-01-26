public class CatchingException {
    private static final int DEFAULT = 1;

    public static void main(String[] args) {
        int n = DEFAULT;

        try {
            n = Integer.parseInt(args[0]);
            if (n <= 0) {
                System.out.println("n must be positive, Using Default");
                n = DEFAULT;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No arguments specified for n. Using defaults.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer argument. Using default");
        }
    }
}