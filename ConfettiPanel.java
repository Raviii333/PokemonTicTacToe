import javax.swing.*;
import java.awt.*;


class ConfettiPanel extends JPanel {
    private final java.util.List<Confetti> confettiList = new java.util.ArrayList<>();
    private final Timer timer;

    public ConfettiPanel() {
        setOpaque(false);
        for (int i = 0; i < 100; i++) {
            confettiList.add(new Confetti());
        }

        timer = new Timer(30, _ -> {
            for (Confetti c : confettiList) {
                c.y += c.speed;
                if (c.y > getHeight()) c.y = 0;
            }
            repaint();
        });
    }

    public void start() {
        setVisible(true);
        timer.start();
        // Stop after 3 seconds
        new Timer(3000, _ -> {
            timer.stop();
            setVisible(false);
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Confetti c : confettiList) {
            g.setColor(c.color);
            g.fillOval(c.x, c.y, 6, 6);
        }
    }

    private static class Confetti {
        int x = (int)(Math.random() * 450);
        int y = (int)(Math.random() * 600);
        int speed = 1 + (int)(Math.random() * 5);
        Color color = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
    }
}
