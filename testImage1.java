import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class testImage1 {

    public static void main(String[] args) {
        new testImage1();
    }

    public testImage1() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage img;

        public TestPane() {
            img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
            //for (int x = 0; x < img.getWidth(); x++) {
            //    for (int y = 0; y < img.getHeight(); y++) {
            //        img.setRGB(x, y, Color.RED.getRGB());
            //    }
            //}

            Graphics2D g2d = img.createGraphics();
            g2d.setColor(Color.RED);
            g2d.fillRect(0, 0, img.getWidth(), img.getHeight());
            g2d.dispose();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawImage(img, 0, 0, this);
            g2d.dispose();
        }
    }

}