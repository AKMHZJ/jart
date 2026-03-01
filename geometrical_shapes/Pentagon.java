package geometrical_shapes;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

public class Pentagon implements Drawable {
    private final Point center;
    private final int radius;
    private final double rotationDegrees;
    private final Color color;

    public Pentagon(Point center, int radius, double rotationDegrees) {
        this.center = center;
        this.radius = radius;
        this.rotationDegrees = rotationDegrees;
        this.color = getColor();
    }

    public Pentagon(Point center, int radius) {
        this(center, radius, -90);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void draw(Displayable displayable) {
        int[] dims = DrawingUtility.getDimensions(displayable);
        
        Point[] vertices = calculateVertices();
        
        for (int i = 0; i < 5; i++) {
            DrawingUtility.drawLine(displayable, vertices[i], vertices[(i + 1) % 5], color, dims[0], dims[1]);
        }
    }

    private Point[] calculateVertices() {
        Point[] vertices = new Point[5];
        double angleStep = 72.0;
        double startAngle = rotationDegrees;
        
        for (int i = 0; i < 5; i++) {
            double angleDegrees = startAngle + (i * angleStep);
            double angleRadians = Math.toRadians(angleDegrees);
            
            int x = (int) Math.round(center.getX() + radius * Math.cos(angleRadians));
            int y = (int) Math.round(center.getY() + radius * Math.sin(angleRadians));
            
            vertices[i] = new Point(x, y);
        }
        
        return vertices;
    }

    public static Pentagon random(int maxWidth, int maxHeight) {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        
        int x = rand.nextInt(maxWidth);
        int y = rand.nextInt(maxHeight);
        int radius = 20 + rand.nextInt(100);
        double rotation = rand.nextDouble() * 360;
        
        return new Pentagon(new Point(x, y), radius, rotation);
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public double getRotationDegrees() {
        return rotationDegrees;
    }
}
