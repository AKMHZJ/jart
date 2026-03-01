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
      int[] dims = DrawingUtility.getDimensions(d);
      DrawingUtility.drawLine(d, a, b, color, dims[0], dims[1]);
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
      } while (p2.getX() == p1.getX() && p2.getY() == p1.getY());
      ThreadLocalRandom r = ThreadLocalRandom.current();
      Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
      return new Line(p1, p2, c);
   }
}
