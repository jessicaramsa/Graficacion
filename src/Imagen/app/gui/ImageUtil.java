package Imagen.app.gui;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {
    BufferedImage img;
    int[][] array;
    int alto, ancho;

    public ImageUtil(String src) {
        img = loadImage(src);
        array = bufferedToArray(img);
        alto = img.getHeight();
        ancho = img.getWidth();
    }

    public ImageUtil(BufferedImage img) {
        array = bufferedToArray(img);
        alto = img.getHeight();
        ancho = img.getWidth();
    }

    public BufferedImage canalRojo(String src) {
        Color color;
        int intensidadRed;
        int[][] arrayRed = new int[alto][ancho];

        for(int i = 0; i < alto; i++) {
            for(int j = 0; j < ancho; j++) {
                color = new Color(array[i][j]);
                intensidadRed = color.getRed();
                color = new Color(intensidadRed, intensidadRed, intensidadRed);
            }
        }

        BufferedImage imgRed = arrayToBufferedImage(arrayRed);
        return imgRed;
    }

    public BufferedImage canalVerde(String src) {
        Color color;
        int intensidadGreen;
        int[][] arrayGreen = new int[alto][ancho];

        for(int i = 0; i < alto; i++) {
            for(int j = 0; j < ancho; j++) {
                color = new Color(array[i][j]);
                intensidadGreen = color.getGreen();
                color = new Color(intensidadGreen, intensidadGreen, intensidadGreen);
            }
        }

        BufferedImage imgGreen = arrayToBufferedImage(arrayGreen);
        return imgGreen;
    }

    public BufferedImage canalAzul(String src) {
        Color color;
        int intensidadBlue;
        int[][] arrayBlue = new int[alto][ancho];

        for(int i = 0; i < alto; i++) {
            for(int j = 0; j < ancho; j++) {
                color = new Color(array[i][j]);
                intensidadBlue = color.getRed();
                color = new Color(intensidadBlue, intensidadBlue, intensidadBlue);
            }
        }

        BufferedImage imgBlue = arrayToBufferedImage(arrayBlue);
        return imgBlue;
    }

    public BufferedImage getImg() {
        return img;
    }

    public static BufferedImage loadImage(String src) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(src));
        } catch (IOException e) {
            System.err.println("Error al cargar. " + e.toString());
        }
        return img;
    }

    public static int[][] bufferedToArray(BufferedImage img) {
        int alto = img.getHeight();
        int ancho = img.getWidth();
        int[][] array = new int[alto][ancho];

        for(int i = 0; i < ancho; i++) {
            for(int j = 0; j < alto; j++) {
                array[i][j] = img.getRGB(i, j);
            }
        }

        return array;
    }

    public static BufferedImage arrayToBufferedImage(int[][] array) {
        int alto = array.length;
        int ancho = array[0].length;

        BufferedImage img = new BufferedImage(alto, ancho, 0);

        for(int i = 0; i < alto; i++) {
            for(int j = 0; j < ancho; j++) {
                img.setRGB(j, i, array[i][j]);
            }
        }

        return img;
    }

    public static void saveImage(BufferedImage img, String tipo, String file) {
        try {
            ImageIO.write(img, tipo, new File(file));
        } catch (IOException e) {
            System.err.println("Error al guardar. " + e.toString());
        }
    }
}
