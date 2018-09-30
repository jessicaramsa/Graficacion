package CurvaBezier.model;

import java.awt.Point;
import java.util.ArrayList;

public class Bezier {
    public ArrayList<Point> bezier(ArrayList<Point> p, float t) {
        float x = 0.0f, y = 0.0f;
        int grade = p.size();
        ArrayList<Point> b;

        for (int i = 0; i <= 1.0; i += t) {
            x += p.get(0).x * Math.pow(1 - i, grade);
            y += p.get(0).y * Math.pow(1 - i, grade);
            for (int j = 1; j <= grade; j++) {
                x += grade * p.get(j).x * Math.pow(1 - i, grade - 1) * grade;
                y += grade * p.get(j).y * Math.pow(1 - i, grade -1) * grade;
            }
            x += p.get(grade).x * Math.pow(t, grade);
            y += p.get(grade).y * Math.pow(t, grade);
            b.add(new Point(x, y));
        }
        return b;
    }
}
