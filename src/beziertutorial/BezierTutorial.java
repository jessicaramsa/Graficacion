
package beziertutorial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Simple aplicación para el dibujado de una curva de Bezier.
 * 
 * @author Jesús Serrato
 */
public class BezierTutorial {

    private JFrame frame;
    private JPanel panel;
    private JButton botonDibujar;
    private JButton botonBorrar;
    private JToolBar barra;
    private JSpinner spinner;
    private SpinnerModel model;
    private ArrayList<Point> puntos;

    /**
     * Constructor de la clase sin argumentos
     */
    public BezierTutorial() {
        
        puntos = new ArrayList<>();
        inicializarComponentes();
        
    }
    
    /**
     * Método para el inicializado de la GUI.
     */
    public void inicializarComponentes() {
    
        this.frame = new JFrame("Curvas de Bezier");
        frame.getContentPane().setLayout(new BorderLayout());    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mousePressed(MouseEvent e) {
                        
                        panel.getGraphics().fillOval(e.getX() - 5, e.getY() - 5, 10, 10);
                        puntos.add(new Point(e.getX(), e.getY()));
                        
                    }
        
                }
                
        );
        
        model = new SpinnerNumberModel(200, 1, 1000, 10);
        
        spinner = new JSpinner(model);
                       
        botonBorrar = new JButton("Borrar");
        botonBorrar.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        panel.repaint();
                        puntos.clear();
                        
                    }
        
                }
        );
        
        this.botonDibujar = new JButton("Dibujar");
        this.botonDibujar.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        dibujarBezier(panel.getGraphics(), puntos, (int) model.getValue());
                        puntos.clear();

                    }
        
                }
        );
        
        this.barra = new JToolBar();
        
        barra.add(botonBorrar);
        barra.add(botonDibujar);
        barra.add(spinner);
        
        frame.add(barra, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);        
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        new BezierTutorial();
        
    }
    
    /**
     * Método para el dibujado de una curva de Bezier.
     * 
     * @param g - objeto graphics para el dibujado en pantalla
     * @param puntos - los puntos de control capturados para el dibujado de la curva
     * @param numeroPuntos - El número de puntos que componen a la curva (a mayor número la curva tiene mayor calidad pero requiere mayor procesamiento)
     */
    public void dibujarBezier(Graphics g, ArrayList<Point> puntos, int numeroPuntos) {
        
        //Variables para almacenar el punto calculado
        double puntoX = 0, puntoY = 0;      
        //En esta lista se guardan los puntos anteriores que nos sirven para poder 
        //dibujar las líneas que van de punto a punto
        ArrayList<int[]> anteriores = new ArrayList<>();
        double avance = 1 / ((double) numeroPuntos);
        int tamLista = puntos.size();
        
        //Este ciclo realiza el número de iteraciones que el usuario desee en base 
        //al número de puntos que se desean
        for (double u = 0; u <= 1; u += avance) {   
            //Este ciclo itera sobre los puntos a dibujar y realiza el cálculo del siguiente punto de la curva
            for (int k = 0; k < tamLista; k++) {
                double b = calcularB(u, tamLista - 1, k);
                puntoX += puntos.get(k).getX() * b;
                puntoY += puntos.get(k).getY() * b;
            }

            //Se almacenan y se dibuja el punto calculado anteriormente
            anteriores.add(new int[] {(int)puntoX, (int) puntoY});           
            g.drawLine((int) puntoX, (int) puntoY, (int) puntoX, (int) puntoY);
            
            //Se dibuja la línea que va del punto anterior al recien calculado
            //de esa manera no tenemos que calcular punto por punto de toda la curva
            if (anteriores.size() > 1) {
                g.drawLine(anteriores.get(anteriores.size() - 2)[0], anteriores.get(anteriores.size() - 2)[1], (int) puntoX, (int) puntoY);
                //Removemos el primer elemento que ya no se utiliza
                anteriores.remove(0);
            }
            
            //Borramos los valores anteriores para la siguiente iteración
            puntoX = puntoY = 0;
        }
        
        //Se dibuja el último trayecto de la curva
        g.drawLine((int) anteriores.get(anteriores.size() - 1)[0], (int) anteriores.get(anteriores.size() - 1)[1], 
                (int) puntos.get(tamLista - 1).getX(), (int) puntos.get(tamLista - 1).getY());
        
    }
    
    /**
     * Método para el calculo de B que es la k-ésima función de combinación para 
     * n + 1 puntos de control.
     * 
     * @param u - número de la iteración actual
     * @param n - número de puntos de control
     * @param k - número del punto actual
     * 
     * @return b
     */
    private double calcularB(double u, int n, int k) {
        
        return (factorial(n) / (factorial(k) * factorial(n - k))) * 
                Math.pow(u, k) * Math.pow(1 - u, n - k);
        
    }
    
    /**
     * Método para el cálculo del factorial de un número.
     * 
     * @param n - número del cual se desa conocer el factorial
     * 
     * @return factorial de n
     */
    private double factorial(int n) {
    
        double factorial = 1;
        
        if (n == 0 || n == 1) 
            return factorial;
        else {
            for (int i = 2; i <= n; i++) {
                factorial *= i; 
            }

            return factorial;        
        }
                
    }
    
}
