package Grafica.app.gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Grafica.controller.ButtonListener;
import Grafica.controller.TextListener;

public class Paint extends JFrame {
    public JButton btnLine, btnRect, btnOval, btnClear;
    public JPanel pnlCenter, pnlEast, pnlWest, pnlSouth;
    public JTextField txtX, txtY;
    private JLabel lblX, lblY;
    private BorderLayout borderLayout;
    public int xInitial, xFinal, yInitial, yFinal;
    public boolean start;
    public int mode;
    
    public Paint() {
        super("Paint");
        btnLine = new JButton("Recta");
        btnRect = new JButton("Rectangulo");
        btnOval = new JButton("Ovalo");
        btnClear = new JButton("Limpiar");
        pnlCenter = new JPanel();
        pnlEast = new JPanel();
        pnlWest = new JPanel();
        pnlSouth = new JPanel();
        txtX = new JTextField();
        txtY = new JTextField();
        lblX = new JLabel("X");
        lblY = new JLabel("Y");
        borderLayout = new BorderLayout();
        start = true;

        properties();
        build();
        //listeners();
        setVisible(true);
    }
    
    public void properties() {
        this.setSize(500, 500);
        this.setDefaultCloseOperation(3);
        this.setLayout(borderLayout);

        // bounds
    }

    public void build() {
        this.add(pnlEast, BorderLayout.EAST);
        this.add(pnlCenter, BorderLayout.CENTER);
        this.add(pnlWest, BorderLayout.WEST);
        this.add(pnlSouth, BorderLayout.SOUTH);
        pnlEast.add(btnLine);
        pnlEast.add(btnRect);
        pnlEast.add(btnOval);
        pnlWest.add(btnClear);
        pnlSouth.add(lblX);
        pnlSouth.add(lblY);
        pnlSouth.add(txtX);
        pnlSouth.add(txtY);
    }

    public void listeners() {
        ButtonListener buttonListener = new ButtonListener();
        btnLine.addMouseListener(buttonListener);
        btnRect.addMouseListener(buttonListener);
        btnOval.addMouseListener(buttonListener);

        TextListener textListener = new TextListener();
        txtX.addMouseMotionListener(textListener);
        txtY.addMouseMotionListener(textListener);
    }

    public static void main(String[] args) {
        Paint test = new Paint();
    }
}
