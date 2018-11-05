package Traslacion.model;

public class Movimiento {
    public double[][] rota(double angulo) {
        return new double[][]{{Math.cos(angulo), -Math.sin(angulo), 0.0},
            {Math.sin(angulo), Math.cos(angulo), 0.0},
            {0.0, 0.0, 1.0}};
    }
}
