package Graphics2D;

import java.awt.Color;
import javax.swing.JFrame;

public class Figuras2 {
    public static void main(String args[]) {
        JFrame marco = new JFrame("Dibujo de figuras en 2D");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Figuras2JPanel figuras2JPanel = new Figuras2JPanel();
        marco.add(figuras2JPanel);
        marco.setBackground(Color.WHITE);
        marco.setSize(400, 400);
        marco.setVisible(true);
    }
}
