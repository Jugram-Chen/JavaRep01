import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Donglin Chen
 */
public class ChatWindow extends JFrame {
    public ChatWindow(int w, int h, Color bg) {
        super("Stevens Chat");//calls JFrame(String title)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭方法
        this.setSize(w, h);//设置长宽
        Container c = this.getContentPane();//创建容器c
        c.setBackground(bg);//设置容器c背景色
        Font f = new Font("Times", Font.PLAIN, 24);//设置字体
        JButton b = new JButton("Start");//new一个JButton类的对象b，b中显示字符串start
        b.setFont(f);//设置b的字体
        c.add(b, BorderLayout.NORTH);//将b放到容器c的北边
        JTextField t = new JTextField("whatever");//new一个JTextField的对象t，在文本框里写whatever
        t.setFont(f);//将t中字体设置为f
        c.add(t, BorderLayout.SOUTH);//将文本框t放在容器c的南边
        JPanel p = new JPanel();//新建一个对象面板p
        p.setBackground(new Color(100, 150, 200));//设置p的颜色
        GridLayout g = new GridLayout(4, 3, 10, 10);//new一个格子类对象g，（行，列，行间距，列间距）
        p.setLayout(g);
        String[] names = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "="};
        for (int i = 0; i < 12; i++) {
            p.add(new JButton(names[i]));
        }
        p.setFont(f);
        c.add(p, BorderLayout.CENTER);

        JPanel p2 = new JPanel();
        GridLayout g2 = new GridLayout(4, 1, 5, 5);
        p2.setLayout(g2);
        String[] names2 = {"+", "-", "*", "÷"};
        for (int i = 0; i < 4; i++) {
            p2.add(new JButton(names2[i]));
        }
        c.add(p2, BorderLayout.EAST);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ChatWindow(1000, 800, Color.GREEN);


    }
}
