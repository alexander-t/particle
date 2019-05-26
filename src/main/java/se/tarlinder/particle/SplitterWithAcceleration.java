package se.tarlinder.particle;

import se.tarlinder.particle.splitter.SplitterSystem;
import se.tarlinder.particle.swing.ViewPort;

import javax.swing.*;
import java.awt.*;

public class SplitterWithAcceleration extends JFrame {

    private static final int MS_PER_FRAME = 16;

    public static void main(String[] args) {
        new SplitterWithAcceleration();
    }

    private SplitterWithAcceleration() {
        SplitterSystem splitterSystem = new SplitterSystem();
        ViewPort viewPort = new ViewPort(splitterSystem);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(400, 400));
        setVisible(true);
        getContentPane().add(viewPort);

        new Thread(() -> {
            while (true) {
                long startTime = System.currentTimeMillis();

                splitterSystem.update();
                viewPort.update();

                try {
                    Thread.sleep(Math.max(startTime + MS_PER_FRAME - System.currentTimeMillis(), 0));
                } catch (InterruptedException ignored) {
                }
            }
        }).start();

    }
}
