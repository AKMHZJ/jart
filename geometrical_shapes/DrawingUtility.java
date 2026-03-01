package geometrical_shapes;

import java.awt.Color;


public class DrawingUtility {
    
    public static void drawLine(Displayable displayable, Point p1, Point p2, Color color, int maxWidth, int maxHeight) {
        int x1 = p1.getX();
        int y1 = p1.getY();
        int x2 = p2.getX();
        int y2 = p2.getY();

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            displaySafePixel(displayable, x1, y1, color, maxWidth, maxHeight);

            if (x1 == x2 && y1 == y2)
                break;

            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }

   
    public static void displaySafePixel(Displayable displayable, int x, int y, Color color, int maxWidth, int maxHeight) {
        if (x >= 0 && y >= 0 && x < maxWidth && y < maxHeight) {
            displayable.display(x, y, color);
        }
    }

    public static int[] getDimensions(Displayable displayable) {
        int width = 10000;
        int height = 10000;
        
        if (displayable instanceof Image image) {
            width = image.getWidth();
            height = image.getHeight();
        }
        
        return new int[]{width, height};
    }
}
