package Grafica.controller;

import Grafica.app.gui.Paint;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonListener implements MouseListener {
    Paint p = new Paint();
    Graphics g = p.pnlCenter.getGraphics();
    private int width, heigth;

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(p.btnLine)) {
            if (p.start) {
                p.xInitial = e.getX();
                p.yInitial = e.getY();
                p.start = false;
            } else {
                p.xFinal = e.getX();
                p.yFinal = e.getY();
                g.drawLine(p.xInitial, p.yInitial, p.xFinal, p.yFinal);
                p.start = true;
            }
        } else if (e.getSource().equals(p.btnRect)) {
            if (p.start) {
                p.xInitial = e.getX();
                p.yInitial = e.getY();
                p.start = false;
            } else {
                p.xFinal = e.getX();
                p.yFinal = e.getY();
                width = Math.abs(p.xFinal - p.xInitial);
                heigth = Math.abs(p.yFinal - p.yInitial);
                g.drawOval(p.xInitial, p.yInitial, width, heigth);
                p.start = true;
            }
        } else if(e.getSource().equals(p.btnOval)) {
            if (p.start) {
                p.xInitial = e.getX();
                p.yInitial = e.getY();
                p.start = false;
            } else {
                p.xFinal = e.getX();
                p.yFinal = e.getY();
                width = Math.abs(p.xFinal - p.xInitial);
                heigth = Math.abs(p.yFinal - p.yInitial);
                g.drawOval(p.xInitial, p.yInitial, width, heigth);
                p.start = true;
            }
        } else if (e.getSource().equals(p.btnClear)) {
            p.pnlCenter.removeAll();
            p.pnlCenter.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}