package se.tarlinder.particle.swing;

import se.tarlinder.particle.splitter.SplitterSystem;

import javax.swing.*;
import java.awt.*;

public class ViewPort extends JPanel {

    private SplitterSystem splitterSystem;

    public ViewPort(SplitterSystem splitterSystem) {
        this.splitterSystem = splitterSystem;
    }

    public void update() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        splitterSystem.particles.forEach(particle -> {
            int x = (int) (particle.position.x * getWidth());
            int y = (int) (particle.position.y * getHeight());
            g.setColor(new Color(1f, 1f, 1f, particle.getAlpha()));
            g.fillOval(x, y, 8, 8);
        });
    }
}
