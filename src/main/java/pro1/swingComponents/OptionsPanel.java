package pro1.swingComponents;

import pro1.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {

    private final MainFrame parent;
    // JSlider rSlider;
    //JSlider gSlider;
    //JSlider bSlider;

    private JSlider rotationSlider;
    private JSlider sizeSlider;
    private JCheckBox colorCheckbox;

    public OptionsPanel(MainFrame parent) {
        this.parent = parent;
        this.setPreferredSize(new Dimension(200, 0));

        this.setLayout(new FlowLayout());

        this.add(new JLabel("House Rotation:"));
        this.rotationSlider = new JSlider(-180, 180, 0);
        this.add(this.rotationSlider);

        this.add(new JLabel("Size of all houses"));
        this.sizeSlider = new JSlider(10, 200, 50);
        this.add(this.sizeSlider);
        this.sizeSlider.addChangeListener((e) -> this.parent.displayPanel.repaint());

        this.colorCheckbox = new JCheckBox("Red Color");
        this.add(this.colorCheckbox);
        this.colorCheckbox.addActionListener((e) -> this.parent.displayPanel.repaint());

        JButton resetButton = new JButton("Reset");
        this.add(resetButton);
        resetButton.addActionListener((e) -> this.parent.displayPanel.clear());
    }

    public int getRotation() {
        return this.rotationSlider.getValue();
    }

    public int getHouseSize() {
        return this.sizeSlider.getValue();
    }

    public boolean isRedColor() {
        return this.colorCheckbox.isSelected();
    }
}
