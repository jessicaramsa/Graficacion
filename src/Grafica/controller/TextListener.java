package controller;

import app.gui.Paint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class TextListener implements MouseMotionListener {
    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        Paint p = new Paint();
        p.txtX.setText(Integer.toString(e.getX()));
        p.txtY.setText(Integer.toString(e.getY()));
    }
}
