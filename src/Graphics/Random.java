package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Random extends JFrame {
    int X1 = 0;
    int X2 = 500;

    public static void main(String[] args) {
        Random r = new Random();

        r.setSize(550, 550);
        r.setVisible(true);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setLayout(null);
    }

    @Override
    public void paint(Graphics p) {
        super.paint(p);

        for (int i = X1; i < X2; i += 5) {
            try {
                Thread.sleep(45);
                p.setColor(Color.CYAN);
                p.fillRect(i + 100, 175, 100, 25);

                p.setColor(Color.DARK_GRAY);
                p.fillRect(i + 100, 200, 25, 25);

                p.setColor(Color.BLACK);
                p.fillRect(i + 175, 200, 25, 25);

            } catch (InterruptedException e) {
                System.out.println("Algo va mal");
            }

            p.setColor(this.getBackground());
            p.fillRect(i, 175, 100, 25);

            p.setColor(this.getBackground());
            p.fillRect(i + 75, 200, 25, 25);

            p.setColor(this.getBackground());
            p.fillRect(i + 150, 200, 25, 25);
        }
    }
}
