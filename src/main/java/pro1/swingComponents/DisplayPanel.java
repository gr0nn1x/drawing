package pro1.swingComponents;

import pro1.drawingModel.Drawable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DisplayPanel extends JPanel {


    Drawable drawable = null;
    private ArrayList<Drawable> drawables = new ArrayList<>();

    public void addDrawable(Drawable drawable) {
        this.drawables.add(drawable);
        this.repaint();
    }

    public DisplayPanel() {
        this.setBackground(Color.WHITE);
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
        this.repaint();
    }

    public void clear() {
        this.drawables.clear();
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Drawable d : this.drawables) {
            d.draw(g2);
        }
    }
}