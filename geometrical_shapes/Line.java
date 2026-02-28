package geometrical_shapes;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

public class Line implements Drawable {
   private final Point a;
   private final Point b;
   private final Color color;

   public Line(Point a, Point b) {
      this(a, b, Color.WHITE);
   }

   public Line(Point a, Point b, Color color) {
      if (a == null || b == null)
         throw new IllegalArgumentException("Points cannot be null");
      if (a == b)
         throw new IllegalArgumentException("Points must be different objects");
      this.a = a;
      this.b = b;
      this.color = color;
   }

   @Override
   public void draw(Displayable d) {
      int x0 = a.x, y0 = a.y, x1 = b.x, y1 = b.y;
      int dx = Math.abs(x1 - x0), dy = Math.abs(y1 - y0);
      int sx = x0 < x1 ? 1 : -1;
      int sy = y0 < y1 ? 1 : -1;
      int err = dx - dy;

      while (true) {
         d.display(x0, y0, color);
         if (x0 == x1 && y0 == y1)
            break;
         int e2 = 2 * err;
         if (e2 > -dy) {
            err -= dy;
            x0 += sx;
         }
         if (e2 < dx) {
            err += dx;
            y0 += sy;
         }
      }
   }

   @Override
   public Color getColor() {
      return color;
   }

   public static Line random(int maxWidth, int maxHeight) {
      Point p1 = Point.random(maxWidth, maxHeight);
      Point p2;
      do {
         p2 = Point.random(maxWidth, maxHeight);
      } while (p2.x == p1.x && p2.y == p1.y);
      ThreadLocalRandom r = ThreadLocalRandom.current();
      Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
      return new Line(p1, p2, c);
   }
}
