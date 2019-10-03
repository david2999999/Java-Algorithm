package RecursionAndDynamicProgramming;

// give a screen represented by a two dimensional array of colors, a point, and a new color,
// fill the surrounding area until the color changes from the original color
public class PaintFill {
    private enum Color {
        Black, White, Red, Yellow, Green
    }

    // params
    // 2D color array, row, color, new color
    public boolean paintFill(Color[][] screen, int r, int c, Color nColor) {
        if (screen[r][c] == nColor) return false;   // if the current pixel is already the new color
        return paintFill(screen, r , c, screen[r][c], nColor);
    }

    // oColor = old color
    private boolean paintFill(Color[][] screen, int r, int c, Color oColor, Color nColor) {
        if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) {    // index out of bound
            return false;   // not inside the screen
        }

        if (screen[r][c] == oColor) {   // if the current pixel is the old color
            screen[r][c] = nColor;  // give the current pixel a new color
            paintFill(screen, r - 1, c, oColor, nColor);    // fill paint upward
            paintFill(screen, r + 1, c, oColor, nColor);    // fill paint downward
            paintFill(screen, r, c - 1, oColor, nColor);    // fill paint left
            paintFill(screen, r, c + 1, oColor, nColor);    // fill paint right
        }

        return true;    // current pixel is filled with the new color
    }
}
















