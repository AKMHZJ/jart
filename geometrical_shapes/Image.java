package geometrical_shapes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Image implements Displayable {
   private final BufferedImage canvas;

   public Image(int width, int height) {
      this.canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
     
   }

   public int getWidth() {
      return canvas.getWidth();
   }

   public int getHeight() {
      return canvas.getHeight();
   }

   @Override
   public void display(int x, int y, Color color) {
      if (x < 0 || y < 0 || x >= canvas.getWidth() || y >= canvas.getHeight())
         return;
      canvas.setRGB(x, y, color.getRGB());
   }

   @Override
   public void save(String path) {
      try {
         String format = "png";
         int dot = path.lastIndexOf('.');
         if (dot > 0 && dot < path.length() - 1)
            format = path.substring(dot + 1);
         ImageIO.write(canvas, format, new File(path));
      } catch (Exception e) {
         throw new RuntimeException("Failed to save image: " + e.getMessage(), e);
      }
   }
}
