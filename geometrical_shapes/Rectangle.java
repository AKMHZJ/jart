package geometrical_shapes;

import java.awt.Color;

public class Rectangle implements Drawable {
   private final Point p1; // one corner
   private final Point p2; // opposite corner
   private final Color color;

   public Rectangle(Point p1, Point p2) {
      this(p1, p2, Color.WHITE);
   }

   public Rectangle(Point p1, Point p2, Color color) {
      if (p1 == null || p2 == null)
         throw new IllegalArgumentException("Points cannot be null");
      if (p1 == p2)
         throw new IllegalArgumentException("Points must be different objects");
      this.p1 = p1;
      this.p2 = p2;
      this.color = color;
   }

   @Override
   public void draw(Displayable d) {
      Point a = new Point(Math.min(p1.getX(), p2.getX()), Math.min(p1.getY(), p2.getY()), color);
      Point c = new Point(Math.max(p1.getX(), p2.getX()), Math.max(p1.getY(), p2.getY()), color);
      Point b = new Point(c.getX(), a.getY(), color);
      Point dpt = new Point(a.getX(), c.getY(), color);

      new Line(a, b, color).draw(d);
      new Line(b, c, color).draw(d);
      new Line(c, dpt, color).draw(d);
      new Line(dpt, a, color).draw(d);
   }

   @Override
   public Color getColor() {
      return color;
   }
}
