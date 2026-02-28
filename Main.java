import geometrical_shapes.*;

public class Main {
   public static void main(String[] args) {
      Image image = new Image(1000, 1000);
      Rectangle rectangle = new Rectangle(new Point(50, 50), new Point(300, 200));
      rectangle.draw(image);
     
      Line line =new Line(new Point(50, 50), new Point(30, 50)); 
      line.draw(image);

      Triangle triangle = new Triangle(new Point(100, 100), new Point(900, 900), new Point(100, 900));
      triangle.draw(image);
      Pentagon pentagon = new Pentagon(
            new Point(500, 100),
            new Point(600, 150),
            new Point(570, 250),
            new Point(430, 250),
            new Point(400, 150));
      pentagon.draw(image);

      for (int i = 0; i < 50; i++) {
         Circle circle = Circle.random(image.getWidth(), image.getHeight());
         circle.draw(image);
      }
      image.save("image.png");
      System.out.println("Saved image.png");
   }
}
