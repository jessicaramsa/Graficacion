package CurvaBezier.app.gui;

import CurvaBezier.app.model.PanelListener;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraficaBezier extends JFrame {
    ArrayList<Point> p = new ArrayList<Point>();
    JPanel panel;

    public GraficaBezier() {
        super("Curva de Bezier");
        panel = new JPanel();

        properties();
        build();
        listeners();
        setVisible(true);
    }

    private void properties() {
        setSize(500, 500);
        setDefaultCloseOperation(3);
        setLayout(null);
        setLocationRelativeTo(null);
    }

    private void build() {
        this.add(panel);
    }

    private void listeners() {
        panel.addMouseListener(new PanelListener());
    }

    public static void main(String[] a) {
        GraficaBezier test = new GraficaBezier();
    }
}
