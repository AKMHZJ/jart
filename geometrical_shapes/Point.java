package geometrical_shapes;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

public class Point implements Drawable {
   public final int x;
   public final int y;
   private final Color color;

   public Point(int x, int y) {
      this(x, y, Color.WHITE);
   }

   public Point(int x, int y, Color color) {
      this.x = x;
      this.y = y;
      this.color = color;
   }

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y;
   }

   @Override
   public void draw(Displayable d) {
      d.display(x, y, color);
   }

   @Override
   public Color getColor() {
      return color;
   }

   public static Point random(int maxWidth, int maxHeight) {
      ThreadLocalRandom r = ThreadLocalRandom.current();
      return new Point(r.nextInt(maxWidth), r.nextInt(maxHeight),
            new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
   }
}
