import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Donglin Chen
 */
public class Game_Weiqi extends JFrame {
    private void buildMenus() {//设置置顶菜单
        JMenuBar mb = new JMenuBar();
        JMenu m = new JMenu("File");
        JMenuItem mi = new JMenuItem("New");
        m.add(mi);
        mi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello");
            }
        });
        JMenuItem mi2 = new JMenuItem("Quit");
        mi2.addActionListener(
                new ActionListener() {  // Game$1
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                }
        );
        m.add(mi);
        m.add(mi2);
        mb.add(m);
        setJMenuBar(mb);
    }

    public Game_Weiqi() {//设置窗口
        super("Wei Qi");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭方法
        //setResizable(false);//不可改变窗口大小
        setSize(1020, 1050);
        buildMenus();//添加菜单
        GameBoard b = new GameBoard();
        b.setBackground(Color.getHSBColor(35, 50, 85));
        Container c = getContentPane();
        c.add(BorderLayout.CENTER, b);
        setVisible(true);
    }

    public static void main(String[] args) {
        Game_Weiqi g = new Game_Weiqi();
    }
}

class GameBoard extends JPanel {//设置棋盘

    public GameBoard() {
        MoveListener m = new MoveListener();
        addMouseListener(m);
        addMouseMotionListener(m);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 1; i <= 19; i++) {
            g.drawLine(i * 50, 50, i * 50, 950);
        }
        for (int j = 1; j <= 19; j++) {
            g.drawLine(50, 50 * j, 950, 50 * j);
        }
        // g.fillOval(30,30,40,40);
        //for (int j = 1; j <=19 ; j++)

    }

    private class MoveListener implements MouseListener, MouseMotionListener {
        private int lastX, lastY, step = 0;
        int i = 0, j = 0, kx = 0, ky = 0;
        int[] a = new int[400];
        int[] b = new int[400];

        @Override
        public void mousePressed(MouseEvent e) {
            //GameBoard.this.getGraphics()
            lastX = e.getX();
            lastY = e.getY();
            System.out.println(lastX + "," + lastY);
            int x = (e.getX() + 25) / 50 * 50;
            int y = (e.getY() + 25) / 50 * 50;
            if (x < 25 || x > 975 || y < 25 || y > 975)
                System.out.println("Illegal!!Out Board!!");
            else {
                for (int ii = 0; ii < a.length; ii++) {
                    if (a[ii] == x)
                        kx = 1;
                }
                for (int jj = 0; jj < a.length; jj++) {
                    if (b[jj] == y)
                        ky = 1;
                }
                if (ky + kx == 2) {
                    System.out.println("Illegal!!occupied!!");
                    kx = 0;
                    ky = 0;
                } else {
                    a[i] = x;
                    i++;
                    b[i] = y;
                    y++;
                    Graphics g = getGraphics();
                    //g.setXORMode(Color.red);
                    if (step % 2 == 0) {
                        g.setColor(Color.black);
                        g.fillOval(x - 20, y - 20, 40, 40);
                    } else {
                        g.setColor(Color.white);
                        g.fillOval(x - 20, y - 20, 40, 40);
                    }
                    step++;
                    kx = 0;
                    ky = 0;
                }
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            /*Graphics g = getGraphics();
            g.setColor​(Color.blue);
            //g.setXORMode(Color.blue);
            g.drawOval(lastX-25, lastY-25, 50,50);

            g.drawOval(e.getX()-25, e.getY()-25, 50,50);
            lastX = e.getX(); lastY = e.getY();*/
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }

        @Override
        public void mouseMoved(MouseEvent me) {
        }

        @Override
        public void mouseClicked(MouseEvent me) {
        }

    }

}