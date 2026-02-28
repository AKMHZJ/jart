package geometrical_shapes;

import java.awt.Color;
import java.util.Random;

public interface Drawable {
   void draw(Displayable displayable);

   default Color getColor() {
      Random random = new Random();
      int r = random.nextInt(256);
      int g = random.nextInt(256);
      int b = random.nextInt(256);

      return new Color(r, g, b);
   }
}
