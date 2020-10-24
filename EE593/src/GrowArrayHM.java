
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


/**
 * @author Donglin Chen
 */
public class GrowArrayHM {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new FileReader("EE593\\convexhullpoints.dat"));
        double maxX = 0, minX = 1, maxY = 0, minY = 1, tempX = 0, tempY = 0;
        int n = 8;
        while (s.hasNext()) {
            tempX = s.nextDouble();
            if (tempX > maxX)
                maxX = tempX;
            else if (tempX < minX)
                minX = tempX;
            tempY = s.nextDouble();
            if (tempY > maxY)
                maxY = tempY;
            else if (tempY < minY)
                minY = tempY;
        }
        System.out.println("maxX=" + maxX);
        System.out.println("minX=" + minX);
        System.out.println("maxY=" + maxY);
        System.out.println("minY=" + minY);
        PointGrowList[][] pgla = new PointGrowList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                pgla[i][j] = new PointGrowList();
        }
        Scanner s2 = new Scanner(new FileReader("EE593\\convexhullpoints.dat"));
        while (s2.hasNext()) {
            tempX = s2.nextDouble();
            tempY = s2.nextDouble();
            Point p = new Point(tempX, tempY);
            int x = (int) ((p.y - minY) * n / (maxY - minY));
            int y = (int) ((p.x - minX) * n / (maxX - minX));
            //System.out.println(x+" "+y);
            if (x == n)
                x--;
            if (y == n)
                y--;
            //System.out.println(x+" "+y);
            pgla[y][x].add(p);
        }
        for (int i = 0; i < n; i++) {
            System.out.print("pgla[" + i + "][" + 0 + "]: ");
            System.out.println(pgla[i][0]);
        }
        for (int i = 1; i < n; i++) {
            System.out.print("pgla[" + 7 + "][" + i + "]: ");
            System.out.println(pgla[7][i]);
        }
        for (int i = 1; i < n; i++) {
            System.out.print("pgla[" + 0 + "][" + i + "]: ");
            System.out.println(pgla[0][i]);
        }
        for (int i = 1; i < n - 1; i++) {
            System.out.print("pgla[" + i + "][" + 7 + "]: ");
            System.out.println(pgla[i][7]);
        }
    }
}

class PointGrowList {//点数列
    Point[] p;
    int used;

    public PointGrowList() {
        p = new Point[1];
        used = 0;
    }

    public void add(Point v) {
        if (used >= p.length) {
            Point[] old = p;
            p = new Point[old.length * 2];
            for (int i = 0; i < old.length; i++)
                p[i] = old[i];
        }
        p[used] = v;
        used = used + 1;
    }

    public void addStart(Point v) {
        if (used >= p.length) {
            Point[] old = p;
            p = new Point[old.length * 2];
            for (int i = 0; i < old.length; i++)
                p[i + 1] = old[i];
            p[0] = v;
            used = used + 1;
        } else {
            Point[] old = p;
            for (int i = 0; i < old.length; i++)
                p[i + 1] = old[i];
            p[0] = v;
            used = used + 1;
        }
    }

    public void remove() {
        Point[] old = p;
        used = used - 1;
        p = new Point[used];
        for (int i = 0; i < used; i++)
            p[i] = old[i];
    }

    public void removeStart() {
        Point[] old = p;
        p = new Point[used - 1];
        for (int i = 0; i < used + 1; i++)
            p[i] = old[i + 1];
        used = used - 1;
    }

    public Point get(int i) {
        return p[i];
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder(used * 10);
        for (int i = 0; i < used; i++)
            b.append(p[i]).append(' ');
        return b.toString();
    }
}

class Point {//点的定义
    double x;
    double y;

    public Point() {
        this(0, 0);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
