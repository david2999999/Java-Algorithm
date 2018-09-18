package Redo.RecursionAndDynamicProgramming;

public class PaintFill {
    private enum Color {
        BLACK, WHITE, RED, YELLOW, GREEN
    }

    private boolean fillPaint(Color[][] screen, int r, int c, Color nColor) {
        if (screen[r][c] == nColor) {
            return false;
        } else {
            return fillPaint(screen, r, c, screen[r][c], nColor);
        }
    }

    private boolean fillPaint(Color[][] screen, int r, int c, Color ocolor, Color nColor) {
        if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) {
            return false;
        }

        if (screen[r][c] == ocolor) {
            screen[r][c] = nColor;
            fillPaint(screen, r + 1, c, ocolor, nColor);
            fillPaint(screen, r - 1, c, ocolor, nColor);
            fillPaint(screen, r, c + 1, ocolor, nColor);
            fillPaint(screen, r, c - 1, ocolor, nColor);
        }

        return true;
    }
}
