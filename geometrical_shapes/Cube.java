package geometrical_shapes;

import java.awt.Color;

public class Cube implements Drawable {
    private final Point center;
    private final int size;
    private final double rotationX;
    private final double rotationY;
    private final double rotationZ;
    private final Color color;

    public Cube(Point center, int size, double rotationX, double rotationY, double rotationZ) {
        this.center = center;
        this.size = size;
        this.rotationX = rotationX;
        this.rotationY = rotationY;
        this.rotationZ = rotationZ;
        this.color = getColor();
    }

    public Cube(Point center, int size) {
        this(center, size, 30, 45, 0);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void draw(Displayable displayable) {
        int[] dims = DrawingUtility.getDimensions(displayable);
        int maxWidth = dims[0];
        int maxHeight = dims[1];

        Point[] vertices = calculateVertices();

        DrawingUtility.drawLine(displayable, vertices[0], vertices[1], color, maxWidth, maxHeight);
        DrawingUtility.drawLine(displayable, vertices[1], vertices[2], color, maxWidth, maxHeight);
        DrawingUtility.drawLine(displayable, vertices[2], vertices[3], color, maxWidth, maxHeight);
        DrawingUtility.drawLine(displayable, vertices[3], vertices[0], color, maxWidth, maxHeight);

        DrawingUtility.drawLine(displayable, vertices[4], vertices[5], color, maxWidth, maxHeight);
        DrawingUtility.drawLine(displayable, vertices[5], vertices[6], color, maxWidth, maxHeight);
        DrawingUtility.drawLine(displayable, vertices[6], vertices[7], color, maxWidth, maxHeight);
        DrawingUtility.drawLine(displayable, vertices[7], vertices[4], color, maxWidth, maxHeight);

        DrawingUtility.drawLine(displayable, vertices[0], vertices[4], color, maxWidth, maxHeight);
        DrawingUtility.drawLine(displayable, vertices[1], vertices[5], color, maxWidth, maxHeight);
        DrawingUtility.drawLine(displayable, vertices[2], vertices[6], color, maxWidth, maxHeight);
        DrawingUtility.drawLine(displayable, vertices[3], vertices[7], color, maxWidth, maxHeight);
    }

    private Point[] calculateVertices() {
        Point[] vertices = new Point[8];
        double half = size / 2.0;

        double[][] cubePoints = {
            {-half, -half, -half},
            {half, -half, -half},
            {half, half, -half},
            {-half, half, -half},
            {-half, -half, half},
            {half, -half, half},
            {half, half, half},
            {-half, half, half}
        };

        double radX = Math.toRadians(rotationX);
        double radY = Math.toRadians(rotationY);
        double radZ = Math.toRadians(rotationZ);

        double cosX = Math.cos(radX);
        double sinX = Math.sin(radX);
        double cosY = Math.cos(radY);
        double sinY = Math.sin(radY);
        double cosZ = Math.cos(radZ);
        double sinZ = Math.sin(radZ);

        for (int i = 0; i < 8; i++) {
            double x = cubePoints[i][0];
            double y = cubePoints[i][1];
            double z = cubePoints[i][2];

            double tempY = y * cosX - z * sinX;
            double tempZ = y * sinX + z * cosX;
            y = tempY;
            z = tempZ;

            double tempX = x * cosY + z * sinY;
            tempZ = -x * sinY + z * cosY;
            x = tempX;
            z = tempZ;

            tempX = x * cosZ - y * sinZ;
            tempY = x * sinZ + y * cosZ;
            x = tempX;
            y = tempY;

            int screenX = (int) Math.round(center.getX() + x);
            int screenY = (int) Math.round(center.getY() + y);

            vertices[i] = new Point(screenX, screenY);
        }

        return vertices;
    }

    public static Cube random(int maxWidth, int maxHeight) {
        java.util.Random rand = new java.util.Random();

        int x = rand.nextInt(maxWidth);
        int y = rand.nextInt(maxHeight);
        int size = 30 + rand.nextInt(100);
        double rotX = rand.nextDouble() * 360;
        double rotY = rand.nextDouble() * 360;
        double rotZ = rand.nextDouble() * 360;

        return new Cube(new Point(x, y), size, rotX, rotY, rotZ);
    }

    public Point getCenter() {
        return center;
    }

    public int getSize() {
        return size;
    }

    public double getRotationX() {
        return rotationX;
    }

    public double getRotationY() {
        return rotationY;
    }

    public double getRotationZ() {
        return rotationZ;
    }
}
