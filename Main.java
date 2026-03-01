import geometrical_shapes.*;

public class Main {
   public static void main(String[] args) {
      Image image = new Image(1000, 1000);
      Rectangle rectangle = new Rectangle(new Point(150, 300), new Point(50, 60));
      rectangle.draw(image);
     
      Line line =new Line(new Point(50, 50), new Point(30, 50)); 
      line.draw(image);

      Point point =new Point(100, 100); 
      point.draw(image);

      Triangle triangle = new Triangle(new Point(500, 500), new Point(250, 700), new Point(700, 800));
      triangle.draw(image);
     
      for (int i = 0; i < 50; i++) {
         Circle circle = Circle.random(image.getWidth(), image.getHeight());
         circle.draw(image);
      }
      Pentagon pentagon1 = new Pentagon(new Point(200, 500), 80);
        pentagon1.draw(image);

        Pentagon pentagon2 = new Pentagon(new Point(500, 500), 90, 36);
        pentagon2.draw(image);

        Cube cube1 = new Cube(new Point(750, 200), 100, 30, 45, 0);
        cube1.draw(image);

        Cube cube2 = new Cube(new Point(750, 500), 80, 60, 30, 15);
        cube2.draw(image);

        for (int i = 0; i < 1; i++) {
            Pentagon randomPentagon = Pentagon.random(image.getWidth(), image.getHeight());
            randomPentagon.draw(image);
        }

        for (int i = 0; i < 2; i++) {
            Cube randomCube = Cube.random(image.getWidth(), image.getHeight());
            randomCube.draw(image);
        }
      image.save("image.png");   
      System.out.println("Saved image.png");
   }
}
