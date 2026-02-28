package geometrical_shapes;


import java.util.Random;
import java.awt.Color;

public class Circle implements Drawable {

   private int radius;
   private Point center;
   private Color color;

 

   public Circle(int radius, Point point) {
      this.radius = radius;
      center = point;
      this.color = getColor();
   }

   public static Circle random(int width, int height) {
      Random random = new Random();
      int radius = random.nextInt(1, width);
      Point center = Point.random(width, height);
      return new Circle(radius, center);

   }

   public void draw(Displayable displayable) {
      double perimter = 2 * Math.PI * this.radius;
      double steps = 2 * Math.PI / perimter;
      double i = 0;
      while (i <= 2 * Math.PI) {
         int x = (int) (this.center.x + (this.radius * Math.cos(i)));
         int y = (int) (this.center.y + (this.radius * Math.sin(i)));
         i += steps;
         displayable.display(x, y, this.color);
      }
   }

   

}
