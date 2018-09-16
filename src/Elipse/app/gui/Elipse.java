package Elipse.app.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;

public class Elipse extends JFrame {
    public Elipse() {
        super("Elipse");
        properties();
        setVisible(true);
    }
    
    private void properties() {
        setSize(500, 500);
        setDefaultCloseOperation(3);
        setLayout(null);
        setLocationRelativeTo(null);
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        Ellipse2D e = new Ellipse2D.Double(-100, -50, 200, 200);
        AffineTransform tr = new AffineTransform();
        tr.rotate(Math.PI / 6.0);
        Shape shape = tr.createTransformedShape(e);
        g2.translate(300, 200);
        g2.scale(2, 2);
        g2.draw(shape);
        g2.drawString("Ay", 0, 0);
    }
    
    public static void main(String[] args) {
        Elipse test = new Elipse();
    }
}
