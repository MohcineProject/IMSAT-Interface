package ui_elements ; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyButton extends JButton {

    private Color normalColor = new Color(0, 255, 0);
    private Color hoverColor = new Color(0, 200, 0);
    private Color pressedColor = new Color(0, 150, 0);

    public MyButton(String text) {
        super(text);
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setContentAreaFilled(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(normalColor);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(pressedColor);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(hoverColor);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        if (getModel().isPressed()) {
            g2d.setColor(pressedColor);
        } else if (getModel().isRollover()) {
            g2d.setColor(hoverColor);
        } else {
            g2d.setColor(normalColor);
        }

        g2d.fillRect(0, 0, getWidth(), getHeight());

        super.paintComponent(g);

        g2d.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom Button Example");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            MyButton customButton = new MyButton("Click me!");
            customButton.setMaximumSize(new Dimension(30,30)) ;
            
            frame.add(customButton);

            frame.setVisible(true);
        });
    }
}
