public class EnglishRuler {
    public static void drawRuler(int inches, int majorLength) {
        drawLine(majorLength, 0);

        for (int i = 1; i <= inches; i++) {
            drawIntervals(majorLength - 1);
            drawLine(majorLength, i);
        }
    }

    private static void drawIntervals(int centralLength) {
        if (centralLength > 0) {
            drawIntervals(centralLength - 1);
            drawLine(centralLength);
            drawIntervals(centralLength - 1);
        }
    }

    private static void drawLine(int tickLength) {
        drawLine(tickLength, -1);
    }

    private static void drawLine(int tickLength, int label) {
        for (int i = 0; i < tickLength; i++) {
            System.out.print("-");
        }

        if (label >= 0) {
            System.out.print(label);
        }

        System.out.print("\");
    }
}