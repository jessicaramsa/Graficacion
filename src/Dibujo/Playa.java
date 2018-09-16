/*
 * Graficación 8:45
 * Dibujo con Graphics y Graphics2D
 * Ramírez Sánchez Jéssica
 */
package Dibujo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Playa extends JFrame {
    private int x, y;
    
    public Playa() {
        super("Playa");
        properties();
        setVisible(true);
    }
    
    private void properties() {
        setSize(700, 600);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        g.setColor(new Color(132, 223, 221));
        g.fillRect(0, 0, 700, 150);
        // montañas
        g.setColor(new Color(149, 121, 90));
        g.fillRect(0, 150, 700, 100);
        g.fillRect(0, 90, 300, 60);
        g.fillRect(60, 40, 200, 50);
        g.fillRect(450, 80, 250, 70);
        g.fillRect(500, 0, 200, 150);
        // playa
        g.setColor(new Color(173, 153, 135));
        g.fillRect(0, 250, 700, 150);
        // mar
        g.setColor(new Color(28, 100, 175));
        g.fillRect(0, 400, 700, 200);
        // olas
        g.fillRect(0, 360, 30, 40);
        g.fillRect(30, 380, 90, 20);
        g.fillRect(180, 370, 60, 30);
        g.fillRect(240, 385, 15, 15);
        g.fillRect(370, 390, 50, 10);
        g.fillRect(430, 370, 40, 30);
        g.fillRect(470, 385, 15, 15);
        g.fillRect(540, 380, 20, 20);
        g.fillRect(630, 390, 10, 10);
        // puntos blancos
        g.setColor(Color.WHITE);
        g.fillOval(390, 45, 5, 5);
        g.fillRect(35, 495, 5, 5);
        g.fillRect(215, 460, 5, 5);
        g.fillRect(555, 480, 5, 5);
        // sol
        g.setColor(new Color(235, 171, 52));
        g.fillOval(350, 40, 70, 70);
        g.setColor(new Color(244, 123, 8));
        g.fillOval(360, 50, 50, 50);
        // piedras
        g.setColor(new Color(156, 156, 153));
        g.fillRect(30, 220, 60, 50);
        g.fillRect(270, 130, 50, 30);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(530, 290, 60, 20);
        g.fillRect(580, 280, 30, 30);
        // arbustos
        g.setColor(new Color(63, 134, 34));
        g.fillOval(140, 235, 80, 20);
        g.fillOval(170, 250, 50, 20);
        g.fillOval(440, 140, 20, 20);
        g.fillRect(590, 295, 20, 20);
        // barco
        // base
        g.setColor(new Color(85, 72, 55));
        g.fillRect(260, 530, 10, 10);
        g.fillRect(270, 530, 30, 30);
        g.fillRect(300, 530, 100, 40);
        g.fillRect(400, 530, 30, 30);
        g.fillRect(430, 530, 10, 10);
        // bandera
        g.setColor(Color.WHITE);
        g.fillRect(300, 460, 88, 35);
        g.setColor(new Color(163, 148, 127));
        g.fillRect(390, 460, 7, 68);
    }
    
    public static void main(String[] args) {
        Playa test = new Playa();
    }
}
