package RecursionAndDynamicProgramming;

public class PaintFill {
    private enum Color {Black, White, Red, Yello, Green}

    private boolean fillColor(Color[][] screen, int r, int c, Color nColor) {
        if (screen[r][c] == nColor) {
            return false;
        } else {
            return fillColor(screen, r , c, screen[r][c], nColor);
        }
    }

    private boolean fillColor(Color[][] screen, int r, int c, Color oColor, Color nColor) {
        if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) return false;

        if (screen[r][c] == oColor) {
            screen[r][c] = nColor;
            fillColor(screen, r - 1, c, oColor, nColor);
            fillColor(screen, r + 1, c, oColor, nColor);
            fillColor(screen, r, c - 1, oColor, nColor);
            fillColor(screen, r, c + 1, oColor, nColor);
        }

        return true;
    }
}
