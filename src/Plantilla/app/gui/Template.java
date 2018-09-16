package Plantilla.app.gui;

import javax.swing.JFrame;

public class Template extends JFrame {
    private int cont = 0;

    public Template() {
        super("Template");
        properties();
        build();
        setVisible(true);
    }

    private void properties() {
        setSize(500, 500);
        setDefaultCloseOperation(3);
        setLayout(null);
        setLocationRelativeTo(null);
    }

    private void build() {}

    public static void main(String[] a) {
        Template test = new Template();
    }
}
