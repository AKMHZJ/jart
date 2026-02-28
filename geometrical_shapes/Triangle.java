package geometrical_shapes;

import java.awt.Color;

public class Triangle implements Drawable {
   private final Point p1, p2, p3;
   private final Color color;

   public Triangle(Point p1, Point p2, Point p3) {
      this(p1, p2, p3, Color.RED);
   }

   public Triangle(Point p1, Point p2, Point p3, Color color) {
      if (p1 == null || p2 == null || p3 == null)
         throw new IllegalArgumentException("Points cannot be null");
      if (p1 == p2 || p2 == p3 || p1 == p3)
         throw new IllegalArgumentException("Points must be different objects");
      this.p1 = p1;
      this.p2 = p2;
      this.p3 = p3;
      this.color = color;
   }

   @Override
   public void draw(Displayable d) {
      new Line(p1, p2, color).draw(d);
      new Line(p2, p3, color).draw(d);
      new Line(p3, p1, color).draw(d);
   }

   @Override
   public Color getColor() {
      return color;
   }
}
