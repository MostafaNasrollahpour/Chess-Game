package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DraggableButtonExample extends JPanel {

    private JButton draggableButton;
    private JLabel label1, label2;
    private Point dragOffset;

    public DraggableButtonExample() {
        setLayout(null);

        draggableButton = new JButton("Drag Me");
        draggableButton.setBounds(100, 100, 100, 30);
        add(draggableButton);

        label1 = new JLabel("Label 1");
        label1.setBounds(50, 200, 100, 30);
        add(label1);

        label2 = new JLabel("Label 2");
        label2.setBounds(250, 200, 100, 30);
        add(label2);

        draggableButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dragOffset = new Point(e.getX(), e.getY());
            }
        });

        draggableButton.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int newX = e.getXOnScreen() - dragOffset.x;
                int newY = e.getYOnScreen() - dragOffset.y;
                draggableButton.setLocation(newX, newY);
                repaint();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Draggable Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DraggableButtonExample());
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DraggableButtonExample::createAndShowGUI);
    }
}
