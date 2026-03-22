package pro1.drawingModel;

import pro1.swingComponents.MainFrame;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class House implements Drawable {
    private int x;
    private int y;
    private int rotation;
    private MainFrame frame;

    public House(int x, int y, int rotation, MainFrame frame) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.frame = frame;
    }

    @Override
    public void draw(Graphics2D g) {
        int size = frame.optionsPanel.getHouseSize();
        boolean isRed = frame.optionsPanel.isRedColor();

        AffineTransform old = g.getTransform();

        g.translate(this.x, this.y);
        g.rotate(Math.toRadians(this.rotation));

        if (isRed) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.GRAY);
        }



        g.fillRect(-size / 2, 0, size, size);

        int[] xPoints = {-size / 2, size / 2, 0};
        int[] yPoints = {0, 0, -size / 2};
        g.fillPolygon(xPoints, yPoints, 3);

        g.setTransform(old);
    }
}